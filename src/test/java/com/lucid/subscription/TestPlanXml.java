/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import java.io.File;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.lucid.base.test.BaseTest;
import com.lucid.subscription.jaxb.PlanType;
import com.lucid.subscription.jaxb.Plans;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

/**
 * @author sgutti
 * @date Jun 5, 2021 9:11:44 AM
 *
 */
public class TestPlanXml extends BaseTest {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>TestPlanXml</code>
   */
  public TestPlanXml() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  @Test
  public void testReadPlans() {
    try {
      File xmlFile = new File("src/test/resources/plans.xml");
      JAXBContext jaxbContext = JAXBContext.newInstance(Plans.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      Plans plans = (Plans) jaxbUnmarshaller.unmarshal(xmlFile);
      Assertions.assertNotNull(plans,"Got the plans");
      List<PlanType> planList=plans.getPlan();
      for (PlanType planType : planList) {
        System.out.println(planType.getPlanCode()+"\t"+planType.getPlanDescription());
      }
    } catch (JAXBException e) {
      e.printStackTrace();
    }

  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
