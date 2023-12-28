/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.submgt.security;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;

/**
 * @author sgutti
 * @date 02-Dec-2023 2:39:07 pm
 *
 */
@Service
public class JwtTokenProvider {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expirationMs}")
  private long expirationMs;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>JwtTokenProvider</code>
   */
  public JwtTokenProvider() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  public String generateToken(Authentication authentication) {
    User principal = (User) authentication.getPrincipal();
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + expirationMs);

    return Jwts.builder().setSubject(principal.getUsername()).setIssuedAt(new Date())
        .setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, secret).compact();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
      return true;
    } catch (SignatureException | MalformedJwtException | ExpiredJwtException
        | UnsupportedJwtException | IllegalArgumentException ex) {
      return false;
    }
  }

  public String getUsernameFromToken(String token) {
    Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    return claims.getSubject();
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
