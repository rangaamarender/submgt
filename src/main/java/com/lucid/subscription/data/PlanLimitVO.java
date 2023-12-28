/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.data;

import com.lucid.core.vo.BaseVO;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:31:09 IST 2021
 */
public class PlanLimitVO extends BaseVO {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 1L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long planLimitID;
    private String planLimitCode;
    private String planLimitDesc;
    private Integer credits;
    private Integer availableCredits;
    private Long subscriptionID;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>PlanLimitVO</code>
     */
    public PlanLimitVO() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the planLimitID.
     */
    public Long getPlanLimitID() {
        return planLimitID;
    }

    /**
     * @param planLimitID
     *            The planLimitID to set.
     */
    public void setPlanLimitID(Long planLimitID) {
        this.planLimitID = planLimitID;
    }

    /**
     * @return Returns the planLimitCode.
     */
    public String getPlanLimitCode() {
        return planLimitCode;
    }

    /**
     * @param planLimitCode
     *            The planLimitCode to set.
     */
    public void setPlanLimitCode(String planLimitCode) {
        this.planLimitCode = planLimitCode;
    }

    /**
     * @return Returns the planLimitDesc.
     */
    public String getPlanLimitDesc() {
        return planLimitDesc;
    }

    /**
     * @param planLimitDesc
     *            The planLimitDesc to set.
     */
    public void setPlanLimitDesc(String planLimitDesc) {
        this.planLimitDesc = planLimitDesc;
    }

    /**
     * @return Returns the credits.
     */
    public Integer getCredits() {
        return credits;
    }

    /**
     * @param credits
     *            The credits to set.
     */
    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    /**
     * @return Returns the availableCredits.
     */
    public Integer getAvailableCredits() {
        return availableCredits;
    }

    /**
     * @param availableCredits
     *            The availableCredits to set.
     */
    public void setAvailableCredits(Integer availableCredits) {
        this.availableCredits = availableCredits;
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
