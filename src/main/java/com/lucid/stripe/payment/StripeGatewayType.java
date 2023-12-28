/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.stripe.payment;

import com.lucid.payment.PaymentGatewayType;

/**
 * @author sgutti
 * @date 15-Nov-2023 11:10:56 am
 */
public class StripeGatewayType extends PaymentGatewayType {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -3698058322878001107L;
    public static final PaymentGatewayType STRIPE = new PaymentGatewayType("Stripe", "stripe.com");
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
