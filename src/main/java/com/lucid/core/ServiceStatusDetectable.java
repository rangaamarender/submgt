/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.core;

/**
 * @author sgutti
 * @date 11-Nov-2023 2:12:13 pm
 */
public interface ServiceStatusDetectable<T> {

    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @return
     */
    public ServiceStatusType getServiceStatus();

    /**
     * @return
     */
    public String getServiceName();

    /**
     * @param arg
     * @return
     * @throws Exception
     */
    public Object process(T arg) throws Exception;
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
