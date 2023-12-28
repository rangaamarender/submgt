/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.submgt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author sgutti
 * @date 02-Dec-2023 8:53:06 am
 *
 */
// @Configuration
// @EnableWebSecurity
public class WebSecurityConfig {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Autowired
  private JwtAuthConverter jwtAuthConverter;
  @Autowired
  private JwtTokenProvider jwtTokenProvider;
  @Autowired
  private AuthenticationManager authenticationManager;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>WebSecurityConfig</code>
   */
  public WebSecurityConfig() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
            .requestMatchers(HttpMethod.GET, "/api/movies", "/api/movies/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/actuator/**").permitAll()
            // .requestMatchers("/api/movies/*/comments").hasAnyRole(MOVIES_MANAGER, MOVIES_USER)
            // .requestMatchers("/api/movies", "/api/movies/**").hasRole(MOVIES_MANAGER)
            // .requestMatchers("/api/userextras/me").hasAnyRole(MOVIES_MANAGER, MOVIES_USER)
            .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs",
                "/v3/api-docs/**")
            .permitAll().anyRequest().authenticated())

        .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer
            .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter)))
        .addFilter(new JwtAuthenticationFilter(authenticationManager, jwtTokenProvider))

        .sessionManagement(sessionManagement -> sessionManagement
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .cors(Customizer.withDefaults()).build();
  }


  // @Bean
  // public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
  // return http.getSharedObject(AuthenticationManagerBuilder.class).build();
  // }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
