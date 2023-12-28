/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.lucid.core.entity.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author sgutti
 * @date May 3, 2022 6:10:57 AM
 *
 */
@Entity
@Table(name = SubBilling.TABLE_NAME)
public class SubBilling extends AuditableEntity {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = -2786283901126695976L;
  public static final String TABLE_NAME = "SUBR_BILLING";
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Id
  @Column(name = "SUBSCRIPTION_ID", nullable = false)
  private Long subscriptionID;
  @Column(name = "EFFECTIVE_DT", nullable = false)
  private Date effectiveDt;
  // 1 - Monthly, 2- Yearly
  @Column(name = "BILL_PERIOD_UNIT", nullable = false)
  private Integer billPeriodUnit;
  // if monthly.
  @Column(name = "BILL_CYCLE_DAY", nullable = false)
  private Integer billcycleDay;
  @Column(name = "NEXT_BILL_DT", nullable = false)
  private Date nextBillDt;
  // 0- NONE , 1 - ONE-TIME , 2 -RECURRING
  @Column(name = "INVOICE_TYPE", nullable = false)
  private Integer invoiceType;
  @Column(name = "BALANCE_AMT", nullable = true)
  private BigDecimal balanceAmt;
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "SUBSCRIPTION_ID", nullable = false, insertable = false, updatable = false)
  private Subscription subscription;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubBilling</code>
   */
  public SubBilling() {
    super();
  }
  // ---------------------------------------------------------- Public Methods

  /**
   * @return Returns the subscriptionID.
   */
  public Long getSubscriptionID() {
    return subscriptionID;
  }

  /**
   * @param subscriptionID The subscriptionID to set.
   */
  public void setSubscriptionID(Long subscriptionID) {
    this.subscriptionID = subscriptionID;
  }

  /**
   * @return Returns the effectiveDt.
   */
  public Date getEffectiveDt() {
    return effectiveDt;
  }

  /**
   * @param effectiveDt The effectiveDt to set.
   */
  public void setEffectiveDt(Date effectiveDt) {
    this.effectiveDt = effectiveDt;
  }

  /**
   * @return Returns the billPeriodUnit.
   */
  public Integer getBillPeriodUnit() {
    return billPeriodUnit;
  }

  /**
   * @param billPeriodUnit The billPeriodUnit to set.
   */
  public void setBillPeriodUnit(Integer billPeriodUnit) {
    this.billPeriodUnit = billPeriodUnit;
  }

  /**
   * @return Returns the billcycleDay.
   */
  public Integer getBillcycleDay() {
    return billcycleDay;
  }

  /**
   * @param billcycleDay The billcycleDay to set.
   */
  public void setBillcycleDay(Integer billcycleDay) {
    this.billcycleDay = billcycleDay;
  }

  /**
   * @return Returns the nextBillDt.
   */
  public Date getNextBillDt() {
    return nextBillDt;
  }

  /**
   * @param nextBillDt The nextBillDt to set.
   */
  public void setNextBillDt(Date nextBillDt) {
    this.nextBillDt = nextBillDt;
  }

  /**
   * @return Returns the invoiceType.
   */
  public Integer getInvoiceType() {
    return invoiceType;
  }

  /**
   * @param invoiceType The invoiceType to set.
   */
  public void setInvoiceType(Integer invoiceType) {
    this.invoiceType = invoiceType;
  }

  /**
   * @return Returns the balanceAmt.
   */
  public BigDecimal getBalanceAmt() {
    return balanceAmt;
  }

  /**
   * @param balanceAmt The balanceAmt to set.
   */
  public void setBalanceAmt(BigDecimal balanceAmt) {
    this.balanceAmt = balanceAmt;
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
