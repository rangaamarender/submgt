/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.entity;

import java.math.BigDecimal;
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
 * @date Sat May 15 13:35:27 IST 2021
 */
@Entity
@Table(name = SubPayment.TABLE_NAME)
public class SubPayment extends BaseEntity {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 1L;
  public static final String TABLE_NAME = "SUBR_PYMNT";
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "SUB_PYMNT_ID", nullable = false)
  private Long subPymntID;
  @Column(name = "PYMNT_AMT", nullable = false)
  private BigDecimal pymntAmt;
  @Column(name = "PYMNT_DT", nullable = false)
  private Date pymntDt;
  @Column(name = "PYMNT_STATUS", nullable = false)
  private Integer pymntStatus;
  @Column(name = "UPDATE_DT", nullable = true)
  private Date updateDt;
  @Column(name = "PYMNT_METHOD_ID", nullable = false)
  private Long pymntMethodID;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SUBSCRIPTION_ID", nullable = false)
  private Subscription subscription;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubPayment</code>
   */
  public SubPayment() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @return Returns the subPymntID.
   */
  public Long getSubPymntID() {
    return subPymntID;
  }

  /**
   * @param subPymntID The subPymntID to set.
   */
  public void setSubPymntID(Long subPymntID) {
    this.subPymntID = subPymntID;
  }

  /**
   * @return Returns the pymntDt.
   */
  public Date getPymntDt() {
    return pymntDt;
  }

  /**
   * @param pymntDt The pymntDt to set.
   */
  public void setPymntDt(Date pymntDt) {
    this.pymntDt = pymntDt;
  }

  /**
   * @return Returns the pymntStatus.
   */
  public Integer getPymntStatus() {
    return pymntStatus;
  }

  /**
   * @param pymntStatus The pymntStatus to set.
   */
  public void setPymntStatus(Integer pymntStatus) {
    this.pymntStatus = pymntStatus;
  }

  /**
   * @return Returns the updateDt.
   */
  public Date getUpdateDt() {
    return updateDt;
  }

  /**
   * @param updateDt The updateDt to set.
   */
  public void setUpdateDt(Date updateDt) {
    this.updateDt = updateDt;
  }

  /**
   * @return Returns the pymntMethodID.
   */
  public Long getPymntMethodID() {
    return pymntMethodID;
  }

  /**
   * @param pymntMethodID The pymntMethodID to set.
   */
  public void setPymntMethodID(Long pymntMethodID) {
    this.pymntMethodID = pymntMethodID;
  }

  /**
   * @return Returns the pymntAmt.
   */
  public BigDecimal getPymntAmt() {
    return pymntAmt;
  }

  /**
   * @param pymntAmt The pymntAmt to set.
   */
  public void setPymntAmt(BigDecimal pymntAmt) {
    this.pymntAmt = pymntAmt;
  }

  /**
   * @return Returns the subscription.
   */
  public Subscription getSubscription() {
    return subscription;
  }

  /**
   * @param subscription The subscription to set.
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
