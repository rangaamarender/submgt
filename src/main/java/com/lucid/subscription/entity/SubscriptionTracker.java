/**
 * eCurve Inc. All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.entity;

import java.util.Date;
import com.lucid.core.entity.BaseEntity;
import com.lucid.tenant.entity.Tenant;
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
 * @date Mar 5, 2022 2:42:36 PM
 *
 */
@Entity
@Table(name = SubscriptionTracker.TABLE_NAME)
public class SubscriptionTracker extends BaseEntity {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = -3166355872918346059L;
  public static final String TABLE_NAME = "L_SUBR_TRACKER";
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "SUB_TRACKER_ID", nullable = false)
  private Long subscriptionTrackerId;
  @Column(name = "TENANT_ID", nullable = false)
  private Long tenantID;
  @Column(name = "TRACKER_CODE", nullable = false, length = 50)
  private String trackerCode;
  @Column(name = "SEND_ON", nullable = false)
  private Date sentOn;
  @Column(name = "STATUS", nullable = false)
  private Integer status;
  @Column(name = "LAST_UPDATED_ON", nullable = true)
  private Date lastUpdated;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TENANT_ID", nullable = false, insertable = false, updatable = false)
  private Tenant tenant;
  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubscriptionTracker</code>
   */
  public SubscriptionTracker() {
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
   * @return Returns the tenant.
   */
  public Tenant getTenant() {
    return tenant;
  }

  /**
   * @param tenant The tenant to set.
   */
  public void setTenant(Tenant tenant) {
    this.tenant = tenant;
  }
  
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
