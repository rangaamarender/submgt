/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.entity;

import java.math.BigDecimal;
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
 * @date Sat May 15 13:32:35 IST 2021
 */
@Entity
@Table(name = SubInvoiceItem.TABLE_NAME)
public class SubInvoiceItem extends BaseEntity {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 1L;
  public static final String TABLE_NAME = "SUBR_INVOICE_ITEM";
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "SUBR_INVOICE_ITEM_ID", nullable = false)
  private Long subInvoiceItemID;
  @Column(name = "RATE", nullable = false)
  private BigDecimal rate;
  @Column(name = "QTY", nullable = false)
  private BigDecimal qty;
  @Column(name = "AMT", nullable = true)
  private BigDecimal amt;
  @Column(name = "TAX_AMT", nullable = true)
  private BigDecimal taxAmt;
  @Column(name = "DISCOUNT_AMT", nullable = true)
  private BigDecimal discountAmt;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SUB_INVOICE_ID", nullable = false)
  private SubInvoice subInvoice;
  @Column(name = "ITEM_CODE", nullable = false, length = 50)
  private String itemCode;
  @Column(name = "DESCRIPTION", nullable = true, length = 200)
  private String description;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubInvoiceItem</code>
   */
  public SubInvoiceItem() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @return Returns the subInvoiceItemID.
   */
  public Long getSubInvoiceItemID() {
    return subInvoiceItemID;
  }

  /**
   * @param subInvoiceItemID The subInvoiceItemID to set.
   */
  public void setSubInvoiceItemID(Long subInvoiceItemID) {
    this.subInvoiceItemID = subInvoiceItemID;
  }

  /**
   * @return Returns the rate.
   */
  public BigDecimal getRate() {
    return rate;
  }

  /**
   * @param rate The rate to set.
   */
  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  /**
   * @return Returns the qty.
   */
  public BigDecimal getQty() {
    return qty;
  }

  /**
   * @param qty The qty to set.
   */
  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  /**
   * @return Returns the amt.
   */
  public BigDecimal getAmt() {
    return amt;
  }

  /**
   * @param amt The amt to set.
   */
  public void setAmt(BigDecimal amt) {
    this.amt = amt;
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
   * @return Returns the subInvoice.
   */
  public SubInvoice getSubInvoice() {
    return subInvoice;
  }

  /**
   * @param subInvoice The subInvoice to set.
   */
  public void setSubInvoice(SubInvoice subInvoice) {
    this.subInvoice = subInvoice;
  }

  /**
   * @return Returns the itemCode.
   */
  public String getItemCode() {
    return itemCode;
  }

  /**
   * @param itemCode The itemCode to set.
   */
  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
  }

  /**
   * @return Returns the description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description The description to set.
   */
  public void setDescription(String description) {
    this.description = description;
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
