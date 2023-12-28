/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import com.lucid.core.vo.BaseVO;
import com.lucid.subscription.constants.EnumSubStatus;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:26:33 IST 2021
 */
public class SubscriptionVO extends BaseVO {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 1L;
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  private Long subscriptionID;
  private String acctNbr;
  private Long tenantID;
  private Date createdDt;
  private Integer status;
  private String approvedBy;
  private Date approvedDt;
  // 1-TRAIL, 2- PAID
  private Integer phase = 1;
  private Integer trailDays = 15;
  // Billing details
  private boolean hasBillingSetup;
  private Date effectiveDt;
  // 1 - Monthly, 2- Yearly
  private Integer billPeriodUnit;
  // if monthly.
  private Integer billcycleDay;
  private Date nextBillDt;
  // 0- NONE , 1 - ONE-TIME , 2 -RECURRING
  private Integer invoiceType;
  private BigDecimal balanceAmt;
  private String planCode;
  private String planDesc;
  private Date startDt;
  private Date endDt;
  private List<SubContactVO> contacts;
  private boolean autoPay;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubscriptionVO</code>
   */
  public SubscriptionVO() {
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
   * @return
   */
  public String getStatusStr() {
    return EnumSubStatus.toString(status);
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
   * @return
   */
  public boolean isAuthorizedBoo() {
    if (status != null) {
      return (status.intValue() == EnumSubStatus.AUTHORIZED);
    }
    return false;
  }

  /**
   * @return Returns the contacts.
   */
  public List<SubContactVO> getContacts() {
    return contacts;
  }

  /**
   * @param contacts The contacts to set.
   */
  public void setContacts(List<SubContactVO> contacts) {
    this.contacts = contacts;
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
   * @return
   */
  public boolean isTrailPhase() {
    return (phase == 1);
  }

  /**
   * @return
   */
  public boolean isPaidPhase() {
    return (phase == 2);
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
   * @return
   */
  public SubContactVO getPrimaryContact() {
    if (contacts == null || contacts.isEmpty()) {
      return null;
    }
    SubContactVO result = null;
    for (SubContactVO subContactVO : contacts) {
      if (subContactVO.getContactType().intValue() == 1) {
        result = subContactVO;
        break;
      }
    }
    return result;
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

  /**
   * @return Returns the hasBillingSetup.
   */
  public boolean isHasBillingSetup() {
    return hasBillingSetup;
  }

  /**
   * @param hasBillingSetup The hasBillingSetup to set.
   */
  public void setHasBillingSetup(boolean hasBillingSetup) {
    this.hasBillingSetup = hasBillingSetup;
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
  public boolean isAutoPay() {
    return autoPay;
  }

  /**
   * @param autoPay The autoPay to set.
   */
  public void setAutoPay(boolean autoPay) {
    this.autoPay = autoPay;
  }

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
