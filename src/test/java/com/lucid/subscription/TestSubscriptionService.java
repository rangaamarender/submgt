/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lucid.base.test.BaseTransactionTest;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.data.SignupTrackerVO;
import com.lucid.subscription.data.SubInvoiceVO;
import com.lucid.subscription.data.SubscriptionData;
import com.lucid.subscription.data.SubscriptionVO;

/**
 * @author sgutti
 * @date May 15, 2021 4:40:49 PM
 */
public class TestSubscriptionService extends BaseTransactionTest {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private SubscriptionService subscriptionService;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>TestSubscriptionService</code>
     */
    public TestSubscriptionService() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    @Test
    public void testCreateSubscription() throws ApplicationException {
        SubscriptionData subscriptionData = new SubscriptionData();
        subscriptionData.setCompanyName(FAKER.company().name());
        subscriptionData.setEmailID(FAKER.name().username() + "@ut.com");
        subscriptionData.setFirstName(FAKER.name().firstName());
        subscriptionData.setLastName(FAKER.name().lastName());
        subscriptionData.setPhoneNbr(FAKER.phoneNumber().phoneNumber());
        subscriptionData.setPlanCode("BASE");
        SubscriptionVO subscriptionVO = subscriptionService.createSubscription(subscriptionData);
        System.out.println("********************");
        System.out.println(subscriptionVO.getSubscriptionID() + "\t " + subscriptionVO.getAcctNbr());
        System.out.println("********************");
        Assertions.assertNotNull(subscriptionVO.getSubscriptionID());
    }

    @Test
    public void testSignup() throws ApplicationException {
        SignupTrackerVO signupTrackerVO = new SignupTrackerVO();
        signupTrackerVO.setCompanyName(FAKER.company().name());
        signupTrackerVO.setEmailID("charan.g@lucidtechinc.com");
        subscriptionService.signup(signupTrackerVO);
    }

    @Test
    public void testVerifySignup() throws ApplicationException {
        String trackerCode = "trck-202312-c4ea9b0c-c208-44e5-b149-be96a32d63d1";
        SignupTrackerVO signupTrackerVO = subscriptionService.verifySignup(trackerCode);
        System.out.println("========tsting========" + signupTrackerVO);
        Assertions.assertNotNull(signupTrackerVO);
    }

    /**
     * @throws ApplicationException
     */
    @Test
    public void testCreateTenant() throws ApplicationException {
        SubscriptionData subscriptionData = new SubscriptionData();
        subscriptionData.setTrackerCode("trck-202312-c4ea9b0c-c208-44e5-b149-be96a32d63d1");
        subscriptionData.setCompanyName(FAKER.company().name());
        subscriptionData.setEmailID(FAKER.name().username() + "@ut.com");
        subscriptionData.setFirstName(FAKER.name().firstName());
        subscriptionData.setLastName(FAKER.name().lastName());
        subscriptionData.setPhoneNbr(FAKER.phoneNumber().phoneNumber());
        subscriptionData.setWebsite(FAKER.company().url());
        subscriptionData.setPlanCode("BASE");
        SubscriptionVO subscriptionVO = subscriptionService.createTenant(subscriptionData);
        System.out.println("********************");
        System.out.println(subscriptionVO.getSubscriptionID() + "\t " + subscriptionVO.getAcctNbr());
        System.out.println("********************");
        Assertions.assertNotNull(subscriptionVO.getSubscriptionID());
    }

    /**
     * @throws ApplicationException
     */

    public void testRetrieveSubscription() throws ApplicationException {
        SubscriptionVO subscriptionVO = subscriptionService.retrieveSubscription(4l);
        System.out.println("********************");
        System.out.println(subscriptionVO.getSubscriptionID() + "\t " + subscriptionVO.getAcctNbr());
        System.out.println(subscriptionVO.getPlanCode());
        System.out.println("********************");
        Assertions.assertNotNull(subscriptionVO.getSubscriptionID());
    }

    /**
     * @throws ApplicationException
     */
    @Test
    public void testRetrieveInvoices() throws ApplicationException {
        List<SubInvoiceVO> invoices = subscriptionService.retrieveLastTenOpenInvoices(3l);
        Assertions.assertNotNull(invoices, "Got the invoices");
    }

    // @Test
    // public void testRetrievePayments() throws ApplicationException {
    // List<SubPaymentVO> payments =
    // subscriptionService.retrieveLastTenPayments(11l);
    // Assertions.assertNotNull(payments, "Got the payments");
    // }
    //
    // // @Test
    // public void testAddPymntMethod() throws ApplicationException {
    // SubPaymentMethodVO subPaymentMethodVO = new SubPaymentMethodVO();
    // subPaymentMethodVO.setAccountCode("ACC00001");
    // subPaymentMethodVO.setAccountID("A1");
    // subPaymentMethodVO.setBankID("CITIBANK");
    // subPaymentMethodVO.setCcyCode("123");
    // subPaymentMethodVO.setCountryCode("US");
    // subPaymentMethodVO.setMethodType("BANK");
    // subPaymentMethodVO.setNameOnAcct("GSR");
    // subscriptionService.addPaymentMethod(11l, subPaymentMethodVO);
    // Assertions.assertTrue(true, "Add the payment method");
    // }
    //
    // @Test
    // public void testRetrievePymntMethods() throws ApplicationException {
    // List<SubPaymentMethodVO> pymntMethods =
    // subscriptionService.retrievePaymentMethods(11l);
    // Assertions.assertNotNull(pymntMethods, "Got the payment methods");
    // }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
