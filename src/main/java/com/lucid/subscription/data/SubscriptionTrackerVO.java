/**
 * eCurve Inc. All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.data;

import java.util.Date;
import com.lucid.core.constants.EnumStatus;
import com.lucid.core.vo.BaseVO;

/**
 * @author sgutti
 * @date Mar 5, 2022 4:48:53 PM
 *
 */
public class SubscriptionTrackerVO extends BaseVO {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 5551275607905939404L;
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  private Long subscriptionTrackerId;
  private Long tenantID;
  private String trackerCode;
  private Date sentOn;
  private Integer status;
  private Date lastUpdated;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubscriptionTrackerVO</code>
   */
  public SubscriptionTrackerVO() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @return Returns the subscriptionTrackerId.
   */
  public Long getSubscriptionTrackerId() {
    return subscriptionTrackerId;
  }

  /**
   * @param subscriptionTrackerId The subscriptionTrackerId to set.
   */
  public void setSubscriptionTrackerId(Long subscriptionTrackerId) {
    this.subscriptionTrackerId = subscriptionTrackerId;
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
   * @return Returns the trackerCode.
   */
  public String getTrackerCode() {
    return trackerCode;
  }

  /**
   * @param trackerCode The trackerCode to set.
   */
  public void setTrackerCode(String trackerCode) {
    this.trackerCode = trackerCode;
  }

  /**
   * @return Returns the sentOn.
   */
  public Date getSentOn() {
    return sentOn;
  }

  /**
   * @param sentOn The sentOn to set.
   */
  public void setSentOn(Date sentOn) {
    this.sentOn = sentOn;
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
   * @return Returns the lastUpdated.
   */
  public Date getLastUpdated() {
    return lastUpdated;
  }

  /**
   * @param lastUpdated The lastUpdated to set.
   */
  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  /**
   * @return
   */
  public boolean isActive() {
    return (status != null && status.intValue() == EnumStatus.ACTIVE);
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
