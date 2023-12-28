/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lucid.subscription.jaxb.PlanType;
import com.lucid.subscription.jaxb.Plans;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

/**
 * @author sgutti
 * @date Jun 19, 2021 6:43:21 PM
 *
 */
public class PlanConfig {
  // --------------------------------------------------------------- Constants
  private static final Logger LOGGER = LoggerFactory.getLogger(PlanConfig.class);
  private static final String PLANS_CONFIG_XML = "plans.xml";
  private static PlanConfig instance = new PlanConfig();
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  private List<PlanType> plansList;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>PlanConfig</code>
   */
  public PlanConfig() {
    super();
    initialize();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @return Returns the plansList.
   */
  public List<PlanType> getPlansList() {
    return plansList;
  }

  /**
   * @param planCode
   * @return
   */
  public PlanType getPlan(String planCode) {
    if (plansList == null || plansList.isEmpty()) {
      return null;
    }
    PlanType result = null;
    for (PlanType planType : plansList) {
      if (StringUtils.equals(planCode, planType.getPlanCode())) {
        result = planType;
        break;
      }
    }
    return result;
  }

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  private void initialize() {
    if (LOGGER.isInfoEnabled()) {
      LOGGER.info(" Initializing the Subscription Management Configuration ");
    }
    InputStream is = null;
    try {
      is = getConfig(PLANS_CONFIG_XML);
      if (is == null) {
        throw new RuntimeException(
            "ERROR:Cannot find the Subscription Configuration file." + PLANS_CONFIG_XML);
      }
      JAXBContext jaxbContext = JAXBContext.newInstance(Plans.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      Plans plans = (Plans) jaxbUnmarshaller.unmarshal(is);
      plansList = plans.getPlan();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      try {
        if (is != null)
          is.close();
      } catch (IOException e2) {
        if (LOGGER.isDebugEnabled()) {
          LOGGER.debug("IOException:" + e2.getMessage());
        }
      }
    }
    if (LOGGER.isInfoEnabled())
      LOGGER.info("***Done Parsing Subscription Management Configuration file ***");
  }


  /**
   * @param filename
   * @return
   */
  private InputStream getConfig(String filename) {
    return Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
  }

  // ---------------------------------------------------------- Static Methods
  /**
   * @return Returns the instance.
   */
  public static PlanConfig getInstance() {
    return instance;
  }
  // ----------------------------------------------------------- Inner Classes
}
