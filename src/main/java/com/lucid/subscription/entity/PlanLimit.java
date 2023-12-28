/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.entity;

import com.lucid.core.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:31:09 IST 2021
 */
@Entity
@Table(name = PlanLimit.TABLE_NAME)
public class PlanLimit extends BaseEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "PLAN_LIMIT";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAN_LIMIT_ID", nullable = false)
    private Long planLimitID;
    @Column(name = "PLAN_LIMIT_CODE", nullable = false, length = 25)
    private String planLimitCode;
    @Column(name = "PLAN_LIMIT_DESC", nullable = false, length = 200)
    private String planLimitDesc;
    @Column(name = "CREDITS", nullable = true)
    private Integer credits;
    @Column(name = "AVAILABLE_CREDITS", nullable = true)
    private Integer availableCredits;
    @Column(name = "COURTESY_CREDITS", nullable = true)
    private Integer courtesyCredits;
    @Column(name = "SUBSCRIPTION_ID", nullable = false)
    private Long subscriptionID;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUBSCRIPTION_ID", nullable = false, insertable = false, updatable = false)
    private Subscription subscription;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>PlanLimit</code>
     */
    public PlanLimit() {
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
     * @return Returns the courtesyCredits.
     */
    public Integer getCourtesyCredits() {
        return courtesyCredits;
    }

    /**
     * @param courtesyCredits
     *            The courtesyCredits to set.
     */
    public void setCourtesyCredits(Integer courtesyCredits) {
        this.courtesyCredits = courtesyCredits;
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

    /**
     * @return Returns the subscription.
     */
    public Subscription getSubscription() {
        return subscription;
    }

    /**
     * @param subscription
     *            The subscription to set.
     */
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
