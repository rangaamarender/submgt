/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import java.util.List;

import org.springframework.data.domain.Page;

import com.lucid.core.base.BaseService;
import com.lucid.core.exception.ApplicationException;
import com.lucid.payment.data.GtwyCustomerPymntProfileVO;
import com.lucid.payment.dto.CreditCardDTO;
import com.lucid.subscription.data.SignupTrackerVO;
import com.lucid.subscription.data.SubBillingVO;
import com.lucid.subscription.data.SubContactVO;
import com.lucid.subscription.data.SubInvoiceVO;
import com.lucid.subscription.data.SubPaymentVO;
import com.lucid.subscription.data.SubscriptionData;
import com.lucid.subscription.data.SubscriptionTrackerVO;
import com.lucid.subscription.data.SubscriptionVO;

/**
 * @author sgutti
 * @date May 15, 2021 3:58:21 PM
 */
public interface SubscriptionService extends BaseService {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods

    /**
     * @param signupTrackerVO
     * @return
     * @throws ApplicationException
     */
    SignupTrackerVO signup(SignupTrackerVO signupTrackerVO) throws ApplicationException;

    /**
     * @param trackerCode
     * @return
     * @throws ApplicationException
     */
    SignupTrackerVO verifySignup(String trackerCode) throws ApplicationException;

    /**
     * @param subscriptionData
     * @return
     * @throws ApplicationException
     */
    SubscriptionVO createSubscription(SubscriptionData subscriptionData) throws ApplicationException;

    /**
     * @param subscriptionData
     * @return
     * @throws ApplicationException
     */
    SubscriptionVO createTenant(SubscriptionData subscriptionData) throws ApplicationException;

    /**
     * @param tenantID
     * @return
     * @throws ApplicationException
     */
    SubscriptionVO retrieveSubscription(long tenantID) throws ApplicationException;

    /**
     * @param tenantID
     * @param approvedBy
     * @return
     * @throws ApplicationException
     */
    SubscriptionVO authorizeSubscription(long tenantID, String approvedBy)
            throws ApplicationException;

    /**
     * @param subscriptionID
     * @return
     * @throws ApplicationException
     */
    List<SubPaymentVO> retrieveLastTenPayments(long subscriptionID) throws ApplicationException;

    /**
     * @param subscriptionID
     * @return
     * @throws ApplicationException
     */
    List<SubInvoiceVO> retrieveLastTenOpenInvoices(long subscriptionID) throws ApplicationException;

    /**
     * @param subscriptionID
     * @param creditCardDTO
     * @throws ApplicationException
     */
    GtwyCustomerPymntProfileVO addPaymentMethod(long subscriptionID, CreditCardDTO creditCardDTO)
            throws ApplicationException;

    /**
     * @param subscriptionID
     * @return
     * @throws ApplicationException
     */
    List<GtwyCustomerPymntProfileVO> retrievePaymentMethods(long subscriptionID)
            throws ApplicationException;

    /**
     * @param trackerCode
     * @return
     * @throws ApplicationException
     */
    SubscriptionTrackerVO retrieveSubscriptionTracker(String trackerCode) throws ApplicationException;

    /**
     * @param subscriptionID
     * @param subBillingVO
     * @throws ApplicationException
     */
    void setupBilling(long subscriptionID, SubBillingVO subBillingVO) throws ApplicationException;

    /**
     * @param page
     * @param pageSize
     * @return
     * @throws ApplicationException
     */
    Page<SubscriptionVO> retrieveAll(int page, int pageSize) throws ApplicationException;

    /**
     * @param subscriptionId
     * @param planCode
     * @return
     * @throws ApplicationException
     */
    SubscriptionVO updateSubscriptionPlan(Long subscriptionId, String planCode)
            throws ApplicationException;

    /**
     * @param page
     * @param pageSize
     * @return
     * @throws ApplicationException
     */
    Page<SubContactVO> retrieveAllContacts(int page, int pageSize) throws ApplicationException;

    /**
     * @param subscriptionId
     * @throws ApplicationException
     */
    void createGatewayCustomerProfile(Long subscriptionId) throws ApplicationException;

    /**
     * @param subscriptionVO
     * @return
     * @throws ApplicationException
     */
    SubscriptionVO updateSubscription(SubscriptionVO subscriptionVO) throws ApplicationException;

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
