/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.entity;

import com.lucid.core.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author sgutti
 * @date 30-Mar-2023 9:05:28 pm
 */
@Entity
@Table(name = SystemRegistry.TABLE_NAME)
public class SystemRegistry extends BaseEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 1521253786309503457L;
    public static final String TABLE_NAME = "sys_regsitry";

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "sys_registry_id", nullable = false, length = 75)
    private String systemRegistryID;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "value", nullable = false, length = 150)
    private String value;

    @Column(name = "dataType", nullable = false, length = 15)
    private String dataType;

    @Column(name = "status", nullable = false)
    private Integer status;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>SystemRegistry</code>
     */
    public SystemRegistry() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the systemRegistryID.
     */
    public String getSystemRegistryID() {
        return systemRegistryID;
    }

    /**
     * @param systemRegistryID
     *            The systemRegistryID to set.
     */
    public void setSystemRegistryID(String systemRegistryID) {
        this.systemRegistryID = systemRegistryID;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the value.
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            The value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return Returns the dataType.
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @param dataType
     *            The dataType to set.
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * @return Returns the status.
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     *            The status to set.
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
