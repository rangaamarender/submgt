/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.tenant.data;

import java.util.Date;
import com.lucid.core.constants.EnumStatus;
import com.lucid.core.vo.BaseVO;
import com.lucid.subscription.data.SubscriptionVO;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 18:21:24 IST 2021
 */
public class TenantVO extends BaseVO {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 1L;
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  private Long tenantID;
  private String createdBy;
  private Date createdDt;
  private String updatedBy;
  private Date updatedDt;
  private String companyName;
  private String externalCode;
  private Integer status;
  private SubscriptionVO subscription;
  private TenantProfileVO tenantProfile;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>TenantVO</code>
   */
  public TenantVO() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
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
   * @return Returns the createdBy.
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * @param createdBy The createdBy to set.
   */
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * @return Returns the createdDt.
   */
  public Date getCreatedDt() {
    return createdDt;
  }

  /**
   * @param createdDt The createdDt to set.
   */
  public void setCreatedDt(Date createdDt) {
    this.createdDt = createdDt;
  }

  /**
   * @return Returns the updatedBy.
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * @param updatedBy The updatedBy to set.
   */
  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
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
   * @return Returns the companyName.
   */
  public String getCompanyName() {
    return companyName;
  }

  /**
   * @param companyName The companyName to set.
   */
  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  /**
   * @return Returns the externalCode.
   */
  public String getExternalCode() {
    return externalCode;
  }

  /**
   * @param externalCode The externalCode to set.
   */
  public void setExternalCode(String externalCode) {
    this.externalCode = externalCode;
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
   * @return Returns the subscription.
   */
  public SubscriptionVO getSubscription() {
    return subscription;
  }

  /**
   * @param subscription The subscription to set.
   */
  public void setSubscription(SubscriptionVO subscription) {
    this.subscription = subscription;
  }

  /**
   * @return
   */
  public boolean isActive() {
    return EnumStatus.isActiveBoo(status);
  }

  /**
   * @return
   */
  public String getStatusStr() {
    return EnumStatus.toString(status);
  }


  /**
   * @return Returns the tenantProfile.
   */
  public TenantProfileVO getTenantProfile() {
    return tenantProfile;
  }

  /**
   * @param tenantProfile The tenantProfile to set.
   */
  public void setTenantProfile(TenantProfileVO tenantProfile) {
    this.tenantProfile = tenantProfile;
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "TenantVO [tenantID=" + tenantID + ", companyName=" + companyName + ", status=" + status
        + ", externalCode=" + externalCode + "]";
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
