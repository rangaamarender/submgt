/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.service;

import javax.servlet.http.HttpServletRequest;

import com.lucid.payment.dto.PaymentResponseDTO;
import com.lucid.payment.exception.PaymentException;

public class AbstractPaymentGatewayWebResponseService implements PaymentGatewayWebResponseService {

    @Override
    public PaymentResponseDTO translateWebResponse(HttpServletRequest request) throws PaymentException {
        throw new UnsupportedOperationException("Not Implemented");
    }

}
