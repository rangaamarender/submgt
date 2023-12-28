/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.stripe.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.lucid.base.test.BaseTransactionTest;
import com.lucid.payment.dto.CreditCardDTO;
import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.exception.PaymentException;

/**
 * @author sgutti
 * @date 15-Nov-2023 5:11:13 pm
 */
public class TestStripeCreditCardService extends BaseTransactionTest {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Autowired
  private StripeCreditCardService stripeCreditCardService;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>TestStripeCreditCardService</code>
   */
  public TestStripeCreditCardService() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  // @Test
  public void testCreatePaymentMethod() throws PaymentException {
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();
    CreditCardDTO creditCardDTO = requestDTO.creditCard();
    creditCardDTO.creditCardNum("4242424242424242");
    creditCardDTO.creditCardCvv("123");
    creditCardDTO.creditCardExpMonth("12");
    creditCardDTO.creditCardExpYear("2034");
    creditCardDTO.creditCardType("visa");
    // requestDTO.gtwyCustomerID("cus_P3hiCb8evIH5Ah");
    // Address billingAddress = FAKER.address();
    // AddressDTO address = requestDTO.billTo();
    // address.addressLine1(billingAddress.streetAddress());
    // address.addressLine2(billingAddress.buildingNumber());
    // address.addressCityLocality(billingAddress.city());
    // address.addressStateRegion(billingAddress.stateAbbr());
    // address.addressPostalCode(billingAddress.zipCode());
    // address.addressCountryCode(billingAddress.countryCode());
    stripeCreditCardService.createGatewayCreditCard(requestDTO);
  }

  @Test
  public void testAttachGatewayCreditCard() throws PaymentException {
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();
    requestDTO.gtwyPymntMethodID("pm_1OFaLCSFjPlsQ2rQZAFy9tRb");
    requestDTO.gtwyCustomerID("cus_P3hiCb8evIH5Ah");
    stripeCreditCardService.attachGatewayCreditCard(requestDTO);
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
