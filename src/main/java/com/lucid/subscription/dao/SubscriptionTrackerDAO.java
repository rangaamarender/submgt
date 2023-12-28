/**
 * eCurve Inc. All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lucid.subscription.entity.SubscriptionTracker;

/**
 * @author sgutti
 * @date Mar 5, 2022 4:47:22 PM
 *
 */
public interface SubscriptionTrackerDAO extends JpaRepository<SubscriptionTracker, Long> {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  // ---------------------------------------------------------- Public Methods
  /**
   * @param trackerCode
   * @return
   */
  @Query(" from SubscriptionTracker s where s.trackerCode=?1")
  public SubscriptionTracker findTracker(String trackerCode);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
