/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.service;

import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.dto.PaymentResponseDTO;
import com.lucid.payment.exception.PaymentException;

/**
 * <p>
 * Certain Payment Integrations allow you to use a Hosted Solution, such as
 * PayPal Express and SagePay Form. This API allows you to create the call to
 * send a user to the Gateway's Hosted page and to capture and record
 * transaction responses back from them.
 * </p>
 * 
 * @author sgutti
 * @date 11-Nov-2023 8:54:27 pm
 */
public interface PaymentGatewayHostedService {
    public PaymentResponseDTO requestHostedEndpoint(PaymentRequestDTO paymentRequestDTO)
            throws PaymentException;
}
