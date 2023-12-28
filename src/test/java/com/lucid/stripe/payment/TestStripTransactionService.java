/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.stripe.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lucid.base.test.BaseTransactionTest;
import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.exception.PaymentException;

/**
 * @author sgutti
 * @date 15-Nov-2023 8:43:55 pm
 */
public class TestStripTransactionService extends BaseTransactionTest {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private StripeTransactionService stripeTransactionService;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>TestStripTransactionService</code>
     */
    public TestStripTransactionService() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    @Test
    public void testAuthorizePaymentIntent() throws PaymentException {
        PaymentRequestDTO requestDTO = new PaymentRequestDTO();
        requestDTO.gtwyPymntMethodID("pm_1OChaDSFjPlsQ2rQXFm9M4A9");
        requestDTO.gtwyCustomerID("cus_P0iSp7ygGa65M6");
        requestDTO.transactionTotal("100");
        requestDTO.orderCurrencyCode("inr");
        stripeTransactionService.authorize(requestDTO);
    }

    @Test
    public void testCaputurePaymentIntent() throws PaymentException {
        PaymentRequestDTO requestDTO = new PaymentRequestDTO();

        requestDTO.gtwyPymntIntentID("pi_3OCkr7SFjPlsQ2rQ0JygJi1V");
        stripeTransactionService.capture(requestDTO);
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
