/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.service;

import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.dto.PaymentResponseDTO;

public class AbstractPaymentGatewayFraudService implements PaymentGatewayFraudService {

    @Override
    public PaymentResponseDTO requestPayerAuthentication(PaymentRequestDTO paymentRequestDTO) {
        throw new UnsupportedOperationException("Not Implemented");
    }

}
