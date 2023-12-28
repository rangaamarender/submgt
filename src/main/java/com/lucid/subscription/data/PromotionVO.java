/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.data;

import java.math.BigDecimal;
import java.util.Date;

import com.lucid.core.vo.BaseVO;

/**
 * @author sgutti
 * @date 10-May-2023 10:21:29 pm
 */
public class PromotionVO extends BaseVO {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 8106687029919704229L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String promotionID;
    private String name;
    private String description;
    /*
     * Type of discount 1- % Discount 2 - Flat Rate , In both cases Discounting
     * Engine will control discount amount not greater than charge (i.e. Maximum
     * discount amount is equal to charge)
     */
    private Integer promotionType;

    // If Type is % then maximum value is 100%"
    private BigDecimal promotionAmount;

    // 1 - Active , 2 - Superseded, 3 - Testing
    private Integer promotionStatus;

    private Date salesStartDate;

    private Date salesEndDate;

    private String revenueID;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>PromotionVO</code>
     */
    public PromotionVO() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the promotionID.
     */
    public String getPromotionID() {
        return promotionID;
    }

    /**
     * @param promotionID
     *            The promotionID to set.
     */
    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * @return Returns the promotionType.
     */
    public Integer getPromotionType() {
        return promotionType;
    }

    /**
     * @param promotionType
     *            The promotionType to set.
     */
    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    /**
     * @return Returns the promotionAmount.
     */
    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    /**
     * @param promotionAmount
     *            The promotionAmount to set.
     */
    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    /**
     * @return Returns the promotionStatus.
     */
    public Integer getPromotionStatus() {
        return promotionStatus;
    }

    /**
     * @param promotionStatus
     *            The promotionStatus to set.
     */
    public void setPromotionStatus(Integer promotionStatus) {
        this.promotionStatus = promotionStatus;
    }

    /**
     * @return Returns the salesStartDate.
     */
    public Date getSalesStartDate() {
        return salesStartDate;
    }

    /**
     * @param salesStartDate
     *            The salesStartDate to set.
     */
    public void setSalesStartDate(Date salesStartDate) {
        this.salesStartDate = salesStartDate;
    }

    /**
     * @return Returns the salesEndDate.
     */
    public Date getSalesEndDate() {
        return salesEndDate;
    }

    /**
     * @param salesEndDate
     *            The salesEndDate to set.
     */
    public void setSalesEndDate(Date salesEndDate) {
        this.salesEndDate = salesEndDate;
    }

    /**
     * @return Returns the revenueID.
     */
    public String getRevenueID() {
        return revenueID;
    }

    /**
     * @param revenueID
     *            The revenueID to set.
     */
    public void setRevenueID(String revenueID) {
        this.revenueID = revenueID;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
