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
 * The purpose of this class, is to provide an API that will create any gateway
 * specific parameters needed for a Transparent Redirect/Silent Order Post
 * etc...
 * </p>
 * <p>
 * Some payment gateways provide this ability and will generate either a Secure
 * Token or some hashed parameters that will be placed as hidden fields on your
 * Credit Card form. These parameters (along with the Credit Card information)
 * will be placed on the ResponseDTO and your HTML should include these fields
 * to be POSTed directly to the implementing gateway for processing.
 * </p>
 * <p>
 * In addition, some gateways also support the creation of a payment token (i.e.
 * a tokenized version of a Credit Card that can be used on subsequent requests)
 * outside the scope of an authorize or sale transaction.
 * </p>
 * 
 * @author sgutti
 * @date 14-Nov-2023 7:28:48 pm
 */
public interface PaymentGatewayTransparentRedirectService {

    public PaymentResponseDTO createAuthorizeForm(PaymentRequestDTO requestDTO) throws PaymentException;

    public PaymentResponseDTO createAuthorizeAndCaptureForm(PaymentRequestDTO requestDTO) throws PaymentException;

    public PaymentResponseDTO createCustomerPaymentTokenForm(PaymentRequestDTO requestDTO) throws PaymentException;

    public PaymentResponseDTO updateCustomerPaymentTokenForm(PaymentRequestDTO requestDTO) throws PaymentException;

    /**
     * Return the
     * {@link org.commerce.common.payment.dto.PaymentResponseDTO#responseMap}
     * key that corresponds to creating the customer token return url
     */
    public String getCreateCustomerPaymentTokenReturnURLFieldKey(PaymentResponseDTO responseDTO);

    /**
     * Return the
     * {@link org.commerce.common.payment.dto.PaymentResponseDTO#responseMap}
     * key that corresponds to creating the customer token cancel url
     */
    public String getCreateCustomerPaymentTokenCancelURLFieldKey(PaymentResponseDTO responseDTO);

    /**
     * Return the
     * {@link org.commerce.common.payment.dto.PaymentResponseDTO#responseMap}
     * key that corresponds to updating the customer token return url
     */
    public String getUpdateCustomerPaymentTokenReturnURLFieldKey(PaymentResponseDTO responseDTO);

    /**
     * Return the
     * {@link org.commerce.common.payment.dto.PaymentResponseDTO#responseMap}
     * key that corresponds to updating the customer token cancel url
     */
    public String getUpdateCustomerPaymentTokenCancelURLFieldKey(PaymentResponseDTO responseDTO);

}
