/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.data;

import java.math.BigDecimal;
import java.util.Date;
import com.lucid.core.vo.BaseVO;

/**
 * @author sgutti
 * @date Aug 28, 2022 3:13:30 PM
 *
 */
public class SubBillingVO extends BaseVO {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 3314589700432741499L;
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  private Long subscriptionID;
  private Date effectiveDt;
  // 1 - Monthly, 2- Yearly
  private Integer billPeriodUnit;
  // if monthly.
  private Integer billcycleDay;
  private Date nextBillDt;
  // 0- NONE , 1 - ONE-TIME , 2 -RECURRING
  private Integer invoiceType;
  private BigDecimal balanceAmt;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubBillingVO</code>
   */
  public SubBillingVO() {
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
