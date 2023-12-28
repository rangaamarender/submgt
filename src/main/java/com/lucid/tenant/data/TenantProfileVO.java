/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.tenant.data;

import com.lucid.core.vo.BaseVO;

/**
 * @author sgutti
 * @date 22-Nov-2023 2:48:08 pm
 *
 */
public class TenantProfileVO extends BaseVO {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = -5605358993876077601L;
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  private Long tenantID;
  private String companyTag;
  private String einNumber;
  private String companyType;
  private String companySize;
  private String companyIndustry;
  private byte[] companyLogo;
  private byte[] companyIcon;
  private String taxClassification;
  private String stateOfInCorporation;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>TenantProfileVO</code>
   */
  public TenantProfileVO() {
    super();
  }

  /**
   * @return Returns the tenantID.
   */
  public Long getTenantID() {
    return tenantID;
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @param tenantID The tenantID to set.
   */
  public void setTenantID(Long tenantID) {
    this.tenantID = tenantID;
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
