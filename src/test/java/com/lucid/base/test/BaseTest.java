/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.base.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import com.github.javafaker.Faker;
import com.lucid.submgt.LucidSubMgtApp;

/**
 * @author sgutti
 * @date May 20, 2017 10:33:07 PM
 */
@SpringBootTest(classes = LucidSubMgtApp.class)
public abstract class BaseTest extends AbstractJUnit4SpringContextTests {
  // --------------------------------------------------------------- Constants
  public static Faker FAKER = new Faker();

  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>BaseTest</code>
   */
  public BaseTest() {
    super();
  }
  // ---------------------------------------------------------- Public Methods
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
