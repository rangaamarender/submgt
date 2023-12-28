/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.stripe.payment;

import org.springframework.stereotype.Service;
import com.lucid.payment.service.AbstractPaymentGatewayConfigurationService;

/**
 * @author sgutti
 * @date 07-Dec-2023 10:07:18 pm
 *
 */
@Service("blPaymentGatewayConfigurationServices")
public class StripeConfigurationService extends AbstractPaymentGatewayConfigurationService {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>StripeConfigurationService</code>
   */
  public StripeConfigurationService() {
    super();
  }
  // ---------------------------------------------------------- Public Methods
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
