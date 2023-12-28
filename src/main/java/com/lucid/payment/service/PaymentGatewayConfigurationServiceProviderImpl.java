/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lucid.payment.PaymentGatewayType;

/**
 * @author sgutti
 * @date 11-Nov-2023 8:50:51 pm
 */
@Service("blPaymentGatewayConfigurationServiceProvider")
public class PaymentGatewayConfigurationServiceProviderImpl implements
        PaymentGatewayConfigurationServiceProvider {
    @Resource(name = "blPaymentGatewayConfigurationServices")
    protected List<PaymentGatewayConfigurationService> gatewayConfigurationServices;

    @Override
    public PaymentGatewayConfigurationService getGatewayConfigurationService(PaymentGatewayType gatewayType) {
        if (gatewayType == null) {
            throw new IllegalArgumentException("Gateway type cannot be null");
        }
        for (PaymentGatewayConfigurationService config : getGatewayConfigurationServices()) {
            if (config.getConfiguration().getGatewayType().equals(gatewayType)) {
                return config;
            }
        }
        throw new IllegalArgumentException(
                "There is no gateway configured for "
                        + gatewayType.getFriendlyType());
    }

    public List<PaymentGatewayConfigurationService> getGatewayConfigurationServices() {
        return gatewayConfigurationServices;
    }

    public void setGatewayConfigurationServices(List<PaymentGatewayConfigurationService> gatewayConfigurationServices) {
        this.gatewayConfigurationServices = gatewayConfigurationServices;
    }
}
