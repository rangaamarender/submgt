/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.service;

import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.dto.PaymentResponseDTO;
import com.lucid.payment.exception.PaymentException;

public class AbstractPaymentGatewayTransparentRedirectService implements PaymentGatewayTransparentRedirectService {

    @Override
    public PaymentResponseDTO createAuthorizeForm(PaymentRequestDTO requestDTO) throws PaymentException {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentResponseDTO createAuthorizeAndCaptureForm(PaymentRequestDTO requestDTO) throws PaymentException {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentResponseDTO createCustomerPaymentTokenForm(PaymentRequestDTO requestDTO) throws PaymentException {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentResponseDTO updateCustomerPaymentTokenForm(PaymentRequestDTO requestDTO) throws PaymentException {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public String getCreateCustomerPaymentTokenReturnURLFieldKey(PaymentResponseDTO responseDTO) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public String getCreateCustomerPaymentTokenCancelURLFieldKey(PaymentResponseDTO responseDTO) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public String getUpdateCustomerPaymentTokenReturnURLFieldKey(PaymentResponseDTO responseDTO) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public String getUpdateCustomerPaymentTokenCancelURLFieldKey(PaymentResponseDTO responseDTO) {
        throw new UnsupportedOperationException("Not Implemented");
    }

}
