/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lucid.tenant.entity.TenantAddress;

/**
 * @author sgutti
 * @date 23-Nov-2023 3:25:50 pm
 *
 */
public interface TenantAddressDAO extends JpaRepository<TenantAddress, java.lang.Long> {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  // ---------------------------------------------------------- Public Methods
  /**
   * @param tenantID
   * @return
   */
  @Query(" from TenantAddress t where t.tenantID=?1 and t.addressType='BILLING'")
  TenantAddress findBillingAddress(long tenantID);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
