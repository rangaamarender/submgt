/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.constants;

/**
 * @author sgutti
 * @date May 16, 2021 12:08:02 AM
 */
public class EnumSubStatus {
    // --------------------------------------------------------------- Constants
    public static final int PENDING = 0;
    public static final int UNAUTHORIZED = 1;
    public static final int AUTHORIZED = 2;
    public static final int CANCELLED = 3;
    public static final int EXPIRED = 4;
    public static final int TRAIL_EXPIRED = 5;

    public static final String PENDING_STR = "PENDING";
    public static final String UNAUTHORIZED_STR = "UNAUTHORIZED";
    public static final String AUTHORIZED_STR = "AUTHORIZED";
    public static final String CANCELLED_STR = "CANCELLED";
    public static final String EXPIRED_STR = "EXPIRED";
    public static final String TRAIL_EXPIRED_STR = "TRAIL-EXPIRED";

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>EnumSubStatus</code>
     */
    private EnumSubStatus() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @param status
     * @return
     */
    public static String toString(int status) {
        if (status == PENDING) {
            return PENDING_STR;
        }
        if (status == UNAUTHORIZED) {
            return UNAUTHORIZED_STR;
        }
        if (status == AUTHORIZED) {
            return AUTHORIZED_STR;
        }
        if (status == CANCELLED) {
            return CANCELLED_STR;
        }
        if (status == EXPIRED) {
            return EXPIRED_STR;
        }
        if (status == TRAIL_EXPIRED) {
            return TRAIL_EXPIRED_STR;
        }
        return "UNKNOWN";
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
