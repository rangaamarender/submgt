/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.stripe.payment;

import com.lucid.payment.service.PaymentGatewayConfiguration;

/**
 * @author sgutti
 * @date 11-Nov-2023 10:04:54 pm
 */
public interface StripeConfiguration extends PaymentGatewayConfiguration {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * This is the merchant API Login ID, provided by the Merchant Interface.
     *
     * @return String
     */
    public String getApiKey();

    /**
     * This is the URL to which Authorize.net returns. This must be a publicly
     * accessible URL and also must be the same value you entered in your
     * account settings. (e.g. http://mycompany.com/authorizenet/process)
     *
     * @return String
     */

    public String getResponseUrl();

    /**
     * This is the URL to which Authorize.net returns upon a successful
     * transaction. (e.g. http://mycompany.com/confirmation)
     *
     * @return String
     */

    public String getConfirmUrl();

    /**
     * This is the URL to which Authorize.net returns upon a failed transaction.
     * (e.g. http://mycompany.com/authorizenet/error)
     *
     * @return String
     */

    public String getErrorUrl();

    /**
     * This is the URL to which Authorize.net returns upon a failed transaction.
     * Developer test environment:
     * https://test.authorize.net/gateway/transact.dll (Make sure xTestRequest
     * is set to false) Staging:
     * https://secure.authorize.net/gateway/transact.dll (Make sure xTestRequest
     * is set to true) Production:
     * https://secure.authorize.net/gateway/transact.dll (Make sure xTestRequest
     * is set to false)
     *
     * @return String
     */
    public String getServerUrl();

    /**
     * Slightly different than {@link #getServerUrl()} in that this is used to
     * communicate with the XML APIs. This does not have the
     * /gateway/transact.dll on the end of it and serves as a convenience method
     * for whatever is in {@link #getServerUrl()}
     * 
     * @return
     */
    public String getXMLBaseUrl();
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
