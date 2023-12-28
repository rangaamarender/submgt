/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.submgt.security;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author sgutti
 * @date 02-Dec-2023 2:54:40 pm
 *
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  private final AuthenticationManager authenticationManager;
  private final JwtTokenProvider jwtTokenProvider;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>JwtAuthenticationFilter</code>
   * 
   * @param authenticationManager
   * @param jwtTokenProvider
   */
  public JwtAuthenticationFilter(AuthenticationManager authenticationManager,
      JwtTokenProvider jwtTokenProvider) {
    this.authenticationManager = authenticationManager;
    this.jwtTokenProvider = jwtTokenProvider;
  }
  // ---------------------------------------------------------- Public Methods

  /**
   * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(jakarta.servlet.http.HttpServletRequest,
   *      jakarta.servlet.http.HttpServletResponse, jakarta.servlet.FilterChain)
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    try {
      String token = extractToken(request);

      if (token != null && jwtTokenProvider.validateToken(token)) {
        String username = jwtTokenProvider.getUsernameFromToken(token);
        UserDetails userDetails = new User(username, "", new ArrayList<>());

        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      }
    } catch (Exception ex) {
      logger.error("Authentication error", ex);
    }

    filterChain.doFilter(request, response);
  }



  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  private String extractToken(HttpServletRequest request) {
    // Implement logic to extract the token from the request (e.g., from headers or cookies)
    // This may involve using a library like Apache Commons Cookie or Spring's CookieValue
    // annotation
    return null;
  }
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
