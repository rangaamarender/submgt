/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.config;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.lucid.base.test.BaseTest;
import com.lucid.subscription.jaxb.PlanType;

/**
 * @author sgutti
 * @date Jun 19, 2021 6:56:34 PM
 *
 */
public class TestPlanConfig extends BaseTest {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>TestPlanConfig</code>
   */
  public TestPlanConfig() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  @Test
  public void testPlansConfig() {
    List<PlanType> plans = PlanConfig.getInstance().getPlansList();
    Assertions.assertEquals(3, plans.size());
  }

  @Test
  public void testPlanConfig() {
    PlanType plan = PlanConfig.getInstance().getPlan("BASE");
    Assertions.assertEquals("BASE", plan.getPlanCode(), "Got the " + plan.getPlanDescription());
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
