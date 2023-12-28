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
 * This API allows each module to provide its own implementation for rollback.
 * Each module needs to implement this if for some reason the checkout workflow
 * fails after payments have been finalized and the submitted transaction needs
 * to rollback.
 * </p>
 * 
 * @author sgutti
 * @date 11-Nov-2023 8:58:40 pm
 */
public interface PaymentGatewayRollbackService {
    public PaymentResponseDTO rollbackAuthorize(PaymentRequestDTO transactionToBeRolledBack)
            throws PaymentException;

    public PaymentResponseDTO rollbackCapture(PaymentRequestDTO transactionToBeRolledBack)
            throws PaymentException;

    public PaymentResponseDTO rollbackAuthorizeAndCapture(PaymentRequestDTO transactionToBeRolledBack)
            throws PaymentException;

    public PaymentResponseDTO rollbackRefund(PaymentRequestDTO transactionToBeRolledBack)
            throws PaymentException;
}
