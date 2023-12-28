/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.submgt.security;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

/**
 * @author sgutti
 * @date 02-Dec-2023 1:24:35 pm
 *
 */
@Component
public class JwtAuthConverter
    implements Converter<org.springframework.security.oauth2.jwt.Jwt, AbstractAuthenticationToken> {
  // --------------------------------------------------------------- Constants
  private static final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter =
      new JwtGrantedAuthoritiesConverter();

  private final JwtAuthConverterProperties properties;

  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>JwtAuthConverter</code>
   * 
   * @param properties
   */
  public JwtAuthConverter(JwtAuthConverterProperties properties) {
    super();
    this.properties = properties;
  }


  // ---------------------------------------------------------- Public Methods
  @Override
  public AbstractAuthenticationToken convert(Jwt jwt) {
    Collection<GrantedAuthority> authorities =
        Stream.concat(jwtGrantedAuthoritiesConverter.convert(jwt).stream(),
            extra̋ctResourceRoles(jwt).stream()).collect(Collectors.toSet());
    String claimName = properties.getPrincipalAttribute() == null ? JwtClaimNames.SUB
        : properties.getPrincipalAttribute();
    return new JwtAuthenticationToken(jwt, authorities, jwt.getClaim(claimName));
  }

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  /**
   * @param jwt
   * @return
   */
  private Collection<? extends GrantedAuthority> extra̋ctResourceRoles(Jwt jwt) {
    Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
    Map<String, Object> resource;
    Collection<String> resourceRoles;
    if (resourceAccess == null
        || (resource = (Map<String, Object>) resourceAccess.get(properties.getResourceId())) == null
        || (resourceRoles = (Collection<String>) resource.get("roles")) == null) {
      return Set.of();
    }
    return resourceRoles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role))
        .collect(Collectors.toSet());
  }
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
