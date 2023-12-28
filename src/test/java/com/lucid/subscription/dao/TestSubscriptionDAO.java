/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription.dao;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.lucid.base.test.BaseTransactionTest;
import com.lucid.subscription.entity.Subscription;

/**
 * @author sgutti
 * @date May 15, 2021 1:45:48 PM
 */
public class TestSubscriptionDAO extends BaseTransactionTest {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Autowired
  private SubscriptionDAO subscriptionDAO;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>TestSubscriptionDAO</code>
   */
  public TestSubscriptionDAO() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * 
   */
  @Test
  public void testFindAll() {
    List<Subscription> list = subscriptionDAO.findAll();
    Assertions.assertNotNull(list);
  }

  @Test
  public void testFind() {
    Optional<Subscription> list = subscriptionDAO.findById(3l);
    Assertions.assertNotNull(list);
  }

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
