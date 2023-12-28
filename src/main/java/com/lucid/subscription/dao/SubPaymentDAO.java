/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lucid.subscription.entity.SubPayment;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:35:27 IST 2021
 */
public interface SubPaymentDAO extends JpaRepository<SubPayment, Long> {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  // ---------------------------------------------------------- Public Methods
  /**
   * @param subscriptionID
   * @return
   */
  @Query(" from SubPayment s where s.subscription.subscriptionID=?1")
  List<SubPayment> findBySubscriptionID(Long subscriptionID);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
