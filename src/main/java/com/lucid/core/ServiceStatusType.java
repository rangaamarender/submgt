/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.core;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sgutti
 * @date 11-Nov-2023 2:07:59 pm
 */
public class ServiceStatusType implements Serializable, BaseEnum {

    // --------------------------------------------------------------- Constants
    private static final Map<String, ServiceStatusType> TYPES = new LinkedHashMap<String, ServiceStatusType>();

    public static final ServiceStatusType UP = new ServiceStatusType("UP", "Up");
    public static final ServiceStatusType DOWN = new ServiceStatusType("DOWN", "Down");
    public static final ServiceStatusType PAUSED = new ServiceStatusType("PAUSED", "Paused");

    // --------------------------------------------------------- Class Variables

    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String type;
    private String friendlyType;
    // ------------------------------------------------------------ Constructors

    /**
     * Create a new <code>ServiceStatusType</code>
     */
    public ServiceStatusType() {
        super();
    }

    /**
     * Create a new <code>ServiceStatusType</code>
     * 
     * @param type
     * @param friendlyType
     */
    public ServiceStatusType(String type, String friendlyType) {
        super();
        this.friendlyType = friendlyType;
        setType(type);
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @see com.lucid.core.BaseEnum#getType()
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * @see com.lucid.core.BaseEnum#getFriendlyType()
     */
    @Override
    public String getFriendlyType() {
        return friendlyType;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!getClass().isAssignableFrom(obj.getClass()))
            return false;
        ServiceStatusType other = (ServiceStatusType) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    /**
     * @param type
     */
    private void setType(final String type) {
        this.type = type;
        if (!TYPES.containsKey(type)) {
            TYPES.put(type, this);
        } else {
            throw new RuntimeException("Cannot add the type: (" + type + "). It already exists as a type via "
                    + getInstance(type).getClass().getName());
        }
    }

    // ---------------------------------------------------------- Static Methods
    public static ServiceStatusType getInstance(final String type) {
        return TYPES.get(type);
    }

    // ----------------------------------------------------------- Inner Classes
}
