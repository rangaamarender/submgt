/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.constants;

import java.io.File;

/**
 * @author sgutti
 * @date Mar 5, 2022 10:17:33 AM
 */
public class EnumSubscription {
    // --------------------------------------------------------------- Constants
    public static final String DEFAULT_PLAN_CODE = "BASE";
    public static final String SIGNUP_EMAIL_TEMPLATE = "signup.html";
    public static final String WC_EMAIL_TEMPLATE = "subscription.html";
    public static final String AS_EMAIL_TEMPLATE = "subscriptionActivated.html";
    //
    public static final String COMPANY = "COMPANY";
    public static final String URL = "URL";
    public static final String NAME = "NAME";
    public static final String LOGIN_URL = "LOGIN_URL";

    public static final String EMAIL_TEMPLATES = "templates" + File.separatorChar + "emails";

    //
    public static final int TRIAL_PHASE = 1;
    public static final int BILLING_PHASE = 2;

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>EnumSubscription</code>
     */
    private EnumSubscription() {
        super();
    }
    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
