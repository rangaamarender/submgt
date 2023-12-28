/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.tenant.data;

import com.lucid.core.entity.BaseEntity;

/**
 * @author sgutti
 * @date 23-Nov-2023 2:33:30 pm
 *
 */
public class TenantAddressVO extends BaseEntity {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 5489912961532647795L;
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  private Long tenantAddressID;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String stateCode;
  private String countryCode;
  private String postalCode;
  // BILLING/SHIPPING
  private String addressType;
  private Long tenantID;


  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>TenantAddressVO</code>
   */
  public TenantAddressVO() {
    super();
  }
  // ---------------------------------------------------------- Public Methods


  /**
   * @return Returns the tenantAddressID.
   */
  public Long getTenantAddressID() {
    return tenantAddressID;
  }


  /**
   * @param tenantAddressID The tenantAddressID to set.
   */
  public void setTenantAddressID(Long tenantAddressID) {
    this.tenantAddressID = tenantAddressID;
  }


  /**
   * @return Returns the addressLine1.
   */
  public String getAddressLine1() {
    return addressLine1;
  }


  /**
   * @param addressLine1 The addressLine1 to set.
   */
  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }


  /**
   * @return Returns the addressLine2.
   */
  public String getAddressLine2() {
    return addressLine2;
  }


  /**
   * @param addressLine2 The addressLine2 to set.
   */
  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }


  /**
   * @return Returns the city.
   */
  public String getCity() {
    return city;
  }


  /**
   * @param city The city to set.
   */
  public void setCity(String city) {
    this.city = city;
  }


  /**
   * @return Returns the stateCode.
   */
  public String getStateCode() {
    return stateCode;
  }


  /**
   * @param stateCode The stateCode to set.
   */
  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }


  /**
   * @return Returns the countryCode.
   */
  public String getCountryCode() {
    return countryCode;
  }


  /**
   * @param countryCode The countryCode to set.
   */
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }


  /**
   * @return Returns the postalCode.
   */
  public String getPostalCode() {
    return postalCode;
  }


  /**
   * @param postalCode The postalCode to set.
   */
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }


  /**
   * @return Returns the addressType.
   */
  public String getAddressType() {
    return addressType;
  }


  /**
   * @param addressType The addressType to set.
   */
  public void setAddressType(String addressType) {
    this.addressType = addressType;
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

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
