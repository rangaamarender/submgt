/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.service;

public class AbstractPaymentGatewayConfigurationService implements PaymentGatewayConfigurationService {

    @Override
    public PaymentGatewayConfiguration getConfiguration() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentGatewayTransactionService getTransactionService() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentGatewayTransactionConfirmationService getTransactionConfirmationService() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentGatewayReportingService getReportingService() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentGatewayCreditCardService getCreditCardService() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentGatewayCustomerService getCustomerService() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentGatewaySubscriptionService getSubscriptionService() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentGatewayFraudService getFraudService() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentGatewayHostedService getHostedService() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentGatewayRollbackService getRollbackService() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentGatewayWebResponseService getWebResponseService() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentGatewayTransparentRedirectService getTransparentRedirectService() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentGatewayClientTokenService getClientTokenService() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    // @Override
    // public TRCreditCardExtensionHandler getCreditCardExtensionHandler() {
    // throw new UnsupportedOperationException("Not Implemented");
    // }
    //
    // @Override
    // public PaymentGatewayFieldExtensionHandler getFieldExtensionHandler() {
    // throw new UnsupportedOperationException("Not Implemented");
    // }
    //
    // @Override
    // public CreditCardTypesExtensionHandler
    // getCreditCardTypesExtensionHandler() {
    // throw new UnsupportedOperationException("Not Implemented");
    // }
}
