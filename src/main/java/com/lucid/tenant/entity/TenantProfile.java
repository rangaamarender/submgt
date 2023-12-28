/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.tenant.entity;

import com.lucid.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

/**
 * @author sgutti
 * @date 22-Nov-2023 9:19:06 am
 *
 */

@Entity
@Table(name = TenantProfile.TABLE_NAME)
public class TenantProfile extends BaseEntity {
  private static final long serialVersionUID = -7979044115753509792L;
  public static final String TABLE_NAME = "l_tenant_profile";
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Id
  @Column(name = "TENANT_PROFILE_ID", nullable = false)
  private Long tenantProfileID;
  @Column(name = "COMPANY_TAG", nullable = true, length = 100)
  private String companyTag;
  @Column(name = "EIN_NBR", nullable = true, length = 25)
  private String einNumber;
  @Column(name = "COMPANY_TYPE", nullable = true, length = 50)
  private String companyType;
  @Column(name = "COMPANY_SIZE", nullable = true, length = 25)
  private String companySize;
  @Column(name = "COMPANY_INDUSTRY", nullable = true, length = 25)
  private String companyIndustry;

  @Column(name = "TAX_CLASS", nullable = true, length = 25)
  private String taxClassification;

  @Column(name = "STATE_OF_INCORP", nullable = true, length = 25)
  private String stateOfInCorporation;
  @Lob
  @Column(name = "COMPANY_LOGO", nullable = true)
  private byte[] companyLogo;
  @Lob
  @Column(name = "COMPANY_ICON", nullable = true)
  private byte[] companyIcon;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>TenantProfileVO</code>
   */
  public TenantProfile() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @return Returns the tenantProfileID.
   */
  public Long getTenantProfileID() {
    return tenantProfileID;
  }

  /**
   * @param tenantProfileID The tenantProfileID to set.
   */
  public void setTenantProfileID(Long tenantProfileID) {
    this.tenantProfileID = tenantProfileID;
  }


  /**
   * @return Returns the companyTag.
   */
  public String getCompanyTag() {
    return companyTag;
  }

  /**
   * @param companyTag The companyTag to set.
   */
  public void setCompanyTag(String companyTag) {
    this.companyTag = companyTag;
  }

  /**
   * @return Returns the einNumber.
   */
  public String getEinNumber() {
    return einNumber;
  }

  /**
   * @param einNumber The einNumber to set.
   */
  public void setEinNumber(String einNumber) {
    this.einNumber = einNumber;
  }

  /**
   * @return Returns the companyType.
   */
  public String getCompanyType() {
    return companyType;
  }

  /**
   * @param companyType The companyType to set.
   */
  public void setCompanyType(String companyType) {
    this.companyType = companyType;
  }

  /**
   * @return Returns the companySize.
   */
  public String getCompanySize() {
    return companySize;
  }

  /**
   * @param companySize The companySize to set.
   */
  public void setCompanySize(String companySize) {
    this.companySize = companySize;
  }

  /**
   * @return Returns the companyIndustry.
   */
  public String getCompanyIndustry() {
    return companyIndustry;
  }

  /**
   * @param companyIndustry The companyIndustry to set.
   */
  public void setCompanyIndustry(String companyIndustry) {
    this.companyIndustry = companyIndustry;
  }

  /**
   * @return Returns the companyLogo.
   */
  public byte[] getCompanyLogo() {
    return companyLogo;
  }

  /**
   * @param companyLogo The companyLogo to set.
   */
  public void setCompanyLogo(byte[] companyLogo) {
    this.companyLogo = companyLogo;
  }

  /**
   * @return Returns the companyIcon.
   */
  public byte[] getCompanyIcon() {
    return companyIcon;
  }

  /**
   * @param companyIcon The companyIcon to set.
   */
  public void setCompanyIcon(byte[] companyIcon) {
    this.companyIcon = companyIcon;
  }

  /**
   * @return Returns the taxClassification.
   */
  public String getTaxClassification() {
    return taxClassification;
  }

  /**
   * @param taxClassification The taxClassification to set.
   */
  public void setTaxClassification(String taxClassification) {
    this.taxClassification = taxClassification;
  }

  /**
   * @return Returns the stateOfInCorporation.
   */
  public String getStateOfInCorporation() {
    return stateOfInCorporation;
  }

  /**
   * @param stateOfInCorporation The stateOfInCorporation to set.
   */
  public void setStateOfInCorporation(String stateOfInCorporation) {
    this.stateOfInCorporation = stateOfInCorporation;
  }

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
