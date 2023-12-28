/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.stripe.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.javafaker.Address;
import com.github.javafaker.Company;
import com.lucid.base.test.BaseTransactionTest;
import com.lucid.payment.dto.AddressDTO;
import com.lucid.payment.dto.GatewayCustomerDTO;
import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.dto.PaymentResponseDTO;
import com.lucid.payment.exception.PaymentException;

/**
 * @author sgutti
 * @date 15-Nov-2023 3:47:07 pm
 */
public class TestStripeCustomerService extends BaseTransactionTest {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Autowired
  private StripeCustomerService stripeCustomerService;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>TestStripeCustomerService</code>
   */
  public TestStripeCustomerService() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  @Test
  public void testCreateCustomer() throws PaymentException {
    Company company = FAKER.company();
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();
    GatewayCustomerDTO customer = requestDTO.customer();
    customer.companyName(company.name());
    customer.customerId("CID-" + company.name().toLowerCase());
    customer.email(FAKER.letterify("testing??????") + "@utest.com");
    customer.phone(FAKER.phoneNumber().phoneNumber());
    //
    Address billingAddress = FAKER.address();
    AddressDTO address = requestDTO.billTo();
    address.addressLine1(billingAddress.streetAddress());
    address.addressLine2(billingAddress.buildingNumber());
    address.addressCityLocality(billingAddress.city());
    address.addressStateRegion(billingAddress.stateAbbr());
    address.addressPostalCode(billingAddress.zipCode());
    address.addressCountryCode(billingAddress.countryCode());
    //

    PaymentResponseDTO response = stripeCustomerService.createGatewayCustomer(requestDTO);
    GatewayCustomerDTO gtwyCustomer = response.getCustomer();
    System.out.println(" gtwyCustomer--->" + gtwyCustomer.getCustomerId());
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
