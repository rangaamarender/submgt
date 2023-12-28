/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.stripe.payment;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.lucid.payment.PaymentType;
import com.lucid.payment.dto.CreditCardDTO;
import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.dto.PaymentResponseDTO;
import com.lucid.payment.exception.PaymentException;
import com.lucid.payment.service.AbstractPaymentGatewayCreditCardService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentMethod;
import com.stripe.net.StripeResponse;

/**
 * @author sgutti
 * @date 15-Nov-2023 4:58:14 pm
 */
@Component(StripeCreditCardService.SERVICE_NAME)
public class StripeCreditCardService extends AbstractPaymentGatewayCreditCardService {
  // --------------------------------------------------------------- Constants
  public static final String SERVICE_NAME = "stripeCreditCard";
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Autowired
  private StripeConfiguration configuration;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>StripeCreditCardService</code>
   */
  public StripeCreditCardService() {
    super();
  }
  // ---------------------------------------------------------- Public Methods

  /**
   * @see com.lucid.payment.service.AbstractPaymentGatewayCreditCardService#createGatewayCreditCard(com.lucid.payment.dto.PaymentRequestDTO)
   */
  @Override
  public PaymentResponseDTO createGatewayCreditCard(PaymentRequestDTO requestDTO)
      throws PaymentException {
    PaymentType requestPaymentType =
        requestDTO.getPaymentType() == null ? PaymentType.CREDIT_CARD : requestDTO.getPaymentType();
    PaymentResponseDTO paymentResponse =
        new PaymentResponseDTO(requestPaymentType, StripeGatewayType.STRIPE);
    Stripe.apiKey = configuration.getApiKey();
    try {
      Map<String, Object> params = new HashMap<>();
      //
      CreditCardDTO creditCard = requestDTO.getCreditCard();
      Map<String, Object> card = new HashMap<>();
      card.put("number", creditCard.getCreditCardNum());
      card.put("exp_month", creditCard.getCreditCardExpMonth());
      card.put("exp_year", creditCard.getCreditCardExpYear());
      card.put("cvc", creditCard.getCreditCardCvv());
      // adding
      params.put("type", "card");
      params.put("card", card);
      PaymentMethod stripePymntMethod = PaymentMethod.create(params);
      //
      StripeResponse stripeResponse = stripePymntMethod.getLastResponse();
      System.out.println(
          "Stripe Reponse :" + stripeResponse.code() + "--- id---" + stripePymntMethod.getId());
      System.out.println("json ---" + stripeResponse.body());
      if (stripeResponse.code() == HttpStatus.OK.value()) {
        paymentResponse.successful(true);
        paymentResponse.rawResponse(stripeResponse.body());
        CreditCardDTO customerCreditDTO = paymentResponse.creditCard();
        customerCreditDTO.creditCardLastFour(stripePymntMethod.getCard().getLast4());
        customerCreditDTO.setPaymentID(stripePymntMethod.getId());
      }
    } catch (StripeException e) {
      throw new PaymentException(e.getCode(), e.getMessage(), e);
    }
    return paymentResponse;
  }

  /**
   * @see com.lucid.payment.service.AbstractPaymentGatewayCreditCardService#updateGatewayCreditCard(com.lucid.payment.dto.PaymentRequestDTO)
   */
  @Override
  public PaymentResponseDTO updateGatewayCreditCard(PaymentRequestDTO requestDTO)
      throws PaymentException {
    // TODO Auto-generated method stub
    return super.updateGatewayCreditCard(requestDTO);
  }

  /**
   * @see com.lucid.payment.service.AbstractPaymentGatewayCreditCardService#deleteGatewayCreditCard(com.lucid.payment.dto.PaymentRequestDTO)
   */
  @Override
  public PaymentResponseDTO deleteGatewayCreditCard(PaymentRequestDTO requestDTO)
      throws PaymentException {
    // TODO Auto-generated method stub
    return super.deleteGatewayCreditCard(requestDTO);
  }

  /**
   * @see com.lucid.payment.service.AbstractPaymentGatewayCreditCardService#attachGatewayCreditCard(com.lucid.payment.dto.PaymentResponseDTO)
   */
  @Override
  public PaymentResponseDTO attachGatewayCreditCard(PaymentRequestDTO requestDTO)
      throws PaymentException {
    PaymentType requestPaymentType =
        requestDTO.getPaymentType() == null ? PaymentType.CREDIT_CARD : requestDTO.getPaymentType();
    PaymentResponseDTO paymentResponse =
        new PaymentResponseDTO(requestPaymentType, StripeGatewayType.STRIPE);
    Stripe.apiKey = configuration.getApiKey();
    try {
      PaymentMethod stripeUpdatePymntMethod =
          PaymentMethod.retrieve(requestDTO.getGtwyPymntMethodID());
      Map<String, Object> params = new HashMap<>();
      params.put("customer", requestDTO.getGtwyCustomerID());

      PaymentMethod updatedPaymentMethod = stripeUpdatePymntMethod.attach(params);
      //
      StripeResponse stripeResponse = updatedPaymentMethod.getLastResponse();
      System.out.println(
          "Stripe Reponse :" + stripeResponse.code() + "--- id---" + updatedPaymentMethod.getId());

    } catch (StripeException e) {
      throw new PaymentException(e.getCode(), e.getMessage(), e);
    }
    return paymentResponse;
  }

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
