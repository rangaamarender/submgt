/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription.data;

import java.util.Date;
import com.lucid.core.vo.BaseVO;

/**
 * @author sgutti
 * @date 10-May-2023 10:28:05 pm
 */
public class PlanPromotionVO extends BaseVO {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = -5746597947717196040L;
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  private String planPromotionID;
  private Long subscriptionID;
  private String promotionID;
  private Date effectiveStartDate;
  private Date effectiveEndDate;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>PlanPromotionVO</code>
   */
  public PlanPromotionVO() {
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
