/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.service;

import com.lucid.payment.PaymentGatewayType;

public class AbstractPaymentGatewayConfiguration implements PaymentGatewayConfiguration {

    @Override
    public boolean isPerformAuthorizeAndCapture() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public void setPerformAuthorizeAndCapture(boolean performAuthorizeAndCapture) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public int getFailureReportingThreshold() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public void setFailureReportingThreshold(int failureReportingThreshold) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public boolean handlesAuthorize() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public boolean handlesCapture() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public boolean handlesAuthorizeAndCapture() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public boolean handlesReverseAuthorize() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public boolean handlesVoid() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public boolean handlesRefund() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public boolean handlesPartialCapture() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public boolean handlesMultipleShipment() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public boolean handlesRecurringPayment() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public boolean handlesSavedCustomerPayment() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public boolean handlesMultiplePayments() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override
    public PaymentGatewayType getGatewayType() {
        throw new UnsupportedOperationException("Not Implemented");
    }
}
