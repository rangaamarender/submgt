/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.tenant.entity;

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
 * @date 23-Nov-2023 2:33:30 pm
 *
 */
@Entity
@Table(name = TenantAddress.TABLE_NAME)
public class TenantAddress extends BaseEntity {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 5489912961532647795L;
  public static final String TABLE_NAME = "l_tenant_address";
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TENANT_ADDRESS_ID", nullable = false)
  private Long tenantAddressID;
  @Column(name = "ADDRESS_LINE1", nullable = false, length = 100)
  private String addressLine1;
  @Column(name = "ADDRESS_LINE2", nullable = true, length = 100)
  private String addressLine2;
  @Column(name = "CITY", nullable = false, length = 100)
  private String city;
  @Column(name = "STATE_CODE", nullable = false, length = 50)
  private String stateCode;
  @Column(name = "COUNTRY_CODE", nullable = false, length = 10)
  private String countryCode;
  @Column(name = "POSTAL_CODE", nullable = false, length = 15)
  private String postalCode;
  // BILLING/SHIPPING
  @Column(name = "ADDRESS_TYPE", nullable = false, length = 15)
  private String addressType;
  @Column(name = "TENANT_ID", nullable = false)
  private Long tenantID;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TENANT_ID", nullable = false, insertable = false, updatable = false)
  private Tenant tenant;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>TenantAddressVO</code>
   */
  public TenantAddress() {
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
