/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.payment.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lucid.payment.entity.GtwyCustomerPymntProfile;

/**
 * @author sgutti
 * @date 23-Nov-2023 2:53:40 pm
 *
 */
public interface GtwyCustomerPymntProfileDAO
    extends JpaRepository<GtwyCustomerPymntProfile, String> {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  // ---------------------------------------------------------- Public Methods
  /**
   * @param gtwyCustomerProfileID
   * @return
   */
  @Query(" from GtwyCustomerPymntProfile g where g.gtwyCustomerProfileID=?1")
  List<GtwyCustomerPymntProfile> findByCustomerProfile(String gtwyCustomerProfileID);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
