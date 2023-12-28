/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.tenant.entity;

import com.lucid.core.entity.AuditableEntity;
import com.lucid.subscription.entity.Subscription;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 18:21:24 IST 2021
 */
@Entity
@Table(name = Tenant.TABLE_NAME)
public class Tenant extends AuditableEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "l_tenant";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TENANT_ID", nullable = false)
    private Long tenantID;
    @Column(name = "COMPANY_NAME", nullable = false, length = 100)
    private String companyName;
    @Column(name = "EXTERNAL_CODE", nullable = false, length = 25)
    private String externalCode;
    @Column(name = "STATUS", nullable = false)
    private Integer status;
    @OneToOne
    @JoinColumn(name = "TENANT_ID", referencedColumnName = "SUBSCRIPTION_ID")
    private Subscription subscription;
    @OneToOne
    @JoinColumn(name = "TENANT_ID", referencedColumnName = "TENANT_PROFILE_ID")
    private TenantProfile tenantProfile;
    @Column(name = "WEBSITE", nullable = true, length = 100)
    private String website;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>Tenant</code>
     */
    public Tenant() {
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
     * @param tenantID
     *            The tenantID to set.
     */
    public void setTenantID(Long tenantID) {
        this.tenantID = tenantID;
    }

    /**
     * @return Returns the companyName.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     *            The companyName to set.
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
     * @param externalCode
     *            The externalCode to set.
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
     * @param status
     *            The status to set.
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return Returns the tenantProfile.
     */
    public TenantProfile getTenantProfile() {
        return tenantProfile;
    }

    /**
     * @param tenantProfile
     *            The tenantProfile to set.
     */
    public void setTenantProfile(TenantProfile tenantProfile) {
        this.tenantProfile = tenantProfile;
    }

    /**
     * @return Returns the subscription.
     */
    public Subscription getSubscription() {
        return subscription;
    }

    /**
     * @param subscription
     *            The subscription to set.
     */
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    /**
     * @return Returns the website.
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website
     *            The website to set.
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
