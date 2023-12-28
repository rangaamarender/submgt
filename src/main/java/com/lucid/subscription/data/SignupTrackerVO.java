/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.data;

import java.util.Date;

import com.lucid.core.constants.EnumStatus;
import com.lucid.core.vo.BaseVO;

/**
 * @author sgutti
 * @date 07-Oct-2023 7:52:47 pm
 */
public class SignupTrackerVO extends BaseVO {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 7400923004588998353L;

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String emailID;
    private String companyName;
    private Integer count;
    private Date createdDt;
    private Date lastUpdatedDt;
    private String trackerCode;
    private Integer status;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>SignupTrackerVO</code>
     */
    public SignupTrackerVO() {
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

    public boolean isActive() {
        return EnumStatus.isActiveBoo(status);
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
