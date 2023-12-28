/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.stripe.payment;

import org.springframework.stereotype.Component;

import com.lucid.payment.service.AbstractPaymentGatewayConfiguration;

/**
 * @author sgutti
 * @date 14-Nov-2023 7:48:59 pm
 */
@Component(StripeConfigurationImpl.SERVICE_NAME)
public class StripeConfigurationImpl extends AbstractPaymentGatewayConfiguration implements StripeConfiguration {
    // --------------------------------------------------------------- Constants
    public static final String SERVICE_NAME = "stripeConfiguration";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>StripeConfigurationImpl</code>
     */
    public StripeConfigurationImpl() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @see com.lucid.stripe.payment.StripeConfiguration#getApiKey()
     */
    @Override
    public String getApiKey() {
        return "sk_test_51N2yuTSFjPlsQ2rQG6ZlnE8O8FNDleZiHtcd2VlIwROP2Rrl8hq2K8AZp7hUG9xFDNZ1O7HrsfHItrDKqkqXeXNp00kmo6xekV";
    }

    /**
     * @see com.lucid.stripe.payment.StripeConfiguration#getResponseUrl()
     */
    @Override
    public String getResponseUrl() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see com.lucid.stripe.payment.StripeConfiguration#getConfirmUrl()
     */
    @Override
    public String getConfirmUrl() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see com.lucid.stripe.payment.StripeConfiguration#getErrorUrl()
     */
    @Override
    public String getErrorUrl() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see com.lucid.stripe.payment.StripeConfiguration#getServerUrl()
     */
    @Override
    public String getServerUrl() {
        return "https://api.stripe.com";
    }

    /**
     * @see com.lucid.stripe.payment.StripeConfiguration#getXMLBaseUrl()
     */
    @Override
    public String getXMLBaseUrl() {
        // TODO Auto-generated method stub
        return null;
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes

}
