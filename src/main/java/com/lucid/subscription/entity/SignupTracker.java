/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.entity;

import java.util.Date;

import com.lucid.core.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author sgutti
 * @date 07-Oct-2023 4:21:14 pm
 */
@Entity(name = SignupTracker.TABLE_NAME)
@Table
public class SignupTracker extends BaseEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -2977784626433607397L;
    public static final String TABLE_NAME = "signup_tracker";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Id
    @Column(name = "EMAIL_ID", nullable = false, length = 150)
    private String emailID;
    @Column(name = "COMPANY_NAME", nullable = false, length = 100)
    private String companyName;
    @Column(name = "COUNT", nullable = false)
    private Integer count;
    @Column(name = "CREATED_DT", nullable = true)
    private Date createdDt;
    @Column(name = "LAST_UPDATED_DT", nullable = true)
    private Date lastUpdatedDt;
    @Column(name = "TRACKER_CODE", nullable = false, length = 100)
    private String trackerCode;
    @Column(name = "STATUS", nullable = false)
    private Integer status;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>SignupTracker</code>
     */
    public SignupTracker() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the emailID.
     */
    public String getEmailID() {
        return emailID;
    }

    /**
     * @param emailID
     *            The emailID to set.
     */
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    /**
     * @return Returns the companyName.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     *            The companyName to set.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return Returns the count.
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     *            The count to set.
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return Returns the createdDt.
     */
    public Date getCreatedDt() {
        return createdDt;
    }

    /**
     * @param createdDt
     *            The createdDt to set.
     */
    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    /**
     * @return Returns the lastUpdatedDt.
     */
    public Date getLastUpdatedDt() {
        return lastUpdatedDt;
    }

    /**
     * @param lastUpdatedDt
     *            The lastUpdatedDt to set.
     */
    public void setLastUpdatedDt(Date lastUpdatedDt) {
        this.lastUpdatedDt = lastUpdatedDt;
    }

    /**
     * @return Returns the trackerCode.
     */
    public String getTrackerCode() {
        return trackerCode;
    }

    /**
     * @param trackerCode
     *            The trackerCode to set.
     */
    public void setTrackerCode(String trackerCode) {
        this.trackerCode = trackerCode;
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
