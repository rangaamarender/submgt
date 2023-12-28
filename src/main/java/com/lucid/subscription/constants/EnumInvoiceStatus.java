/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.constants;

/**
 * @author sgutti
 * @date 02-Oct-2023 4:06:15 pm
 */
public class EnumInvoiceStatus {
    // --------------------------------------------------------------- Constants
    public static final int OPEN = 1;
    public static final int CLOSED = 2;

    public static final String OPEN_STR = "OPEN";
    public static final String CLOSED_STR = "CLOSED";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>EnumInvoiceStatus</code>
     */
    private EnumInvoiceStatus() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @param status
     * @return
     */
    public static String toString(int status) {
        if (status == OPEN) {
            return OPEN_STR;
        }
        if (status == CLOSED) {
            return CLOSED_STR;
        }
        return OPEN_STR;
    }

    /**
     * @param status
     * @return
     */
    public static boolean isOpen(int status) {
        return (OPEN == status);
    }

    /**
     * @param status
     * @return
     */
    public static boolean isClosed(int status) {
        return (CLOSED == status);
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
