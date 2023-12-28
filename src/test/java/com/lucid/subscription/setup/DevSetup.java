/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.setup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.javafaker.Name;
import com.lucid.base.test.BaseTest;
import com.lucid.core.constants.EnumStatus;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.PromotionService;
import com.lucid.subscription.SubInvoiceService;
import com.lucid.subscription.SubMgtUserService;
import com.lucid.subscription.SubscriptionService;
import com.lucid.subscription.dao.SubscriptionDAO;
import com.lucid.subscription.data.PromotionData;
import com.lucid.subscription.data.SignupTrackerVO;
import com.lucid.subscription.data.SubInvoiceItemVO;
import com.lucid.subscription.data.SubInvoiceVO;
import com.lucid.subscription.data.SubMgtUserVO;
import com.lucid.subscription.data.SubscriptionData;
import com.lucid.subscription.data.SubscriptionVO;
import com.lucid.subscription.entity.Subscription;

/**
 * @author sgutti
 * @date May 16, 2021 12:04:01 PM
 */
public class DevSetup extends BaseTest {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private SubscriptionDAO subscriptionDAO;
    @Autowired
    private SubInvoiceService subInvoiceService;
    @Autowired
    private SubMgtUserService subMgtUserService;
    @Autowired
    private PromotionService promotionService;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>DevSetup</code>
     */
    public DevSetup() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * initalize
     * 
     * @throws ApplicationException
     */
    @Test
    public void intiateSubAndInvoices() throws ApplicationException {
        // initializeSubscriptions();
        // createInvoices();
        initializePromotions();
        // createSubMgtUsers();
        // initializeSignup();
    }

