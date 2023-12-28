/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.data;

import java.io.Serializable;

/**
 * @author sgutti
 * @date May 15, 2021 4:01:30 PM
 */
public class SubscriptionData implements Serializable {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -7197697067613876186L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // plan
    private String planCode;
    // contact details
    private String firstName;
    private String lastName;
    private String emailID;
    private String phoneNbr;
    // company details
    private String companyName;
    private String website;
    //
    private String trackerCode;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>SubscriptionData</code>
     */
    public SubscriptionData() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the planCode.
     */
    public String getPlanCode() {
        return planCode;
    }

    /**
     * @param planCode
     *            The planCode to set.
     */
    public void setPlanCode(String planCode) {
        this.planCode = planCode;
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

    /**
     * @return Returns the trackerCode.
     */
    public String getTrackerCode() {
        return trackerCode;
    }

    /**
     * @param trackerCode
     *            The trackerCode to set.
     */
    public void setTrackerCode(String trackerCode) {
        this.trackerCode = trackerCode;
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
