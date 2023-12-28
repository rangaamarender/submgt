/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lucid.tenant.entity.TenantProfile;

/**
 * @author sgutti
 * @date 22-Nov-2023 4:30:10 pm
 *
 */
public interface TenantProfileDAO extends JpaRepository<TenantProfile, Long> {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  // ---------------------------------------------------------- Public Methods
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
