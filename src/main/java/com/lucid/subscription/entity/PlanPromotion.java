/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription.entity;

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
 * @author sgutti
 * @date 10-May-2023 8:10:48 pm
 */
@Entity(name = PlanPromotion.TABLE_NAME)
@Table
public class PlanPromotion extends BaseEntity {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = -663057508201807121L;
  public static final String TABLE_NAME = "plan_promotions";
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "plan_promotion_id", nullable = false, length = 75)
  private String planPromotionID;

  @Column(name = "SUBSCRIPTION_ID", nullable = false)
  private Long subscriptionID;

  @Column(name = "promotion_id", nullable = false, length = 75)
  private String promotionID;

  @Column(name = "effective_start_dt", nullable = false)
  private Date effectiveStartDate;

  @Column(name = "effective_end_dt", nullable = true)
  private Date effectiveEndDate;


  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "SUBSCRIPTION_ID", nullable = false, insertable = false, updatable = false)
  private Subscription subscription;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>PlanPromotion</code>
   */
  public PlanPromotion() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @return Returns the planPromotionID.
   */
  public String getPlanPromotionID() {
    return planPromotionID;
  }

  /**
   * @param planPromotionID The planPromotionID to set.
   */
  public void setPlanPromotionID(String planPromotionID) {
    this.planPromotionID = planPromotionID;
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
   * @return Returns the promotionID.
   */
  public String getPromotionID() {
    return promotionID;
  }

  /**
   * @param promotionID The promotionID to set.
   */
  public void setPromotionID(String promotionID) {
    this.promotionID = promotionID;
  }

  /**
   * @return Returns the effectiveStartDate.
   */
  public Date getEffectiveStartDate() {
    return effectiveStartDate;
  }

  /**
   * @param effectiveStartDate The effectiveStartDate to set.
   */
  public void setEffectiveStartDate(Date effectiveStartDate) {
    this.effectiveStartDate = effectiveStartDate;
  }

  /**
   * @return Returns the effectiveEndDate.
   */
  public Date getEffectiveEndDate() {
    return effectiveEndDate;
  }

  /**
   * @param effectiveEndDate The effectiveEndDate to set.
   */
  public void setEffectiveEndDate(Date effectiveEndDate) {
    this.effectiveEndDate = effectiveEndDate;
  }

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
