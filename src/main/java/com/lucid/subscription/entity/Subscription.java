/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription.entity;

import java.util.Date;
import com.lucid.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:26:33 IST 2021
 */
@Entity
@Table(name = Subscription.TABLE_NAME)
public class Subscription extends BaseEntity {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 1L;
  public static final String TABLE_NAME = "SUBSCRIPTION";
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Id
  @Column(name = "SUBSCRIPTION_ID", nullable = false)
  private Long subscriptionID;
  @Column(name = "ACCT_NBR", nullable = false, length = 25)
  private String acctNbr;
  @Column(name = "PLAN_CODE", nullable = true, length = 25)
  private String planCode;
  @Column(name = "PLAN_DESC", nullable = false, length = 200)
  private String planDesc;
  @Column(name = "START_DT", nullable = true)
  private Date startDt;
  @Column(name = "END_DT", nullable = false)
  private Date endDt;
  @Column(name = "TENANT_ID", nullable = false)
  private Long tenantID;
  @Column(name = "CREATED_DT", nullable = false)
  private Date createdDt;
  @Column(name = "STATUS", nullable = false)
  private Integer status;
  @Column(name = "APPROVED_BY", nullable = true, length = 100)
  private String approvedBy;
  @Column(name = "APPROVED_DT", nullable = true)
  private Date approvedDt;
  @Column(name = "PHASE", nullable = false)
  private Integer phase;
  @Column(name = "TRAIL_DAYS", nullable = false)
  private Integer trailDays;

  @Column(name = "AUTO_PAY", nullable = true)
  private Boolean autoPay = Boolean.FALSE;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>Subscription</code>
   */
  public Subscription() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @return Returns the subscriptionID.
   */
  public long getSubscriptionID() {
    return subscriptionID;
  }

  /**
   * @param subscriptionID The subscriptionID to set.
   */
  public void setSubscriptionID(Long subscriptionID) {
    this.subscriptionID = subscriptionID;
  }

  /**
   * @return Returns the acctNbr.
   */
  public String getAcctNbr() {
    return acctNbr;
  }

  /**
   * @param acctNbr The acctNbr to set.
   */
  public void setAcctNbr(String acctNbr) {
    this.acctNbr = acctNbr;
  }

  /**
   * @return Returns the tenantID.
   */
  public Long getTenantID() {
    return tenantID;
  }

  /**
   * @param tenantID The tenantID to set.
   */
  public void setTenantID(Long tenantID) {
    this.tenantID = tenantID;
  }

  /**
   * @return Returns the createdDt.
   */
  public Date getCreatedDt() {
    return createdDt;
  }

  /**
   * @param createdDt The createdDt to set.
   */
  public void setCreatedDt(Date createdDt) {
    this.createdDt = createdDt;
  }

  /**
   * @return Returns the status.
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * @param status The status to set.
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * @return Returns the approvedBy.
   */
  public String getApprovedBy() {
    return approvedBy;
  }

  /**
   * @param approvedBy The approvedBy to set.
   */
  public void setApprovedBy(String approvedBy) {
    this.approvedBy = approvedBy;
  }

  /**
   * @return Returns the approvedDt.
   */
  public Date getApprovedDt() {
    return approvedDt;
  }

  /**
   * @param approvedDt The approvedDt to set.
   */
  public void setApprovedDt(Date approvedDt) {
    this.approvedDt = approvedDt;
  }

  /**
   * @return Returns the phase.
   */
  public Integer getPhase() {
    return phase;
  }

  /**
   * @param phase The phase to set.
   */
  public void setPhase(Integer phase) {
    this.phase = phase;
  }

  /**
   * @return Returns the trailDays.
   */
  public Integer getTrailDays() {
    return trailDays;
  }

  /**
   * @param trailDays The trailDays to set.
   */
  public void setTrailDays(Integer trailDays) {
    this.trailDays = trailDays;
  }


  /**
   * @return Returns the planCode.
   */
  public String getPlanCode() {
    return planCode;
  }

  /**
   * @param planCode The planCode to set.
   */
  public void setPlanCode(String planCode) {
    this.planCode = planCode;
  }

  /**
   * @return Returns the planDesc.
   */
  public String getPlanDesc() {
    return planDesc;
  }

  /**
   * @param planDesc The planDesc to set.
   */
  public void setPlanDesc(String planDesc) {
    this.planDesc = planDesc;
  }

  /**
   * @return Returns the startDt.
   */
  public Date getStartDt() {
    return startDt;
  }

  /**
   * @param startDt The startDt to set.
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
   * @param endDt The endDt to set.
   */
  public void setEndDt(Date endDt) {
    this.endDt = endDt;
  }

  /**
   * @return Returns the autoPay.
   */
  public Boolean getAutoPay() {
    return autoPay;
  }

  /**
   * @param autoPay The autoPay to set.
   */
  public void setAutoPay(Boolean autoPay) {
    this.autoPay = autoPay;
  }

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
