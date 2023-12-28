/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.data;

import java.util.Date;

import com.lucid.core.constants.EnumStatus;
import com.lucid.core.vo.BaseVO;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:30:33 IST 2021
 */
public class PlanFeatureVO extends BaseVO {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 1L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long featureID;
    private String featureDesc;
    private String featureCode;
    private Date startDt;
    private Date endDt;
    private Integer status;
    private Long subscriptionID;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>PlanFeatureVO</code>
     */
    public PlanFeatureVO() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the featureID.
     */
    public Long getFeatureID() {
        return featureID;
    }

    /**
     * @param featureID
     *            The featureID to set.
     */
    public void setFeatureID(Long featureID) {
        this.featureID = featureID;
    }

    /**
     * @return Returns the featureDesc.
     */
    public String getFeatureDesc() {
        return featureDesc;
    }

    /**
     * @param featureDesc
     *            The featureDesc to set.
     */
    public void setFeatureDesc(String featureDesc) {
        this.featureDesc = featureDesc;
    }

    /**
     * @return Returns the featureCode.
     */
    public String getFeatureCode() {
        return featureCode;
    }

    /**
     * @param featureCode
     *            The featureCode to set.
     */
    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    /**
     * @return Returns the startDt.
     */
    public Date getStartDt() {
        return startDt;
    }

    /**
     * @param startDt
     *            The startDt to set.
     */
    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    /**
     * @return Returns the endDt.
     */
    public Date getEndDt() {
        return endDt;
    }

    /**
     * @param endDt
     *            The endDt to set.
     */
    public void setEndDt(Date endDt) {
        this.endDt = endDt;
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

    /**
     * @return
     */
    public String getStatusStr() {
        return EnumStatus.toString(status);
    }

    /**
     * @return Returns the subscriptionID.
     */
    public Long getSubscriptionID() {
        return subscriptionID;
    }

    /**
     * @param subscriptionID
     *            The subscriptionID to set.
     */
    public void setSubscriptionID(Long subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
