/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.core.base;

import com.lucid.core.exception.ApplicationException;

/**
 * @author sgutti
 * @date Oct 26, 2019 11:41:57 PM
 */
public abstract class BaseServiceImpl implements BaseService {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>BaseServiceImpl</code>
   */
  public BaseServiceImpl() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @param tenantID
   * @throws ApplicationException
   */
  public void throwExceptionIfNoTenant(long tenantID) throws ApplicationException {
    //
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
