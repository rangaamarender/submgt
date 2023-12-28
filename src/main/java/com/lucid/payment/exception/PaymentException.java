/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.exception;

import com.lucid.core.exception.BaseException;

/**
 * @author sgutti
 * @date 11-Nov-2023 1:03:58 pm
 */
public class PaymentException extends BaseException {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -3308552550528637858L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>PaymentException</code>
     * 
     * @param errorCode
     * @param message
     * @param cause
     */
    public PaymentException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    /**
     * Create a new <code>PaymentException</code>
     * 
     * @param errorCode
     * @param message
     */
    public PaymentException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Create a new <code>PaymentException</code>
     */
    public PaymentException() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Create a new <code>PaymentException</code>
     * 
     * @param message
     * @param cause
     */
    public PaymentException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Create a new <code>PaymentException</code>
     * 
     * @param message
     */
    public PaymentException(String message) {
        super(message);
    }

    /**
     * Create a new <code>PaymentException</code>
     * 
     * @param cause
     */
    public PaymentException(Throwable cause) {
        super(cause);
    }

    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
