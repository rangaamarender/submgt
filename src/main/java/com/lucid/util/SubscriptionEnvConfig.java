/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author sgutti
 * @date Jul 24, 2022 5:30:50 PM
 */
@Component(value = SubscriptionEnvConfig.NAME)
public class SubscriptionEnvConfig implements EnvConfig {

    // --------------------------------------------------------------- Constants
    public static final String NAME = "envConfig";
    public static final String NO_REPLY_EMAIL_ADDR = "submgt.noreplyEmailAddress";
    private static final String PROD_MODE = "PROD";
    private static final String ENV_MODE = "submgt.env.mode";
    private static final String LOGIN_URL = "submgt.loginURL";
    private static final String SUBSCRIPTION_INIT = "submgt.subscriptionInit";
    private static final String DEFAULT_USER_PASSWD = "submgt.defaultUserPasswd";
    private static final String SUPPORT_EMAIL_ADDRESS = "submgt.supportEmailAddress";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private Environment env;

    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the noreplyEmailAddress.
     */
    public String getNoreplyEmailAddress() {
        return env.getProperty(NO_REPLY_EMAIL_ADDR);
    }

    /**
     * @return Returns the supportEmailAddress.
     */
    public String getSupportEmailAddress() {
        return env.getProperty(SUPPORT_EMAIL_ADDRESS);
    }

    /**
     * @return
     */
    public String getDefaultPassword() {
        return env.getProperty(DEFAULT_USER_PASSWD);
    }

    /**
     * @return Returns the noreplyEmailAddress.
     */
    public String getSubscriptionInitURL(String code) {
        String value = env.getProperty(SUBSCRIPTION_INIT);
        return value + code;
    }

    /**
     * @return
     */
    public String getLoginURL() {
        return env.getProperty(LOGIN_URL);
    }

    /**
     * @return
     */
    public boolean isProdMode() {
        String mode = env.getProperty(ENV_MODE);
        return StringUtils.equals(PROD_MODE, mode);
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
