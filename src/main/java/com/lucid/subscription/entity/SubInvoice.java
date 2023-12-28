/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.lucid.core.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:32:21 IST 2021
 */
@Entity
@Table(name = SubInvoice.TABLE_NAME)
public class SubInvoice extends BaseEntity {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 1L;
  public static final String TABLE_NAME = "SUBR_INVOICE";
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "SUBR_INVOICE_ID", nullable = false)
  private Long subInvoiceID;
  @Column(name = "INVOICE_AMT", nullable = false)
  private BigDecimal invoiceAmt;
  @Column(name = "INVOICE_STATUS", nullable = false)
  private Integer invoiceStatus;
  @Column(name = "INVOICE_DUE_DT", nullable = false)
  private Date invoiceDueDt;
  @Column(name = "SUBSCRIPTION_ID", nullable = false)
  private Long subscriptionID;
  @Column(name = "DISCOUNT_AMT", nullable = true)
  private BigDecimal discountAmt;
  @Column(name = "TAX_AMT", nullable = true)
  private BigDecimal taxAmt;
  @Column(name = "INVOICE_DT", nullable = false)
  private Date invoiceDt;
  @Column(name = "UPDATED_DT", nullable = false)
  private Date updatedDt;
  //
  @Column(name = "PYMNT_STATUS", nullable = false)
  private Integer paymentStatus;
  @Column(name = "PYMNT_DT", nullable = true)
  private Date paymentDt;
  @Column(name = "BALANCE_AMT", nullable = true)
  private BigDecimal balanceAmt;

  @OneToMany(mappedBy = "subInvoice", cascade = CascadeType.ALL, orphanRemoval = true,
      fetch = FetchType.EAGER)
  private Set<SubInvoiceItem> invoiceItems = new HashSet<>();
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SUBSCRIPTION_ID", nullable = false, insertable = false, updatable = false)
  private Subscription subscription;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubInvoice</code>
   */
  public SubInvoice() {
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

  /**
   * @param subInvoiceItem
   */
  public void addSubInvoiceItem(SubInvoiceItem subInvoiceItem) {
    invoiceItems.add(subInvoiceItem);
    subInvoiceItem.setSubInvoice(this);
  }

  /**
   * @param subInvoiceItem
   */
  public void removeSubInvoiceItem(SubInvoiceItem subInvoiceItem) {
    invoiceItems.remove(subInvoiceItem);
    subInvoiceItem.setSubInvoice(this);
  }

  /**
   * @return Returns the invoiceItems.
   */
  public Set<SubInvoiceItem> getInvoiceItems() {
    return invoiceItems;
  }

  /**
   * @param invoiceItems The invoiceItems to set.
   */
  public void setInvoiceItems(Set<SubInvoiceItem> invoiceItems) {
    this.invoiceItems = invoiceItems;
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
