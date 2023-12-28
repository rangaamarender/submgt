/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.data;

/**
 * @author sgutti
 * @date 09-Nov-2023 10:47:41 pm
 */
public class CustomerCard {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String name;
    private String number;
    private String cvv;
    private String expiryMonth;
    private String expiryYear;
    // master/visa/jcb etc
    private String brand;
    // credit/debit/upi etc
    private String type;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>CustomerCard</code>
     */
    public CustomerCard() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
