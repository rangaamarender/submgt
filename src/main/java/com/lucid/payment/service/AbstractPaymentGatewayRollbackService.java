/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.service;

import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.dto.PaymentResponseDTO;
import com.lucid.payment.exception.PaymentException;

public class AbstractPaymentGatewayRollbackService implements PaymentGatewayRollbackService {

    @Override
    public PaymentResponseDTO rollbackAuthorize(PaymentRequestDTO transactionToBeRolledBack) throws PaymentException {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentResponseDTO rollbackCapture(PaymentRequestDTO transactionToBeRolledBack) throws PaymentException {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentResponseDTO rollbackAuthorizeAndCapture(PaymentRequestDTO transactionToBeRolledBack)
            throws PaymentException {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentResponseDTO rollbackRefund(PaymentRequestDTO transactionToBeRolledBack) throws PaymentException {
        throw new UnsupportedOperationException("Not Implemented");
    }

}
