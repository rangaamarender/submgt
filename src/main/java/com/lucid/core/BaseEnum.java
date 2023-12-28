/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.core;

/**
 * BaseEnum to display enumerated values with meaningful labels, enumerations
 * should implement this interface.
 *
 * @author sgutti
 * @date 11-Nov-2023 2:04:50 pm
 */
public interface BaseEnum {

    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @return
     */
    public String getType();

    /**
     * @return
     */
    public String getFriendlyType();
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
