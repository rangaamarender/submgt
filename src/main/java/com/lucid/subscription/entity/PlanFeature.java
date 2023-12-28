/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.entity;

import java.util.Date;

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
 * @date Sat May 15 13:30:33 IST 2021
 */
@Entity
@Table(name = PlanFeature.TABLE_NAME)
public class PlanFeature extends BaseEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "PLAN_FEATURE";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FEATURE_ID", nullable = false)
    private Long featureID;
    @Column(name = "FEATURE_DESC", nullable = false, length = 200)
    private String featureDesc;
    @Column(name = "FEATURE_CODE", nullable = false, length = 25)
    private String featureCode;
    @Column(name = "START_DT", nullable = false)
    private Date startDt;
    @Column(name = "END_DT", nullable = false)
    private Date endDt;
    @Column(name = "STATUS", nullable = false)
    private Integer status;
    @Column(name = "SUBSCRIPTION_ID", nullable = false)
    private Long subscriptionID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUBSCRIPTION_ID", nullable = false, insertable = false, updatable = false)
    private Subscription subscription;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>PlanFeature</code>
     */
    public PlanFeature() {
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
