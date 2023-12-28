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
 * This API is intended to be called by the Checkout Workflow to confirm all
 * Payments on the order that have not yet been confirmed/finalized. In the case
 * where an error is thrown by the gateway and confirming is not possible, the
 * workflow should invoke the rollback handlers on any Payments that have
 * already been successfully confirmed.
 * </p>
 * <p>
 * Not all Gateways allow confirmation. That setting can be found on the
 * PaymentGatewayConfiguration.completeCheckoutOnCallback(). If this value is
 * set to true, then the gateway does not support confirming the transaction, as
 * it assumes to be the final step in the completion process. Most Credit Card
 * integrations do not support confirming the transaction, Third Party providers
 * like PayPal Express, or the BLC Gift Card Module do and should implement this
 * interface.
 * </p>
 * 
 * @author sgutti
 * @date 11-Nov-2023 9:04:15 pm
 */
public interface PaymentGatewayTransactionConfirmationService {
    public PaymentResponseDTO confirmTransaction(PaymentRequestDTO paymentRequestDTO)
            throws PaymentException;
}
