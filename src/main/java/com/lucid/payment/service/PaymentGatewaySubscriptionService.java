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
 * Some gateways allow you to create a form of recurring billing by creating a
 * subscription profile. Note: Some Gateways charge an extra fee to enable this
 * feature
 * </p>
 * 
 * @author sgutti
 * @date 11-Nov-2023 8:59:00 pm
 */
public interface PaymentGatewaySubscriptionService {
    /**
     * @param requestDTO
     * @return
     * @throws PaymentException
     */
    public PaymentResponseDTO createGatewaySubscription(PaymentRequestDTO requestDTO)
            throws PaymentException;

    /**
     * @param requestDTO
     * @return
     * @throws PaymentException
     */
    public PaymentResponseDTO updateGatewaySubscription(PaymentRequestDTO requestDTO)
            throws PaymentException;

    /**
     * @param requestDTO
     * @return
     * @throws PaymentException
     */
    public PaymentResponseDTO cancelGatewaySubscription(PaymentRequestDTO requestDTO)
            throws PaymentException;
}
