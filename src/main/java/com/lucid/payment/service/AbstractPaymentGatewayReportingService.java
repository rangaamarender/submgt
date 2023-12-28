/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.service;

import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.dto.PaymentResponseDTO;
import com.lucid.payment.exception.PaymentException;

public class AbstractPaymentGatewayReportingService implements PaymentGatewayReportingService {

    @Override
    public PaymentResponseDTO findDetailsByTransaction(PaymentRequestDTO paymentRequestDTO) throws PaymentException {
        throw new UnsupportedOperationException("Not Implemented");
    }

}
