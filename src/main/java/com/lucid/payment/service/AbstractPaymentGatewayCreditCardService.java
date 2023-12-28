/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.service;

import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.dto.PaymentResponseDTO;
import com.lucid.payment.exception.PaymentException;

public class AbstractPaymentGatewayCreditCardService implements PaymentGatewayCreditCardService {

    @Override
    public PaymentResponseDTO createGatewayCreditCard(PaymentRequestDTO requestDTO) throws PaymentException {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentResponseDTO updateGatewayCreditCard(PaymentRequestDTO requestDTO) throws PaymentException {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentResponseDTO deleteGatewayCreditCard(PaymentRequestDTO requestDTO) throws PaymentException {
        throw new UnsupportedOperationException("Not Implemented");
    }

    /**
     * @see com.lucid.payment.service.PaymentGatewayCreditCardService#attachGatewayCreditCard(com.lucid.payment.dto.PaymentResponseDTO)
     */
    @Override
    public PaymentResponseDTO attachGatewayCreditCard(PaymentRequestDTO requestDTO) throws PaymentException {
        throw new UnsupportedOperationException("Not Implemented");
    }

}
