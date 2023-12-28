/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.joda.time.DateTime;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.lucid.core.base.BaseServiceImpl;
import com.lucid.core.constants.EnumStatus;
import com.lucid.core.email.EmailContent;
import com.lucid.core.email.EmailHelper;
import com.lucid.core.email.MustacheTemplateEngine;
import com.lucid.core.exception.ApplicationException;
import com.lucid.payment.dao.GtwyCustomerProfileDAO;
import com.lucid.payment.dao.GtwyCustomerPymntProfileDAO;
import com.lucid.payment.data.GtwyCustomerPymntProfileVO;
import com.lucid.payment.dto.AddressDTO;
import com.lucid.payment.dto.CreditCardDTO;
import com.lucid.payment.dto.GatewayCustomerDTO;
import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.dto.PaymentResponseDTO;
import com.lucid.payment.entity.GtwyCustomerProfile;
import com.lucid.payment.entity.GtwyCustomerPymntProfile;
import com.lucid.payment.exception.PaymentException;
import com.lucid.payment.mapper.GtwyCustomerPymntProfileMapper;
import com.lucid.stripe.payment.StripeCreditCardService;
import com.lucid.stripe.payment.StripeCustomerService;
import com.lucid.subscription.config.PlanConfig;
import com.lucid.subscription.constants.EnumSubStatus;
import com.lucid.subscription.constants.EnumSubscription;
import com.lucid.subscription.dao.PlanFeatureDAO;
import com.lucid.subscription.dao.PlanLimitDAO;
import com.lucid.subscription.dao.SignupTrackerDAO;
import com.lucid.subscription.dao.SubBillingDAO;
import com.lucid.subscription.dao.SubContactDAO;
import com.lucid.subscription.dao.SubInvoiceDAO;
import com.lucid.subscription.dao.SubPaymentDAO;
import com.lucid.subscription.dao.SubscriptionDAO;
import com.lucid.subscription.dao.SubscriptionTrackerDAO;
import com.lucid.subscription.data.SignupTrackerVO;
import com.lucid.subscription.data.SubBillingVO;
import com.lucid.subscription.data.SubContactVO;
import com.lucid.subscription.data.SubInvoiceVO;
import com.lucid.subscription.data.SubPaymentVO;
import com.lucid.subscription.data.SubscriptionData;
import com.lucid.subscription.data.SubscriptionTrackerVO;
import com.lucid.subscription.data.SubscriptionVO;
import com.lucid.subscription.entity.PlanFeature;
import com.lucid.subscription.entity.PlanLimit;
import com.lucid.subscription.entity.SignupTracker;
import com.lucid.subscription.entity.SubBilling;
import com.lucid.subscription.entity.SubContact;
import com.lucid.subscription.entity.SubInvoice;
import com.lucid.subscription.entity.SubPayment;
import com.lucid.subscription.entity.Subscription;
import com.lucid.subscription.entity.SubscriptionTracker;
import com.lucid.subscription.jaxb.FeatureType;
import com.lucid.subscription.jaxb.PlanLimitType;
import com.lucid.subscription.mapper.SignupTrackerMapper;
import com.lucid.subscription.mapper.SubBillingMapper;
import com.lucid.subscription.mapper.SubContactMapper;
import com.lucid.subscription.mapper.SubInvoiceMapper;
import com.lucid.subscription.mapper.SubPaymentMapper;
import com.lucid.subscription.mapper.SubscriptionMapper;
import com.lucid.subscription.mapper.SubscriptionTrackerMapper;
import com.lucid.tenant.dao.TenantAddressDAO;
import com.lucid.tenant.dao.TenantDAO;
import com.lucid.tenant.dao.TenantProfileDAO;
import com.lucid.tenant.entity.Tenant;
import com.lucid.tenant.entity.TenantAddress;
import com.lucid.tenant.entity.TenantProfile;
import com.lucid.util.EnvConfig;
import com.lucid.util.FileUtility;
import com.lucid.util.GenerateKeys;

import jakarta.mail.MessagingException;
import jakarta.persistence.PersistenceException;

/**
 * @author sgutti
 * @date May 15, 2021 3:59:39 PM
 */
