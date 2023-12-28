/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.stripe.payment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lucid.payment.PaymentType;
import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.dto.PaymentResponseDTO;
import com.lucid.payment.exception.PaymentException;
import com.lucid.payment.service.AbstractPaymentGatewayTransactionService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.net.StripeResponse;

/**
 * @author sgutti
 * @date 15-Nov-2023 7:54:08 pm
 */
@Component(StripeTransactionService.SERVICE_NAME)
public class StripeTransactionService extends AbstractPaymentGatewayTransactionService {
    // --------------------------------------------------------------- Constants
    public static final String SERVICE_NAME = "stripeTransaction";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private StripeConfiguration configuration;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>StripeTransactionService</code>
     */
    public StripeTransactionService() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * This is to create the paymentIntent
     * 
     * @see com.lucid.payment.service.AbstractPaymentGatewayTransactionService#authorize(com.lucid.payment.dto.PaymentRequestDTO)
     */
    @Override
    public PaymentResponseDTO authorize(PaymentRequestDTO requestDTO) throws PaymentException {
        PaymentType requestPaymentType = requestDTO.getPaymentType() == null ? PaymentType.CREDIT_CARD
                : requestDTO.getPaymentType();
        PaymentResponseDTO paymentResponse = new PaymentResponseDTO(requestPaymentType,
                StripeGatewayType.STRIPE);

        Stripe.apiKey = configuration.getApiKey();
        try {

            Map<String, Object> params = new HashMap<>();
            params.put("amount", requestDTO.getTransactionTotal());
            params.put("currency", requestDTO.getOrderCurrencyCode());
            params.put("customer", requestDTO.getGtwyCustomerID());
            params.put("confirm", "true");
            params.put("payment_method", requestDTO.getGtwyPymntMethodID());

            PaymentIntent paymentIntent = PaymentIntent.create(params);
            StripeResponse stripeResponse = paymentIntent.getLastResponse();
            System.out.println("Stripe Reponse :" + stripeResponse.code() + "---id----" + paymentIntent.getId());
            //

        } catch (StripeException e) {
            throw new PaymentException(e.getCode(), e.getMessage(), e);
        }

        return paymentResponse;
    }

    /**
     * This is to confirm the paymentIntent
     * 
     * @see com.lucid.payment.service.AbstractPaymentGatewayTransactionService#capture(com.lucid.payment.dto.PaymentRequestDTO)
     */
    @Override
    public PaymentResponseDTO capture(PaymentRequestDTO requestDTO) throws PaymentException {
        PaymentType requestPaymentType = requestDTO.getPaymentType() == null ? PaymentType.CREDIT_CARD
                : requestDTO.getPaymentType();
        PaymentResponseDTO paymentResponse = new PaymentResponseDTO(requestPaymentType,
                StripeGatewayType.STRIPE);

        Stripe.apiKey = configuration.getApiKey();
        try {

            PaymentIntent paymentIntent = PaymentIntent.retrieve(requestDTO.getGtwyPymntIntentID());

            PaymentIntent updatedPaymentIntent = paymentIntent.capture();

            StripeResponse stripeResponse = updatedPaymentIntent.getLastResponse();
            System.out.println("Stripe Reponse :" + stripeResponse.code() + "---id----" + updatedPaymentIntent.getId());
            //

        } catch (StripeException e) {
            throw new PaymentException(e.getCode(), e.getMessage(), e);
        }

        return paymentResponse;
    }

    /**
     * This is to create paymentIntent and confirm it.
     * 
     * @see com.lucid.payment.service.AbstractPaymentGatewayTransactionService#authorizeAndCapture(com.lucid.payment.dto.PaymentRequestDTO)
     */
    @Override
    public PaymentResponseDTO authorizeAndCapture(PaymentRequestDTO paymentRequestDTO) throws PaymentException {
        // TODO Auto-generated method stub
        return super.authorizeAndCapture(paymentRequestDTO);
    }

    /**
     * This is to cancel the paymentIntent
     * 
     * @see com.lucid.payment.service.AbstractPaymentGatewayTransactionService#reverseAuthorize(com.lucid.payment.dto.PaymentRequestDTO)
     */
    @Override
    public PaymentResponseDTO reverseAuthorize(PaymentRequestDTO paymentRequestDTO) throws PaymentException {
        // TODO Auto-generated method stub
        return super.reverseAuthorize(paymentRequestDTO);
    }

    /**
     * This is to refund the paymentIntent which is confirmed
     * 
     * @see com.lucid.payment.service.AbstractPaymentGatewayTransactionService#refund(com.lucid.payment.dto.PaymentRequestDTO)
     */
    @Override
    public PaymentResponseDTO refund(PaymentRequestDTO paymentRequestDTO) throws PaymentException {
        // TODO Auto-generated method stub
        return super.refund(paymentRequestDTO);
    }

    /**
     * @see com.lucid.payment.service.AbstractPaymentGatewayTransactionService#voidPayment(com.lucid.payment.dto.PaymentRequestDTO)
     */
    @Override
    public PaymentResponseDTO voidPayment(PaymentRequestDTO paymentRequestDTO) throws PaymentException {
        // TODO Auto-generated method stub
        return super.voidPayment(paymentRequestDTO);
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
