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
 * This API provides the ability to get the status of a Transaction after it has
 * been submitted to the Gateway. Gateways have different ways to provide this
 * information. For example, Cybersource can provide a nightly feed or FTP file
 * that contain details of what was SETTLED, CHARGEBACK, etc... to be reconciled
 * in your system. Braintree and Paypal have API hooks to either do a date based
 * query or an individual inquiry on a particular transaction.
 * </p>
 * 
 * @author sgutti
 * @date 11-Nov-2023 8:58:25 pm
 */
public interface PaymentGatewayReportingService {
    public PaymentResponseDTO findDetailsByTransaction(PaymentRequestDTO paymentRequestDTO)
            throws PaymentException;
}
