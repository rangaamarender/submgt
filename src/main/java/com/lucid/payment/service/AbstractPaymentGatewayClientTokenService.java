/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.service;

import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.dto.PaymentResponseDTO;

public class AbstractPaymentGatewayClientTokenService implements PaymentGatewayClientTokenService {

    @Override
    public PaymentResponseDTO generateClientToken(PaymentRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Not Implemented");
    }

}
