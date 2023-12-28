/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.lucid.core.entity.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author sgutti
 * @date 10-May-2023 7:58:46 pm
 */
@Entity(name = Promotion.TABLE_NAME)
@Table
public class Promotion extends AuditableEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 6855952856248613848L;
    public static final String TABLE_NAME = "promotion";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "promotion_id", nullable = false, length = 75)
    private String promotionID;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", nullable = true, length = 200)
    private String description;

    /*
     * Type of discount 1- % Discount 2 - Flat Rate , In both cases Discounting
     * Engine will control discount amount not greater than charge (i.e. Maximum
     * discount amount is equal to charge)
     */
    @Column(name = "promotion_type", nullable = false)
    private Integer promotionType;

    // If Type is % then maximum value is 100%"
    @Column(name = "promotion_amt", nullable = false)
    private BigDecimal promotionAmount;

    // 1 - Active , 2 - Superseded, 3 - Testing
    @Column(name = "promotion_status", nullable = false)
    private Integer promotionStatus;

    @Column(name = "sales_start_dt", nullable = false)
    private Date salesStartDate;

    @Column(name = "sales_end_dt", nullable = true)
    private Date salesEndDate;

    @Column(name = "revenue_id", nullable = true, length = 75)
    private String revenueID;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>Discount</code>
     */
    public Promotion() {
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