@Component(SubscriptionServiceImpl.SERVICE_NAME)
public class SubscriptionServiceImpl extends BaseServiceImpl implements SubscriptionService {
    // --------------------------------------------------------------- Constants
    public static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionServiceImpl.class);
    public static final String SERVICE_NAME = "subscriptionService";
    public static final String ERROR_SUB_0000 = "ERROR_SUB_0000";
    public static final String ERROR_SUB_0001 = "ERROR_SUB_0001";
    public static final String ERROR_SUB_0002 = "ERROR_SUB_0002";
    public static final String ERROR_SUB_0003 = "ERROR_SUB_0003";
    public static final String ERROR_SUB_0004 = "ERROR_SUB_0004";
    public static final String ERROR_SUB_0005 = "ERROR_SUB_0005";
    public static final String ERROR_SUB_0006 = "ERROR_SUB_0006";
    public static final String ERROR_SUB_0007 = "ERROR_SUB_0007";
    public static final String ERROR_SUB_0008 = "ERROR_SUB_0008";
    public static final String ERROR_SUB_0009 = "ERROR_SUB_0009";
    public static final String ERROR_SUB_0010 = "ERROR_SUB_0010";
    public static final String ERROR_SUB_0011 = "ERROR_SUB_0011";
    public static final String ERROR_SUB_0012 = "ERROR_SUB_0012";
    public static final String ERROR_SUB_0013 = "ERROR_SUB_0013";
    public static final String ERROR_SUB_0014 = "ERROR_SUB_0014";
    public static final String ERROR_SUB_0015 = "ERROR_SUB_0015";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private TenantDAO tenantDAO;
    @Autowired
    private TenantAddressDAO tenantAddressDAO;
    @Autowired
    private TenantProfileDAO tenantProfileDAO;
    @Autowired
    private SubscriptionDAO subscriptionDAO;
    @Autowired
    private PlanFeatureDAO planFeatureDAO;
    @Autowired
    private PlanLimitDAO planLimitDAO;
    @Autowired
    private SubContactDAO subContactDAO;
    @Autowired
    private SubInvoiceDAO subInvoiceDAO;
    @Autowired
    private SubPaymentDAO subPaymentDAO;
    @Autowired
    private GtwyCustomerProfileDAO gtwyCustomerProfileDAO;
    @Autowired
    private GtwyCustomerPymntProfileDAO subPaymentMethodDAO;
    @Autowired
    private SubscriptionTrackerDAO subscriptionTrackerDAO;
    @Autowired
    private EmailHelper emailHelper;
    @Autowired
    private FileUtility fileUtility;
    @Autowired
    private EnvConfig envConfig;
    @Autowired
    private MustacheTemplateEngine mustacheTemplateEngine;
    @Autowired
    private SubBillingDAO subBillingDAO;
    //
    @Autowired
    private StripeCustomerService stripeCustomerService;
    @Autowired
    private StripeCreditCardService stripeCreditCardService;
    //
    @Autowired
    private SignupTrackerDAO signupTrackerDAO;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>SubscriptionServiceImpl</code>
     */
    public SubscriptionServiceImpl() {
        super();
    }
    // ---------------------------------------------------------- Public Methods

    /**
     * @see com.lucid.subscription.SubscriptionService#createSubscription(com.lucid.subscription.data.SubscriptionData)
     */
    @Override
    @Transactional
    public SubscriptionVO createSubscription(SubscriptionData subscriptionData)
            throws ApplicationException {
        SubscriptionVO result = null;
        SubscriptionTracker subscriptionTracker = null;
        try {
            // TODO 0. validate all the input data
            // 1. Create a tenant in the system
            Tenant tenant = initialize(subscriptionData);
            tenantDAO.save(tenant);
            // 1a. Initialize tenant profile
            TenantProfile tenantProfile = initializeTenantProfile(tenant.getTenantID());
            tenantProfileDAO.save(tenantProfile);
            // 2. create the subscription
            Subscription subscription = initializeSubscription();
            subscription.setSubscriptionID(tenant.getTenantID());
            // TODO - have to create a new tenant for this
            subscription.setTenantID(tenant.getTenantID());
            // 2.1. initialize the plan
            String planCode = subscriptionData.getPlanCode();
            com.lucid.subscription.jaxb.PlanType plan = PlanConfig.getInstance().getPlan(planCode);
            if (plan == null) {
                throw new ApplicationException(ERROR_SUB_0001, "Unable to find the plan code " + planCode);
            }
            initializePlanType(subscription, planCode, plan);
            subscriptionDAO.save(subscription);
            // 2a initialize the subscription contact
            SubContact subContact = initializeSubContact(subscriptionData);
            subContact.setSubcriptionID(subscription.getSubscriptionID());
            subContact.setContactType(1);
            // subContact.setSubscription(subscription);
            subContactDAO.save(subContact);

            // 2d. initialize plan features
            List<PlanFeature> planFeatures = initializePlanFeatures(subscription, plan);
            planFeatureDAO.saveAll(planFeatures);
            // 2e. initialize the plan limits
            List<PlanLimit> planLimits = initializePlanLimits(subscription, plan);
            planLimitDAO.saveAll(planLimits);
            Optional<Subscription> tmp = subscriptionDAO.findById(subscription.getSubscriptionID());
            if (tmp.isPresent()) {
                SubscriptionMapper mapper = Mappers.getMapper(SubscriptionMapper.class);
                result = mapper.toVO(tmp.get());
            }
            // create a tracker
            subscriptionTracker = initializeSubscriptionTracker(subscription.getTenantID());
            subscriptionTrackerDAO.save(subscriptionTracker);
            if (envConfig.isProdMode()) {
                // TODO 4. send an email to subscription contact for thanking
                EmailContent emailContent = initializeEmailContent(subscriptionData);
                emailHelper.sendEmail(emailContent);
                // TODO 5. Send an email to company for authorizing the
                // subscription
                // as new customer
            }
        } catch (DataAccessException | PersistenceException | IOException | MessagingException e) {
            e.printStackTrace();
            throw new ApplicationException(ERROR_SUB_0001, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#createTenant(com.lucid.subscription.data.SubscriptionData)
     */
    @Override
    public SubscriptionVO createTenant(SubscriptionData subscriptionData) throws ApplicationException {
        SubscriptionVO result = null;
        try {
            // 0 - Check the signup tracker
            SignupTracker signupTracker = signupTrackerDAO.findByTrackerCode(subscriptionData.getTrackerCode());
            if (signupTracker == null) {
                throw new ApplicationException(ERROR_SUB_0001, "invalid request " + subscriptionData.getTrackerCode());
            }
            // TODO 0. validate all the input data
            // 1. Create a tenant in the system
            Tenant tenant = initialize(subscriptionData);
            tenantDAO.save(tenant);
            // 2. create the subscription
            Subscription subscription = initializeSubscription();
            subscription.setSubscriptionID(tenant.getTenantID());
            // TODO - have to create a new tenant for this
            subscription.setTenantID(tenant.getTenantID());
            // 2.1. initialize the plan
            String planCode = subscriptionData.getPlanCode();
            com.lucid.subscription.jaxb.PlanType plan = PlanConfig.getInstance().getPlan(planCode);
            if (plan == null) {
                throw new ApplicationException(ERROR_SUB_0001, "Unable to find the plan code " + planCode);
            }
            initializePlanType(subscription, planCode, plan);
            subscriptionDAO.save(subscription);
            // 2a initialize the subscription contact
            SubContact subContact = initializeSubContact(subscriptionData);
            subContact.setSubcriptionID(subscription.getSubscriptionID());
            subContact.setContactType(1);
            // subContact.setSubscription(subscription);
            subContactDAO.save(subContact);
            // 2d. initialize plan features
            List<PlanFeature> planFeatures = initializePlanFeatures(subscription, plan);
            planFeatureDAO.saveAll(planFeatures);
            // 2e. initialize the plan limits
            List<PlanLimit> planLimits = initializePlanLimits(subscription, plan);
            planLimitDAO.saveAll(planLimits);
            Optional<Subscription> tmp = subscriptionDAO.findById(subscription.getSubscriptionID());
            if (tmp.isPresent()) {
                SubscriptionMapper mapper = Mappers.getMapper(SubscriptionMapper.class);
                result = mapper.toVO(tmp.get());
            }
            // update the signup tracker to INACTIVE since the registration is
            // completed
            signupTracker.setStatus(EnumStatus.INACTIVE);
            signupTrackerDAO.save(signupTracker);

            // TODO 4. send an email to subscription contact for thanking
            EmailContent emailContent = initializeEmailContent(subscriptionData);
            emailHelper.sendEmail(emailContent);

        } catch (DataAccessException | PersistenceException | IOException | MessagingException e) {
            e.printStackTrace();
            throw new ApplicationException(ERROR_SUB_0001, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#retrieveSubscription(long)
     */
    @Override
    @Transactional(readOnly = true)
    public SubscriptionVO retrieveSubscription(long tenantID) throws ApplicationException {
        SubscriptionVO result = null;
        try {
            Optional<Subscription> tmp = subscriptionDAO.findById(tenantID);
            if (tmp.isEmpty()) {
                throw new ApplicationException(ERROR_SUB_0001, ERROR_SUB_0001);
            }
            Subscription subscripition = tmp.get();
            SubscriptionMapper mapper = Mappers.getMapper(SubscriptionMapper.class);
            result = mapper.toVO(subscripition);
            Optional<SubBilling> subBillingResult = subBillingDAO.findById(subscripition.getSubscriptionID());
            SubBilling subBilling = subBillingResult.isPresent() ? subBillingResult.get() : null;
            // populate the billing details
            if (subBilling != null) {
                result.setHasBillingSetup(true);
                result.setEffectiveDt(subBilling.getEffectiveDt());
                result.setBillPeriodUnit(subBilling.getBillPeriodUnit());
                result.setBillcycleDay(subBilling.getBillcycleDay());
                result.setNextBillDt(subBilling.getNextBillDt());
                result.setInvoiceType(subBilling.getInvoiceType());
                result.setBalanceAmt(subBilling.getBalanceAmt());
            }
        } catch (DataAccessException | PersistenceException e) {
            throw new ApplicationException(ERROR_SUB_0002, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#authorizeSubscription(long,String)
     */
    @Override
    @Transactional
    public SubscriptionVO authorizeSubscription(long tenantID, String approvedBy)
            throws ApplicationException {
        SubscriptionVO result = null;
        try {
            Optional<Subscription> tmp = subscriptionDAO.findById(tenantID);
            if (tmp.isEmpty()) {
                throw new ApplicationException(ERROR_SUB_0001, ERROR_SUB_0001);
            }
            Subscription subscripition = tmp.get();
            subscripition.setStatus(EnumSubStatus.AUTHORIZED);
            subscripition.setApprovedBy(approvedBy);
            subscripition.setApprovedDt(Calendar.getInstance().getTime());
            subscriptionDAO.save(subscripition);
            Tenant tenant = tenantDAO.findByTenantID(tenantID);
            tenant.setStatus(EnumStatus.ACTIVE);
            tenant.setUpdatedBy(approvedBy);
            tenant.setUpdatedDt(Calendar.getInstance().getTime());
            tenantDAO.save(tenant);
            // refresh
            tmp = subscriptionDAO.findById(tenantID);
            SubscriptionMapper mapper = Mappers.getMapper(SubscriptionMapper.class);
            result = mapper.toVO(tmp.get());
        } catch (DataAccessException | PersistenceException e) {
            throw new ApplicationException(ERROR_SUB_0003, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#retrieveLastTenPayments(long)
     */
    @Override
    public List<SubPaymentVO> retrieveLastTenPayments(long subscriptionID)
            throws ApplicationException {
        List<SubPaymentVO> result = null;
        try {
            List<SubPayment> payments = subPaymentDAO.findBySubscriptionID(subscriptionID);
            SubPaymentMapper mapper = Mappers.getMapper(SubPaymentMapper.class);
            result = mapper.toVOList(payments);
        } catch (DataAccessException | PersistenceException e) {
            throw new ApplicationException(ERROR_SUB_0005, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#retrieveLastTenOpenInvoices(long)
     */
    @Override
    public List<SubInvoiceVO> retrieveLastTenOpenInvoices(long subscriptionID)
            throws ApplicationException {
        List<SubInvoiceVO> result = null;
        try {
            List<SubInvoice> invoices = subInvoiceDAO.findBySubscriptionID(subscriptionID);
            SubInvoiceMapper mapper = Mappers.getMapper(SubInvoiceMapper.class);
            result = mapper.toVOList(invoices);
        } catch (DataAccessException | PersistenceException e) {
            throw new ApplicationException(ERROR_SUB_0006, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#addPaymentMethod(long,
     *      com.lucid.subscription.data.SubPaymentMethodVO)
     */
    @Override
    @Transactional
    public GtwyCustomerPymntProfileVO addPaymentMethod(long subscriptionID,
                                                       CreditCardDTO creditCardDTO)
            throws ApplicationException {
        GtwyCustomerPymntProfileVO result = null;
        try {
            GtwyCustomerProfile gtwyCustomerProfile = gtwyCustomerProfileDAO.findBy(subscriptionID, "STRIPE");
            if (gtwyCustomerProfile == null) {
                // initialize Gtway customer profile
                gtwyCustomerProfile = initializeGtwyCustomerProfile(subscriptionID);
                // Create Gtway Customer Payment Profile
                gtwyCustomerProfile.setChargeType("ONE-TIME");
                gtwyCustomerProfile.setCustomerIPAddress("NA");
                gtwyCustomerProfile.setEmail("NA");
                gtwyCustomerProfileDAO.save(gtwyCustomerProfile);
            }
            // Create the reference in the system
            GtwyCustomerPymntProfile subPaymentMethod = initializeGtwyCustomerPymntProfile(gtwyCustomerProfile,
                    creditCardDTO);
            subPaymentMethod.setDefaultPymntInd(Boolean.FALSE);
            subPaymentMethodDAO.save(subPaymentMethod);
            GtwyCustomerPymntProfileMapper mapper = Mappers.getMapper(GtwyCustomerPymntProfileMapper.class);
            result = mapper.toVO(subPaymentMethod);
        } catch (DataAccessException | PersistenceException | PaymentException e) {
            throw new ApplicationException(ERROR_SUB_0007, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @param subscriptionID
     * @return
     * @throws PaymentException
     */
    private GtwyCustomerProfile initializeGtwyCustomerProfile(long subscriptionID)
            throws PaymentException {
        GtwyCustomerProfile result = null;
        // Get the tenant
        Tenant tenant = tenantDAO.findByTenantID(subscriptionID);
        // Invoke Strip to create the customer profile
        PaymentRequestDTO requestDTO = new PaymentRequestDTO();
        GatewayCustomerDTO customer = requestDTO.customer();
        customer.companyName(tenant.getCompanyName());
        customer.customerId(tenant.getTenantID() + "-" + tenant.getExternalCode());
        // customer.email(tenant.get.letterify("testing??????") + "@utest.com");
        // customer.phone(FAKER.phoneNumber().phoneNumber());
        //
        TenantAddress tenantAddress = tenantAddressDAO.findBillingAddress(subscriptionID);
        if (tenantAddress != null) {
            AddressDTO address = requestDTO.billTo();
            address.addressLine1(tenantAddress.getAddressLine1());
            address.addressLine2(tenantAddress.getAddressLine2());
            address.addressCityLocality(tenantAddress.getCity());
            address.addressStateRegion(tenantAddress.getStateCode());
            address.addressPostalCode(tenantAddress.getPostalCode());
            address.addressCountryCode(tenantAddress.getCountryCode());
        }
        //
        PaymentResponseDTO responseDTO = stripeCustomerService.createGatewayCustomer(requestDTO);
        GatewayCustomerDTO gtwCustomerDTO = responseDTO.getCustomer();
        result = new GtwyCustomerProfile();
        result.setSubscriptionID(subscriptionID);
        result.setGtwyID("STRIPE");
        result.setGtwyCustomerID(gtwCustomerDTO.getCustomerId());
        result.setCreatedBy("SYSTEM");
        result.setCreatedDt(Calendar.getInstance().getTime());
        return result;
    }

    private GtwyCustomerPymntProfile initializeGtwyCustomerPymntProfile(
                                                                        GtwyCustomerProfile gtwyCustomerProfile,
                                                                        CreditCardDTO creditCardDTO)
            throws PaymentException {
        GtwyCustomerPymntProfile result = null;
        String customerID = gtwyCustomerProfile.getGtwyCustomerID();
        //
        PaymentRequestDTO requestDTO = new PaymentRequestDTO();
        CreditCardDTO tmp = requestDTO.creditCard();
        tmp.creditCardCvv(creditCardDTO.getCreditCardCvv());
        tmp.creditCardExpDate(creditCardDTO.getCreditCardExpDate());
        tmp.creditCardExpMonth(creditCardDTO.getCreditCardExpMonth());
        tmp.creditCardExpYear(creditCardDTO.getCreditCardExpYear());
        tmp.creditCardHolderName(creditCardDTO.getCreditCardHolderName());
        tmp.creditCardNum(creditCardDTO.getCreditCardNum());
        tmp.creditCardType(creditCardDTO.getCreditCardType());

        // Create the payment method in gateway
        PaymentResponseDTO response = stripeCreditCardService.createGatewayCreditCard(requestDTO);
        String paymentID = response.getCreditCard().getPaymentID();

        // Attache the payment method to customer
        requestDTO.gtwyCustomerID(customerID);
        requestDTO.gtwyPymntMethodID(paymentID);

        stripeCreditCardService.attachGatewayCreditCard(requestDTO);
        //
        result = new GtwyCustomerPymntProfile();
        result.setGtwyCustomerProfileID(gtwyCustomerProfile.getGtwyCustomerProfileID());
        result.setGtwyPymntProfileID(paymentID);
        result.setPymntMethodID(paymentID);
        result.setDefaultPymntInd(Boolean.FALSE);
        result.setLast4Digits(response.getCreditCard().getCreditCardLastFour());
        result.setStatus(EnumStatus.ACTIVE);
        result.setName(creditCardDTO.getName());
        return result;
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#retrievePaymentMethods(long)
     */
    @Override
    public List<GtwyCustomerPymntProfileVO> retrievePaymentMethods(long subscriptionID)
            throws ApplicationException {
        List<GtwyCustomerPymntProfileVO> result = null;
        try {
            GtwyCustomerProfile gtwyCustomerProfile = gtwyCustomerProfileDAO.findBy(subscriptionID, "STRIPE");
            if (gtwyCustomerProfile == null) {
                // NO payment methods
                result = Collections.emptyList();
                return result;
            }
            String gtwyCustomerProfileID = gtwyCustomerProfile.getGtwyCustomerProfileID();
            List<GtwyCustomerPymntProfile> pymntMethods = subPaymentMethodDAO
                    .findByCustomerProfile(gtwyCustomerProfileID);
            GtwyCustomerPymntProfileMapper mapper = Mappers.getMapper(GtwyCustomerPymntProfileMapper.class);
            result = mapper.toVOList(pymntMethods);
        } catch (DataAccessException | PersistenceException e) {
            throw new ApplicationException(ERROR_SUB_0006, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#retrieveSubscriptionTracker(java.lang.String)
     */
    @Override
    public SubscriptionTrackerVO retrieveSubscriptionTracker(String trackerCode)
            throws ApplicationException {
        SubscriptionTrackerVO result = null;
        try {
            SubscriptionTracker tracker = subscriptionTrackerDAO.findTracker(trackerCode);
            SubscriptionTrackerMapper mapper = Mappers.getMapper(SubscriptionTrackerMapper.class);
            result = mapper.toVO(tracker);
        } catch (DataAccessException | PersistenceException e) {
            LOGGER.error(ERROR_SUB_0009, e.getLocalizedMessage(), e);
            throw new ApplicationException(ERROR_SUB_0009, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#setupBilling(long,
     *      com.lucid.subscription.data.SubBillingVO)
     */
    @Override
    public void setupBilling(long subscriptionID, SubBillingVO subBillingVO)
            throws ApplicationException {
        try {
            Optional<Subscription> tmp = subscriptionDAO.findById(subscriptionID);
            if (tmp.isEmpty()) {
                throw new ApplicationException(ERROR_SUB_0001, ERROR_SUB_0001);
            }
            Subscription subscription = tmp.get();
            Optional<SubBilling> subBillingResult = subBillingDAO.findById(subscriptionID);
            SubBilling subBilling = subBillingResult.isPresent() ? subBillingResult.get() : null;
            // already billing is set up
            if (subBilling != null) {
                return;
            }
            SubBillingMapper mapper = Mappers.getMapper(SubBillingMapper.class);
            subBilling = mapper.toEntity(subBillingVO);
            subBilling.setSubscriptionID(subscriptionID);
            subBilling.setCreatedBy(subBillingVO.getCreatedBy());
            subBilling.setCreatedDt(Calendar.getInstance().getTime());
            subBillingDAO.save(subBilling);
        } catch (DataAccessException | PersistenceException e) {
            LOGGER.error(ERROR_SUB_0009, e.getLocalizedMessage(), e);
            throw new ApplicationException(ERROR_SUB_0010, e.getLocalizedMessage(), e);
        }
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    /**
     * @return
     */
    private Subscription initializeSubscription() {
        Subscription subscription = new Subscription();
        subscription.setAcctNbr(GenerateKeys.generateSubAcctNbr());
        subscription.setStatus(EnumStatus.INACTIVE);
        subscription.setCreatedDt(Calendar.getInstance().getTime());
        subscription.setPhase(1);
        subscription.setTrailDays(15);
        return subscription;
    }

    /**
     * @param planCode
     * @return
     */
    private void initializePlanType(Subscription subscription, String planCode,
                                    com.lucid.subscription.jaxb.PlanType plan) {
        subscription.setPlanCode(planCode);
        subscription.setPlanDesc(plan.getPlanDescription());
        DateTime currentDate = new DateTime();
        subscription.setStartDt(currentDate.toDate());
        subscription.setEndDt(currentDate.plusDays(30).toDate());
    }

    /**
     * @param subscriptionData
     * @return
     */
    private SubContact initializeSubContact(SubscriptionData subscriptionData) {
        SubContact subContact = new SubContact();
        subContact.setFirstName(subscriptionData.getFirstName());
        subContact.setLastName(subscriptionData.getLastName());
        subContact.setEmailID(subscriptionData.getEmailID());
        subContact.setPhoneNbr(subscriptionData.getPhoneNbr());
        subContact.setContactType(1);
        return subContact;
    }

    /**
     * @param subscription
     * @param plan
     * @return
     */
    private List<PlanLimit> initializePlanLimits(Subscription subscription,
                                                 com.lucid.subscription.jaxb.PlanType plan) {
        List<PlanLimit> planLimits = new ArrayList<>();
        List<PlanLimitType> planLimitTypes = plan.getPlanLimit();
        for (PlanLimitType planLimitType : planLimitTypes) {
            PlanLimit planLimit = new PlanLimit();
            planLimit.setPlanLimitCode(planLimitType.getPlanLimitCode());
            planLimit.setPlanLimitDesc(planLimitType.getPlanLimitDescription());
            planLimit.setCredits(planLimitType.getCredits().intValue());
            planLimit.setSubscriptionID(subscription.getSubscriptionID());
            planLimit.setAvailableCredits(0);
            // planLimit.setPlanType(planTypeID);
            planLimits.add(planLimit);
        }
        return planLimits;
    }

    /**
     * @param subscriptionData
     * @return
     */
    private Tenant initialize(SubscriptionData subscriptionData) {
        Tenant tenant = new Tenant();
        tenant.setCompanyName(subscriptionData.getCompanyName());
        tenant.setCreatedBy(subscriptionData.getEmailID());
        tenant.setCreatedDt(Calendar.getInstance().getTime());
        tenant.setExternalCode(GenerateKeys.generateTenantExternalCode());
        tenant.setWebsite(subscriptionData.getWebsite());
        tenant.setStatus(EnumStatus.ACTIVE);
        return tenant;
    }

    /**
     * @param tenantID
     * @return
     */
    private TenantProfile initializeTenantProfile(long tenantID) {
        TenantProfile tenantProfile = new TenantProfile();
        tenantProfile.setTenantProfileID(tenantID);
        return tenantProfile;
    }

    /**
     * @param subscription
     * @param plan
     * @return
     */
    private List<PlanFeature> initializePlanFeatures(Subscription subscription,
                                                     com.lucid.subscription.jaxb.PlanType plan) {
        List<PlanFeature> planFeatureList = new ArrayList<>();
        List<FeatureType> featureList = plan.getFeature();
        for (FeatureType featureType : featureList) {
            PlanFeature planFeature = new PlanFeature();
            // planFeature.setPlanTypeID(planType.getPlanTypeID());
            planFeature.setFeatureCode(featureType.getFeatureCode());
            planFeature.setFeatureDesc(featureType.getFeatureDescription());
            planFeature.setStartDt(subscription.getStartDt());
            planFeature.setEndDt(subscription.getEndDt());
            planFeature.setStatus(EnumStatus.ACTIVE);
            planFeature.setSubscriptionID(subscription.getSubscriptionID());
            planFeatureList.add(planFeature);
        }
        return planFeatureList;
    }

    /**
     * @param tenantID
     * @return
     */
    private SubscriptionTracker initializeSubscriptionTracker(long tenantID) {
        SubscriptionTracker tracker = new SubscriptionTracker();
        tracker.setTenantID(tenantID);
        tracker.setStatus(EnumStatus.ACTIVE);
        tracker.setSentOn(Calendar.getInstance().getTime());
        tracker.setTrackerCode(GenerateKeys.generateSupplierCode(tenantID));
        return tracker;
    }

    /**
     * @param subscriptionData
     * @param subscriptionTracker
     * @return
     * @throws IOException
     */
    private EmailContent initializeEmailContent(SubscriptionData subscriptionData)
            throws IOException {
        Map<String, Object> values = new HashMap<>();
        values.put(EnumSubscription.COMPANY, subscriptionData.getCompanyName());
        values.put(EnumSubscription.NAME, subscriptionData.getCompanyName());
        values.put(EnumSubscription.LOGIN_URL,
                envConfig.getLoginURL());
        String templateText = getWelcomeSubscriptonEmailText();
        String email = mustacheTemplateEngine.executeTemplateText(templateText, values);
        EmailContent emailContent = new EmailContent();
        emailContent.addToList(subscriptionData.getEmailID());
        emailContent.setFrom(envConfig.getSupportEmailAddress());
        emailContent.setSubject("Welcome to Lucid RAVES");
        emailContent.setBody(email);
        return emailContent;
    }

    /**
     * @param signupTracker
     * @return
     * @throws IOException
     */
    private EmailContent initializeSignupEmailContent(SignupTracker signupTracker)
            throws IOException {
        Map<String, Object> values = new HashMap<>();
        values.put(EnumSubscription.COMPANY, signupTracker.getCompanyName());
        values.put(EnumSubscription.NAME, signupTracker.getCompanyName());
        values.put(EnumSubscription.URL,
                envConfig.getSubscriptionInitURL(signupTracker.getTrackerCode()));
        String templateText = getSignupEmailText();
        String email = mustacheTemplateEngine.executeTemplateText(templateText, values);
        EmailContent emailContent = new EmailContent();
        emailContent.addToList(signupTracker.getEmailID());
        // emailContent.setFrom("luciddev@lucidtechinc.com");
        emailContent.setFrom(envConfig.getSupportEmailAddress());
        emailContent.setSubject("Welcome to Lucid RAVES");
        emailContent.setBody(email);
        return emailContent;
    }

    /**
     * @return
     * @throws IOException
     */
    public String getSignupEmailText() throws IOException {
        return fileUtility.getString(EnumSubscription.SIGNUP_EMAIL_TEMPLATE,
                EnumSubscription.EMAIL_TEMPLATES);
    }

    /**
     * @return
     * @throws IOException
     */
    public String getWelcomeSubscriptonEmailText() throws IOException {
        return fileUtility.getString(EnumSubscription.WC_EMAIL_TEMPLATE,
                EnumSubscription.EMAIL_TEMPLATES);
    }

    /**
     * @return
     * @throws IOException
     */
    public String getActivationSubscriptonEmailText() throws IOException {
        return fileUtility.getString(EnumSubscription.AS_EMAIL_TEMPLATE,
                EnumSubscription.EMAIL_TEMPLATES);
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#retrieveAll(int, int)
     */

    @Override
    public Page<SubscriptionVO> retrieveAll(int page, int pageSize) throws ApplicationException {
        Page<SubscriptionVO> result = null;
        try {
            Pageable pageable = PageRequest.of(page, pageSize);
            Page<Subscription> subscriptionPage = subscriptionDAO.findAll(pageable);
            SubscriptionMapper mapper = Mappers.getMapper(SubscriptionMapper.class);
            List<SubscriptionVO> subscriptionList = mapper.toVOList(subscriptionPage.toList());
            result = new PageImpl<SubscriptionVO>(subscriptionList, pageable,
                    subscriptionPage.getTotalElements());
        } catch (DataAccessException | PersistenceException e) {
            LOGGER.error(ERROR_SUB_0011, e.getLocalizedMessage(), e);
            throw new ApplicationException(ERROR_SUB_0011, e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public SubscriptionVO updateSubscriptionPlan(Long subscriptionId, String planCode)
            throws ApplicationException {
        Optional<Subscription> optionalSubscription = subscriptionDAO.findById(subscriptionId);
        if (optionalSubscription.isPresent()) {
            // 2c. initialize the plan
            com.lucid.subscription.jaxb.PlanType plan = PlanConfig.getInstance().getPlan(planCode);
            if (plan == null) {
                throw new ApplicationException(ERROR_SUB_0001, "Unable to find the plan code " + planCode);
            }
            Subscription subscription = optionalSubscription.get();
            subscription.setPlanCode(planCode);
            subscription.setPlanDesc(plan.getPlanDescription());
            DateTime currentDate = new DateTime();
            subscription.setStartDt(currentDate.toDate());
            subscription.setEndDt(currentDate.plusDays(30).toDate());
            // initialize the plan
            initializePlanType(subscription, planCode, plan);

            subscriptionDAO.save(subscription);
            // 2d. initialize plan features
            List<PlanFeature> planFeatures = initializePlanFeatures(subscription, plan);
            planFeatureDAO.saveAll(planFeatures);
            // 2e. initialize the plan limits
            List<PlanLimit> planLimits = initializePlanLimits(subscription, plan);
            planLimitDAO.saveAll(planLimits);
            // Refresh
            subscription = subscriptionDAO.findById(subscriptionId).get();
            SubscriptionMapper subscriptionMapper = Mappers.getMapper(SubscriptionMapper.class);
            return subscriptionMapper.toVO(subscription);
        } else {
            throw new ApplicationException(ERROR_SUB_0001,
                    "No Subscription Found with " + subscriptionId);
        }
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#retrieveAllContacts(int,
     *      int)
     */
    @Override
    public Page<SubContactVO> retrieveAllContacts(int page, int pageSize)
            throws ApplicationException {
        Page<SubContactVO> result = null;
        try {
            Pageable pageable = PageRequest.of(page, pageSize);
            Page<SubContact> subContactPage = subContactDAO.findAll(pageable);
            SubContactMapper mapper = Mappers.getMapper(SubContactMapper.class);
            List<SubContactVO> subContactList = mapper.toVOList(subContactPage.toList());
            result = new PageImpl<SubContactVO>(subContactList, pageable, subContactPage.getTotalElements());
        } catch (DataAccessException | PersistenceException e) {
            LOGGER.error(ERROR_SUB_0011, e.getLocalizedMessage(), e);
            throw new ApplicationException(ERROR_SUB_0011, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#createGatewayCustomerProfile(java.lang.Long)
     */
    @Override
    public void createGatewayCustomerProfile(Long subscriptionId) throws ApplicationException {
        Optional<Subscription> optionalSubscription = subscriptionDAO.findById(subscriptionId);
        if (optionalSubscription.isEmpty()) {
            throw new ApplicationException(ERROR_SUB_0001,
                    "Unable to find the subscription " + subscriptionId);
        }
        try {
            Subscription subscription = optionalSubscription.get();
            SubContact primaryContact = subContactDAO.findByPrimaryContact(subscriptionId);
            Tenant tenant = tenantDAO.findByTenantID(subscriptionId);
            PaymentRequestDTO requestDTO = new PaymentRequestDTO();
            GatewayCustomerDTO customer = requestDTO.customer();
            customer.companyName(tenant.getCompanyName());
            customer.customerId(tenant.getTenantID() + "-" + tenant.getExternalCode());
            customer.email(primaryContact.getEmailID());
            customer.phone(primaryContact.getPhoneNbr());
            // TODO
            // AddressDTO address = requestDTO.billTo();
            // address.addressLine1(billingAddress.streetAddress());
            // address.addressLine2(billingAddress.buildingNumber());
            // address.addressCityLocality(billingAddress.city());
            // address.addressStateRegion(billingAddress.stateAbbr());
            // address.addressPostalCode(billingAddress.zipCode());
            // address.addressCountryCode(billingAddress.countryCode());

            // create the customer profile in payment gateway
            stripeCustomerService.createGatewayCustomer(requestDTO);
            // Create the gateway customer profile for the customer

        } catch (DataAccessException | PersistenceException | PaymentException e) {
            LOGGER.error(ERROR_SUB_0012, e.getLocalizedMessage(), e);
            throw new ApplicationException(ERROR_SUB_0012, e.getLocalizedMessage(), e);
        }
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#signup(com.lucid.subscription.data.SignupTrackerVO)
     */
    @Override
    public SignupTrackerVO signup(SignupTrackerVO signupTrackerVO) throws ApplicationException {
        SignupTrackerVO result = null;
        try {
            Optional<SignupTracker> existingTracker = signupTrackerDAO.findById(signupTrackerVO.getEmailID());
            SignupTracker signupTracker = null;
            int count = 0;
            //
            SignupTrackerMapper mapper = Mappers.getMapper(SignupTrackerMapper.class);
            // existing - update the count
            if (existingTracker.isPresent()) {
                signupTracker = existingTracker.get();
                count = signupTracker.getCount();
                count += 1;
            }
            signupTracker = mapper.toEntity(signupTrackerVO);
            signupTracker.setCount(count);
            signupTracker.setTrackerCode(GenerateKeys.generateSignupTrackerCode());
            signupTracker.setLastUpdatedDt(Calendar.getInstance().getTime());
            signupTracker.setStatus(EnumStatus.ACTIVE);
            signupTrackerDAO.save(signupTracker);
            // Send the email
            EmailContent email = initializeSignupEmailContent(signupTracker);
            emailHelper.sendEmail(email);
            result = mapper.toVO(signupTracker);
        } catch (DataAccessException | PersistenceException | IOException | MessagingException e) {
            LOGGER.error(ERROR_SUB_0013, e.getLocalizedMessage(), e);
            throw new ApplicationException(ERROR_SUB_0013, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#verifySignup(java.lang.String)
     */
    @Override
    public SignupTrackerVO verifySignup(String trackerCode) throws ApplicationException {
        SignupTrackerVO result = null;
        try {
            SignupTracker signupTracker = signupTrackerDAO.findByTrackerCode(trackerCode);
            if (signupTracker == null) {
                throw new ApplicationException(ERROR_SUB_0000, "invalid signup request");
            }
            SignupTrackerMapper mapper = Mappers.getMapper(SignupTrackerMapper.class);
            SignupTrackerVO signupTrackerVO = mapper.toVO(signupTracker);
            if (!signupTrackerVO.isActive()) {
                throw new ApplicationException(ERROR_SUB_0000, "invalid signup request - link expired");
            }
            result = signupTrackerVO;
        } catch (DataAccessException | PersistenceException e) {
            LOGGER.error(ERROR_SUB_0014, e.getLocalizedMessage(), e);
            throw new ApplicationException(ERROR_SUB_0014, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubscriptionService#updateSubscription(com.lucid.subscription.data.SubscriptionVO)
     */
    @Override
    public SubscriptionVO updateSubscription(SubscriptionVO subscriptionVO)
            throws ApplicationException {
        SubscriptionVO result = null;
        try {
            Assert.notNull(subscriptionVO, "subscripiton cannot be null");
            long subscriptionId = subscriptionVO.getSubscriptionID();
            Optional<Subscription> optionalSubscription = subscriptionDAO.findById(subscriptionId);
            if (optionalSubscription.isEmpty()) {
                throw new ApplicationException(ERROR_SUB_0000, "no subscription or invalid data");
            }
            Subscription existingSub = optionalSubscription.get();
            SubscriptionMapper mapper = Mappers.getMapper(SubscriptionMapper.class);
            existingSub = mapper.toEntity(subscriptionVO);
            subscriptionDAO.save(existingSub);
            //

        } catch (DataAccessException | PersistenceException e) {
            LOGGER.error(ERROR_SUB_0014, e.getLocalizedMessage(), e);
            throw new ApplicationException(ERROR_SUB_0014, e.getLocalizedMessage(), e);
        }
        return result;
    }

    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
