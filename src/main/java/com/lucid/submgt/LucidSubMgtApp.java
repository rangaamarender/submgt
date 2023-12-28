/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.submgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author sgutti
 * @date 17-Dec-2022 4:42:14 pm
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.lucid"})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.lucid"})
@EnableTransactionManagement
@EntityScan(basePackages = {"com.lucid"})
@SpringBootApplication
public class LucidSubMgtApp extends SpringBootServletInitializer {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>LucidSubMgtApp</code>
   */
  public LucidSubMgtApp() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  // ------------------------------------------------------- Protected Methods
  /**
   * @see org.springframework.boot.web.servlet.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
   */
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(LucidSubMgtApp.class);
  }

  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  public static void main(String[] args) {
    SpringApplication.run(LucidSubMgtApp.class, args);
  }
  // ----------------------------------------------------------- Inner Classes
}
