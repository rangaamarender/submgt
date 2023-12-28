/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.lucid.base.test.BaseTest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.PaymentMethod;
import com.stripe.model.PaymentMethodCollection;
import com.stripe.param.CustomerListPaymentMethodsParams;

/**
 * @author sgutti
 * @date 04-May-2023 11:55:40 pm
 */
public class TestStrip extends BaseTest {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>TestStrip</code>
     */
    public TestStrip() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    // @Test
    public void testCreateCustomer() throws StripeException {
        Stripe.apiKey = "sk_test_51N2yuTSFjPlsQ2rQG6ZlnE8O8FNDleZiHtcd2VlIwROP2Rrl8hq2K8AZp7hUG9xFDNZ1O7HrsfHItrDKqkqXeXNp00kmo6xekV";

        Map<String, Object> params = new HashMap<>();
        params.put("description", "TEST CUSTOMER");
        // "My First Test Customer (created for API docs at
        // https://www.stripe.com/docs/api)");

        Customer customer = Customer.create(params);
        System.out.println(customer.getId());
    }

    // @Test
    public void testCreatePymntMethod() throws StripeException {
        Stripe.apiKey = "sk_test_51N2yuTSFjPlsQ2rQG6ZlnE8O8FNDleZiHtcd2VlIwROP2Rrl8hq2K8AZp7hUG9xFDNZ1O7HrsfHItrDKqkqXeXNp00kmo6xekV";
        Map<String, Object> card = new HashMap<>();
        card.put("number", "4242424242424242");
        card.put("exp_month", 8);
        card.put("exp_year", 2024);
        card.put("cvc", "314");
        Map<String, Object> params = new HashMap<>();
        params.put("type", "card");
        params.put("card", card);
        // params.put("customer", "cus_OyAt0M0udalBRJ");
        PaymentMethod paymentMethod = PaymentMethod.create(params);
        System.out.println(paymentMethod.getId());
    }

    // @Test
    public void testAttachPymntMethod2Customer() throws StripeException {
        Stripe.apiKey = "sk_test_51N2yuTSFjPlsQ2rQG6ZlnE8O8FNDleZiHtcd2VlIwROP2Rrl8hq2K8AZp7hUG9xFDNZ1O7HrsfHItrDKqkqXeXNp00kmo6xekV";
        PaymentMethod paymentMethod = PaymentMethod.retrieve("pm_1OAEY9SFjPlsQ2rQ2jeN3Xwt");

        Map<String, Object> params = new HashMap<>();
        params.put("customer", "cus_OyAt0M0udalBRJ");

        PaymentMethod updatedPaymentMethod = paymentMethod.attach(params);

        System.out.println(updatedPaymentMethod.getCustomer());
    }

    /**
     * @throws StripeException
     */
    @Test
    public void testRetrieveCustomerPaymentMethods() throws StripeException {
        Stripe.apiKey = "sk_test_51N2yuTSFjPlsQ2rQG6ZlnE8O8FNDleZiHtcd2VlIwROP2Rrl8hq2K8AZp7hUG9xFDNZ1O7HrsfHItrDKqkqXeXNp00kmo6xekV";
        Customer customer = Customer.retrieve("cus_OyAt0M0udalBRJ");

        CustomerListPaymentMethodsParams params = CustomerListPaymentMethodsParams.builder()
                .setType(CustomerListPaymentMethodsParams.Type.CARD).build();

        PaymentMethodCollection paymentMethods = customer.listPaymentMethods(params);
        List<PaymentMethod> pymtMethods = paymentMethods.getData();
        for (PaymentMethod paymentMethod : pymtMethods) {
            System.out.println("Payment Method:" + paymentMethod.getId());
        }
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
