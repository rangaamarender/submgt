/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.data;

import com.lucid.core.vo.BaseVO;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:31:50 IST 2021
 */
public class SubContactVO extends BaseVO {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 1L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long subContactID;
    private String firstName;
    private String lastName;
    private String emailID;
    private String phoneNbr;
    private Long subscriptionID;
    private Integer contactType;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>SubContactVO</code>
     */
    public SubContactVO() {
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
     * @return Returns the subscriptionID.
     */
    public Long getSubscriptionID() {
        return subscriptionID;
    }

    /**
     * @param subscriptionID
     *            The subscriptionID to set.
     */
    public void setSubscriptionID(Long subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    /**
     * @return
     */
    public String getName() {
        return lastName + " " + firstName;
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

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SubContactVO [subContactID=");
        builder.append(subContactID);
        builder.append(", firstName=");
        builder.append(firstName);
        builder.append(", lastName=");
        builder.append(lastName);
        builder.append(", emailID=");
        builder.append(emailID);
        builder.append(", phoneNbr=");
        builder.append(phoneNbr);
        builder.append(", contactType=");
        builder.append(contactType);
        builder.append(", subscriptionID=");
        builder.append(subscriptionID);
        builder.append("]");
        return builder.toString();
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
