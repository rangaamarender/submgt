/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lucid.subscription.entity.SubInvoiceItem;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:32:35 IST 2021
 */
public interface SubInvoiceItemDAO extends JpaRepository<SubInvoiceItem, Long> {
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
