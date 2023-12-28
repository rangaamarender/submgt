/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.constants;

/**
 * @author sgutti
 * @date 02-Oct-2023 4:10:37 pm
 */
public class EnumPaymentStatus {
    // --------------------------------------------------------------- Constants
    public static final int NOT_PAID = 1;
    public static final int PARTIALLY_PAID = 2;
    public static final int PAID = 3;

    //
    public static final String NOT_PAID_STR = "NOT-PAID";
    public static final String PARTIALLY_PAID_STR = "PARTIALLY-PAID";
    public static final String PAID_STR = "PAID";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>EnumPaymentStatus</code>
     */
    private EnumPaymentStatus() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @param status
     * @return
     */
    public static String toString(int status) {
        if (status == NOT_PAID) {
            return NOT_PAID_STR;
        }
        if (status == PAID) {
            return PAID_STR;
        }
        if (status == PARTIALLY_PAID) {
            return PARTIALLY_PAID_STR;
        }
        return NOT_PAID_STR;
    }

    /**
     * @param status
     * @return
     */
    public static boolean isNotPaid(int status) {
        return (NOT_PAID == status);
    }

    /**
     * @param status
     * @return
     */
    public static boolean isPaid(int status) {
        return (PAID == status);
    }

    /**
     * @param status
     * @return
     */
    public static boolean isPartiallyPaid(int status) {
        return (PARTIALLY_PAID == status);
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
