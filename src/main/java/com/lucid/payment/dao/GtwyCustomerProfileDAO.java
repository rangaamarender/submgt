/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lucid.payment.entity.GtwyCustomerProfile;

/**
 * @author sgutti
 * @date 23-Nov-2023 2:53:40 pm
 *
 */
public interface GtwyCustomerProfileDAO extends JpaRepository<GtwyCustomerProfile, String> {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  // ---------------------------------------------------------- Public Methods
  @Query(" from GtwyCustomerProfile g where g.subscriptionID=?1 and g.gtwyID=?2")
  GtwyCustomerProfile findBy(long subscriptionID, String gtwyID);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
