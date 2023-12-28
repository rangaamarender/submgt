/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import com.lucid.core.vo.BaseVO;
import com.lucid.subscription.constants.EnumInvoiceStatus;
import com.lucid.subscription.constants.EnumPaymentStatus;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:32:21 IST 2021
 */
public class SubInvoiceVO extends BaseVO {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 1L;
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  private Long subInvoiceID;
  private BigDecimal invoiceAmt;
  private Integer invoiceStatus = EnumInvoiceStatus.OPEN;
  private Date invoiceDueDt;
  private Long subscriptionID;
  private BigDecimal discountAmt;
  private BigDecimal taxAmt;
  private Date invoiceDt;
  private Date updatedDt;
  private Integer paymentStatus = EnumPaymentStatus.NOT_PAID;
  private Date paymentDt;
  private BigDecimal balanceAmt;
  private List<SubInvoiceItemVO> invoiceItems;

  private SubscriptionVO subscription;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubInvoiceVO</code>
   */
  public SubInvoiceVO() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @return Returns the subInvoiceID.
   */
  public Long getSubInvoiceID() {
    return subInvoiceID;
  }

  /**
   * @param subInvoiceID The subInvoiceID to set.
   */
  public void setSubInvoiceID(Long subInvoiceID) {
    this.subInvoiceID = subInvoiceID;
  }

  /**
   * @return Returns the invoiceStatus.
   */
  public Integer getInvoiceStatus() {
    return invoiceStatus;
  }

  /**
   * @param invoiceStatus The invoiceStatus to set.
   */
  public void setInvoiceStatus(Integer invoiceStatus) {
    this.invoiceStatus = invoiceStatus;
  }

  /**
   * @return Returns the invoiceDueDt.
   */
  public Date getInvoiceDueDt() {
    return invoiceDueDt;
  }

  /**
   * @param invoiceDueDt The invoiceDueDt to set.
   */
  public void setInvoiceDueDt(Date invoiceDueDt) {
    this.invoiceDueDt = invoiceDueDt;
  }

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
   * @return Returns the invoiceAmt.
   */
  public BigDecimal getInvoiceAmt() {
    return invoiceAmt;
  }

  /**
   * @param invoiceAmt The invoiceAmt to set.
   */
  public void setInvoiceAmt(BigDecimal invoiceAmt) {
    this.invoiceAmt = invoiceAmt;
  }

  /**
   * @return Returns the discountAmt.
   */
  public BigDecimal getDiscountAmt() {
    return discountAmt;
  }

  /**
   * @param discountAmt The discountAmt to set.
   */
  public void setDiscountAmt(BigDecimal discountAmt) {
    this.discountAmt = discountAmt;
  }

  /**
   * @return Returns the taxAmt.
   */
  public BigDecimal getTaxAmt() {
    return taxAmt;
  }

  /**
   * @param taxAmt The taxAmt to set.
   */
  public void setTaxAmt(BigDecimal taxAmt) {
    this.taxAmt = taxAmt;
  }

  /**
   * @return Returns the invoiceItems.
   */
  public List<SubInvoiceItemVO> getInvoiceItems() {
    return invoiceItems;
  }

  /**
   * @param invoiceItems The invoiceItems to set.
   */
  public void setInvoiceItems(List<SubInvoiceItemVO> invoiceItems) {
    this.invoiceItems = invoiceItems;
  }

  /**
   * @return Returns the invoiceDt.
   */
  public Date getInvoiceDt() {
    return invoiceDt;
  }

  /**
   * @param invoiceDt The invoiceDt to set.
   */
  public void setInvoiceDt(Date invoiceDt) {
    this.invoiceDt = invoiceDt;
  }

  /**
   * @return Returns the updatedDt.
   */
  public Date getUpdatedDt() {
    return updatedDt;
  }

  /**
   * @param updatedDt The updatedDt to set.
   */
  public void setUpdatedDt(Date updatedDt) {
    this.updatedDt = updatedDt;
  }

  public SubscriptionVO getSubscription() {
    return subscription;
  }

  public void setSubscription(SubscriptionVO subscription) {
    this.subscription = subscription;
  }

  /**
   * @return Returns the paymentStatus.
   */
  public Integer getPaymentStatus() {
    return paymentStatus;
  }

  /**
   * @param paymentStatus The paymentStatus to set.
   */
  public void setPaymentStatus(Integer paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  /**
   * @return Returns the paymentDt.
   */
  public Date getPaymentDt() {
    return paymentDt;
  }

  /**
   * @param paymentDt The paymentDt to set.
   */
  public void setPaymentDt(Date paymentDt) {
    this.paymentDt = paymentDt;
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
   * @return
   */
  public String getInvoiceStatusStr() {
    return EnumInvoiceStatus.toString(invoiceStatus);
  }

  /**
   * @return
   */
  public String getPaymentStatusStr() {
    return EnumPaymentStatus.toString(paymentStatus);
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
