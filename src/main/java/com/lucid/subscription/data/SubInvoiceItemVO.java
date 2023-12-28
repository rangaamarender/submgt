/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.data;

import java.math.BigDecimal;

import com.lucid.core.vo.BaseVO;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:32:35 IST 2021
 */
public class SubInvoiceItemVO extends BaseVO {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 1L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long subInvoiceItemID;
    private Long subInvoiceID;
    private BigDecimal rate;
    private BigDecimal qty;
    private BigDecimal amt;
    private BigDecimal taxAmt;
    private BigDecimal discountAmt;
    private String itemCode;
    private String description;
    private SubInvoiceItemVO subInvoice;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>SubInvoiceItemVO</code>
     */
    public SubInvoiceItemVO() {
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
     * @param subInvoiceItemID
     *            The subInvoiceItemID to set.
     */
    public void setSubInvoiceItemID(Long subInvoiceItemID) {
        this.subInvoiceItemID = subInvoiceItemID;
    }

    /**
     * @return Returns the subInvoiceID.
     */
    public Long getSubInvoiceID() {
        return subInvoiceID;
    }

    /**
     * @param subInvoiceID
     *            The subInvoiceID to set.
     */
    public void setSubInvoiceID(Long subInvoiceID) {
        this.subInvoiceID = subInvoiceID;
    }

    /**
     * @return Returns the rate.
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * @param rate
     *            The rate to set.
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
     * @param qty
     *            The qty to set.
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
     * @param amt
     *            The amt to set.
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
     * @param taxAmt
     *            The taxAmt to set.
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
     * @param discountAmt
     *            The discountAmt to set.
     */
    public void setDiscountAmt(BigDecimal discountAmt) {
        this.discountAmt = discountAmt;
    }

    /**
     * @return Returns the itemCode.
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode
     *            The itemCode to set.
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
     * @param description
     *            The description to set.
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
