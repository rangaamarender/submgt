/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.service;

import com.lucid.payment.dto.PaymentRequestDTO;
import com.lucid.payment.dto.PaymentResponseDTO;

/**
 * <p>
 * The intention of this API is to generate the necessary parameters and fields
 * needed by the payment gateway's JavaScript library in order to create a
 * tokenization request. These parameters will be placed on the ResponseDTO for
 * consumption by a client application or template.
 * </p>
 * 
 * @author sgutti
 * @date 13-Nov-2023 7:01:25 am
 */
public interface PaymentGatewayClientTokenService {

    public PaymentResponseDTO generateClientToken(PaymentRequestDTO requestDTO);

}
