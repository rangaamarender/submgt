/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */

package com.lucid.payment.service;

import com.lucid.core.ServiceStatusType;

/**
 * This interface is a lightweight replacement of gateway-specific classes
 * extending AbstractExternalPaymentGatewayCall, and it helps expose some f the
 * QoS inner methods, for testing purposes. Notice that getServiceStatus() is
 * overlaps a definition in ServiceStatusDetectable
 * 
 * @author gdiaz
 */
public interface FailureCountExposable {

    public void clearStatus();

    public void incrementFailure();

    ServiceStatusType getServiceStatus();

    Integer getFailureReportingThreshold();

}