    // @Test
    public void initializeSubMgtUsers() throws ApplicationException {
        createSubMgtUsers();
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods

    private void initializePromotions() throws ApplicationException {
        DateTime today = new DateTime();
        for (int i = 0; i < 25; i++) {
            PromotionData promotionData = new PromotionData();
            promotionData.setName(FAKER.beer().name());
            int promotionType = RandomUtils.nextInt(1, 3);
            promotionData.setPromotionType(promotionType);
            promotionData.setSalesStartDate(today.toDate());
            promotionData.setSalesEndDate(today.plusMonths(1).toDate());
            promotionData.setCreatedBy("unittest@lucidraves.com");
            promotionData.setPromotionStatus(1);
            double amount = RandomUtils.nextDouble(10, 201);
            promotionData.setPromotionAmount(BigDecimal.valueOf(amount));
            promotionService.createPromotion(promotionData);
        }
    }

    /**
     * @throws ApplicationException
     */
    private void initializeSubscriptions() throws ApplicationException {
        for (int i = 0; i < 20; i++) {
            SubscriptionData subscriptionData = new SubscriptionData();
            subscriptionData.setCompanyName(FAKER.company().name());
            subscriptionData.setEmailID(FAKER.name().username() + "@ut.com");
            subscriptionData.setFirstName(FAKER.name().firstName());
            subscriptionData.setLastName(FAKER.name().lastName());
            subscriptionData.setPhoneNbr(FAKER.phoneNumber().phoneNumber());
            subscriptionData.setPlanCode("PRO");
            SubscriptionVO subscriptionVO = subscriptionService.createSubscription(subscriptionData);
            System.out.println("********************");
            System.out.println(subscriptionVO.getSubscriptionID() + "\t " + subscriptionVO.getAcctNbr());
            System.out.println("********************");
        }
    }

    private void initializeSignup() throws ApplicationException {
        for (int i = 0; i < 20; i++) {
            SignupTrackerVO signupTracker = new SignupTrackerVO();
            signupTracker.setCompanyName(FAKER.company().name());
            signupTracker.setEmailID(FAKER.name().username() + "@ut.com");
            SignupTrackerVO signupTrackerVO = subscriptionService.signup(signupTracker);
            System.out.println("********************");
            System.out.println(signupTrackerVO.getEmailID() + "\t " + signupTrackerVO.getCount());
            System.out.println("********************");
        }
    }

    /**
     * @throws ApplicationException
     */
    private void createSubMgtUsers() throws ApplicationException {
        for (int i = 0; i < 25; i++) {
            SubMgtUserVO subMgtUserVO = new SubMgtUserVO();
            Name name = FAKER.name();
            subMgtUserVO.setUserID(name.username());
            subMgtUserVO.setUsername(name.fullName());
            subMgtUserVO.setEmailID(name.username() + "@lucidraves.com");
            subMgtUserVO.setExternalCode(FAKER.letterify("U1?????"));
            subMgtUserVO.setPassword(FAKER.random().hex());
            subMgtUserVO.setRoleID(1l);
            subMgtUserVO.setSalt(FAKER.numerify("AZD###SEE"));
            subMgtUserVO.setStatus(EnumStatus.ACTIVE);
            subMgtUserVO.setUserType("INTERNAL");
            subMgtUserService.createUser("UNIT-TEST", subMgtUserVO);
        }
    }

    /**
     * @throws ApplicationException
     */
    // @Test
    private void createInvoices() throws ApplicationException {
        List<Subscription> subscriptions = subscriptionDAO.findAll();
        for (Subscription subscription : subscriptions) {
            createSubscriptionInvoices(subscription.getSubscriptionID());
        }
    }

    /**
     * @throws ApplicationException
     */
    @Test
    private void createNextInvoices() throws ApplicationException {
        List<Subscription> subscriptions = subscriptionDAO.findAll();
        for (Subscription subscription : subscriptions) {
            createSubscriptionNextInvoice(subscription.getSubscriptionID());
        }
    }

    /**
     * @param subscriptionID
     * @throws ApplicationException
     */
    private void createSubscriptionInvoices(long subscriptionID) throws ApplicationException {
        DateTime currentTime = new DateTime();
        DateTime lastYear = currentTime.minusYears(1);
        for (int i = 0; i < 13; i++) {
            DateTime invoiceDt = lastYear.plusMonths(i);
            SubInvoiceVO subInvoiceVO = initializeInvoice(subscriptionID, invoiceDt);
            subInvoiceService.createInvoice(subscriptionID, "system", subInvoiceVO);
        }
    }

    /**
     * @param subscriptionID
     * @throws ApplicationException
     */
    private void createSubscriptionNextInvoice(long subscriptionID) throws ApplicationException {
        subInvoiceService.createInvoice(subscriptionID);
    }

    /**
     * @param subscriptionID
     * @return
     */
    private SubInvoiceVO initializeInvoice(long subscriptionID, DateTime invoiceDt) {
        SubInvoiceVO subInvoice = new SubInvoiceVO();
        subInvoice.setCreatedBy("system");
        subInvoice.setCreatedDt(Calendar.getInstance().getTime());
        subInvoice.setDiscountAmt(BigDecimal.valueOf(0));
        double invoiceAmt = RandomUtils.nextDouble(1099, 99999);
        subInvoice.setInvoiceAmt(BigDecimal.valueOf(invoiceAmt));
        subInvoice.setInvoiceDt(invoiceDt.toDate());
        subInvoice.setUpdatedDt(Calendar.getInstance().getTime());
        subInvoice.setInvoiceDueDt(invoiceDt.plusDays(15).toDate());
        subInvoice.setInvoiceStatus(1);
        SubInvoiceItemVO subInvoiceItemVO = initializeInvoiceItem(invoiceAmt);
        List<SubInvoiceItemVO> invoiceItems = new ArrayList<>();
        invoiceItems.add(subInvoiceItemVO);
        subInvoice.setInvoiceItems(invoiceItems);
        return subInvoice;
    }

    /**
     * @param invoiceAmt
     * @return
     */
    private SubInvoiceItemVO initializeInvoiceItem(double invoiceAmt) {
        SubInvoiceItemVO subInvoiceItemVO = new SubInvoiceItemVO();
        subInvoiceItemVO.setItemCode("I0001");
        subInvoiceItemVO.setDescription("I001 TESTING");
        subInvoiceItemVO.setAmt(BigDecimal.valueOf(invoiceAmt));
        subInvoiceItemVO.setDiscountAmt(BigDecimal.valueOf(0));
        subInvoiceItemVO.setQty(BigDecimal.valueOf(1));
        subInvoiceItemVO.setRate(BigDecimal.valueOf(invoiceAmt));
        subInvoiceItemVO.setTaxAmt(BigDecimal.valueOf(0));
        return subInvoiceItemVO;
    }
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
