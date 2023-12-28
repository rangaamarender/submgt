/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.submgt.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * @author sgutti
 * @date 02-Dec-2023 1:26:02 pm
 *
 */
@Validated
@Configuration
@ConfigurationProperties(prefix = "jwt.auth.converter")
public class JwtAuthConverterProperties {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  private String resourceId;
  private String principalAttribute;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>JwtAuthConverterProperties</code>
   */
  public JwtAuthConverterProperties() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @return Returns the resourceId.
   */
  public String getResourceId() {
    return resourceId;
  }

  /**
   * @param resourceId The resourceId to set.
   */
  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  /**
   * @return Returns the principalAttribute.
   */
  public String getPrincipalAttribute() {
    return principalAttribute;
  }

  /**
   * @param principalAttribute The principalAttribute to set.
   */
  public void setPrincipalAttribute(String principalAttribute) {
    this.principalAttribute = principalAttribute;
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
