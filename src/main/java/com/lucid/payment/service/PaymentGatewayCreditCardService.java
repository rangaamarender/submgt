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
 * Several payment gateways allow you to manage Customer and Credit Card
 * Information from the gateway allowing you to create a transaction from the
 * tokenized customer or payment method at a later date. Note: These are usually
 * extra features you need to pay for when you sign up with the Gateway
 * </p>
 * 
 * @author sgutti
 * @date 11-Nov-2023 8:53:12 pm
 */
public interface PaymentGatewayCreditCardService {
    public PaymentResponseDTO createGatewayCreditCard(PaymentRequestDTO requestDTO)
            throws PaymentException;

    public PaymentResponseDTO updateGatewayCreditCard(PaymentRequestDTO requestDTO)
            throws PaymentException;

    public PaymentResponseDTO deleteGatewayCreditCard(PaymentRequestDTO requestDTO)
            throws PaymentException;

    /**
     * @param requestDTO
     * @return
     * @throws PaymentException
     */
    public PaymentResponseDTO attachGatewayCreditCard(PaymentRequestDTO requestDTO) throws PaymentException;
}
