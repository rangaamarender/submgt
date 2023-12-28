/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.entity;

import org.hibernate.annotations.ColumnDefault;

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
 * @author sgutti.ecrv
 * @date Sat May 15 13:31:49 IST 2021
 */
@Entity
@Table(name = SubContact.TABLE_NAME)
public class SubContact extends BaseEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SUBR_CONTACT";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBR_CONTACT_ID", nullable = false)
    private Long subContactID;
    @Column(name = "FIRST_NAME", nullable = false, length = 100)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = false, length = 100)
    private String lastName;
    @Column(name = "EMAIL_ID", nullable = false, length = 200)
    private String emailID;
    @Column(name = "PHONE_NBR", nullable = false, length = 25)
    private String phoneNbr;
    @Column(name = "SUBSCRIPTION_ID", nullable = false)
    private Long subcriptionID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBSCRIPTION_ID", nullable = false, insertable = false,
            updatable = false)
    private Subscription subscription;
    // 1 - Admin, 2 - Primary , 3 - Secondary, 0 - General
    @Column(name = "contact_type", nullable = false)
    @ColumnDefault(value = "0")
    private Integer contactType;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>SubContact</code>
     */
    public SubContact() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the subContactID.
     */
    public Long getSubContactID() {
        return subContactID;
    }

    /**
     * @param subContactID
     *            The subContactID to set.
     */
    public void setSubContactID(Long subContactID) {
        this.subContactID = subContactID;
    }

    /**
     * @return Returns the firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            The firstName to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return Returns the lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            The lastName to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Returns the emailID.
     */
    public String getEmailID() {
        return emailID;
    }

    /**
     * @param emailID
     *            The emailID to set.
     */
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    /**
     * @return Returns the phoneNbr.
     */
    public String getPhoneNbr() {
        return phoneNbr;
    }

    /**
     * @param phoneNbr
     *            The phoneNbr to set.
     */
    public void setPhoneNbr(String phoneNbr) {
        this.phoneNbr = phoneNbr;
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
     * @return Returns the subcriptionID.
     */
    public Long getSubcriptionID() {
        return subcriptionID;
    }

    /**
     * @param subcriptionID
     *            The subcriptionID to set.
     */
    public void setSubcriptionID(Long subcriptionID) {
        this.subcriptionID = subcriptionID;
    }

    /**
     * @return Returns the contactType.
     */
    public Integer getContactType() {
        return contactType;
    }

    /**
     * @param contactType
     *            The contactType to set.
     */
    public void setContactType(Integer contactType) {
        this.contactType = contactType;
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
