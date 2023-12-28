/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.stripe.payment;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.lucid.payment.PaymentType;
import com.lucid.payment.dto.AddressDTO;
import com.lucid.payment.dto.GatewayCustomerDTO;
import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.dto.PaymentResponseDTO;
import com.lucid.payment.exception.PaymentException;
import com.lucid.payment.service.AbstractPaymentGatewayCustomerService;
import com.lucid.payment.service.PaymentGatewayCustomerService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.net.StripeResponse;

/**
 * @author sgutti
 * @date 14-Nov-2023 8:03:04 pm
 */
@Component(StripeCustomerService.SERVICE_NAME)
public class StripeCustomerService extends AbstractPaymentGatewayCustomerService
    implements PaymentGatewayCustomerService {
  // --------------------------------------------------------------- Constants
  public static final String SERVICE_NAME = "stripeCustomer";
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Autowired
  private StripeConfiguration configuration;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>StripeCustomerService</code>
   */
  public StripeCustomerService() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @see com.lucid.payment.service.AbstractPaymentGatewayCustomerService#createGatewayCustomer(com.lucid.payment.dto.PaymentRequestDTO)
   */
  @Override
  public PaymentResponseDTO createGatewayCustomer(PaymentRequestDTO requestDTO)
      throws PaymentException {

    PaymentType requestPaymentType =
        requestDTO.getPaymentType() == null ? PaymentType.CREDIT_CARD : requestDTO.getPaymentType();
    PaymentResponseDTO paymentResponse =
        new PaymentResponseDTO(requestPaymentType, StripeGatewayType.STRIPE);

    Stripe.apiKey = configuration.getApiKey();
    try {
      //
      Map<String, Object> params = new HashMap<>();
      // Customer Billing address
      AddressDTO billing = requestDTO.getBillTo();
      if (billing != null && billing.addressPopulated()) {
        // Address billingAddress = new Address();
        Map<String, Object> billingAddress = new HashMap<>();
        billingAddress.put("line1", billing.getAddressLine1());
        billingAddress.put("line2", billing.getAddressLine2());
        billingAddress.put("city", billing.getAddressCityLocality());
        billingAddress.put("state", billing.getAddressStateRegion());
        billingAddress.put("country", billing.getAddressCountryCode());
        billingAddress.put("postal_code", billing.getAddressPostalCode());
        params.put("address", billingAddress);
      }
      // Customer ShippingAddress
      AddressDTO shipping = requestDTO.getShipTo();
      if (shipping != null && shipping.addressPopulated()) {
        Map<String, Object> shippingAddress = new HashMap<>();
        shippingAddress.put("line1", shipping.getAddressLine1());
        shippingAddress.put("line2", shipping.getAddressLine2());
        shippingAddress.put("city", shipping.getAddressCityLocality());
        shippingAddress.put("state", shipping.getAddressStateRegion());
        shippingAddress.put("country", shipping.getAddressCountryCode());
        shippingAddress.put("postal_code", shipping.getAddressPostalCode());
        params.put("shipping", shippingAddress);
      }
      // Customer
      GatewayCustomerDTO customer = requestDTO.getCustomer();
      String email = requestDTO.getCustomer().getEmail();

      //

      params.put("email", email);
      String name = customer.getCompanyName();
      if (StringUtils.isBlank(name)) {
        name = customer.getLastName() + " " + customer.getFirstName();
      }
      params.put("name", name);
      //
      params.put("description", name + " " + customer.getCustomerId());
      params.put("phone", customer.getPhone());

      // Create Customer Profile
      Customer stripeCustomer = Customer.create(params);

      StripeResponse stripeResponse = stripeCustomer.getLastResponse();
      System.out.println("Stripe Reponse :" + stripeResponse.code());
      //
      if (stripeResponse.code() == HttpStatus.OK.value()) {
        paymentResponse.successful(true);
        GatewayCustomerDTO gtwyCustomer = paymentResponse.customer();
        gtwyCustomer.customerId(stripeCustomer.getId());
      }
    } catch (StripeException e) {
      throw new PaymentException(e.getCode(), e.getMessage(), e);
    }

    return paymentResponse;
  }

  /**
   * @see com.lucid.payment.service.AbstractPaymentGatewayCustomerService#updateGatewayCustomer(com.lucid.payment.dto.PaymentRequestDTO)
   */
  @Override
  public PaymentResponseDTO updateGatewayCustomer(PaymentRequestDTO requestDTO)
      throws PaymentException {
    // payment method id- pm_1OChaDSFjPlsQ2rQXFm9M4A9

    return super.updateGatewayCustomer(requestDTO);
  }

  /**
   * @see com.lucid.payment.service.AbstractPaymentGatewayCustomerService#deleteGatewayCustomer(com.lucid.payment.dto.PaymentRequestDTO)
   */
  @Override
  public PaymentResponseDTO deleteGatewayCustomer(PaymentRequestDTO requestDTO)
      throws PaymentException {
    // TODO Auto-generated method stub
    return super.deleteGatewayCustomer(requestDTO);
  }

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
