/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.core.exception;

/**
 * @author sgutti
 * @date Sep 22, 2019 4:02:40 PM
 */
public abstract class BaseException extends Exception implements RootCauseAccessor {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -3732019724128352605L;

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String errorCode;
    private Throwable rootCause;
    // ------------------------------------------------------------ Constructors

    /**
     * Create a new <code>WebException</code>
     * 
     * @param message
     * @param cause
     */
    public BaseException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        if (cause != null) {
            rootCause = findRootCause(cause);
        } else {
            rootCause = this;
        }
    }

    /**
     * Create a new <code>BaseException</code>
     */
    public BaseException() {
        super();
    }

    /**
     * Create a new <code>BaseException</code>
     * 
     * @param message
     * @param cause
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
        if (cause != null) {
            rootCause = findRootCause(cause);
        } else {
            rootCause = this;
        }
    }

    /**
     * Create a new <code>BaseException</code>
     * 
     * @param message
     */
    public BaseException(String message) {
        super(message);
        this.rootCause = this;
    }

    /**
     * Create a new <code>BaseException</code>
     * 
     * @param cause
     */
    public BaseException(Throwable cause) {
        super(cause);
        if (cause != null) {
            rootCause = findRootCause(cause);
        }
    }

    /**
     * Create a new <code>WebException</code>
     * 
     * @param errorCode
     * @param message
     */
    public BaseException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.rootCause = this;
    }
    // ---------------------------------------------------------- Public Methods

    /**
     * @return Returns the errorCode.
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @see com.lucid.core.exception.RootCauseAccessor#getRootCause()
     */
    @Override
    public Throwable getRootCause() {
        return rootCause;
    }

    /**
     * @see com.lucid.core.exception.RootCauseAccessor#getRootCauseMessage()
     */
    @Override
    public String getRootCauseMessage() {
        if (rootCause != null) {
            return rootCause.getMessage();
        } else {
            return getMessage();
        }
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    /**
     * @param cause
     * @return
     */
    private Throwable findRootCause(Throwable cause) {
        Throwable rootCause = cause;
        while (rootCause != null && rootCause.getCause() != null) {
            rootCause = rootCause.getCause();
        }
        return rootCause;
    }
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes

}
