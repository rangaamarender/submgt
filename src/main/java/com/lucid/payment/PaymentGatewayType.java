/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.lucid.core.BaseEnum;

/**
 * <p>
 * This is designed such that individual payment modules will extend this to add
 * their own type. For instance, while this class does not explicitly have a
 * 'Braintree' payment gateway type, the Braintree module will provide an
 * extension to this class and add itself in the list of types. For instance:
 * </p>
 *
 * <pre>
 * {@code
 * public class BraintreeGatewayType extends PaymentGatewayType {
 *     public static final BRAINTREE = new PaymentGatewayType("BRAINTREE", "Braintree");
 * }
 * </pre>
 *
 * And then in your application context:
 *
 * <pre>
 * {@code
 * <bean class="org.commerce.vendor.braintree.BraintreeGatewayType" />
 * }
 * </pre>
 * <p>
 * This is especially useful in auditing scenarios so that, at a glance, you can
 * easily see what gateway a particular order payment was processed by.
 * </p>
 
 * @author sgutti
 * @date 11-Nov-2023 9:07:43 pm
 *
 */
public class PaymentGatewayType implements Serializable, BaseEnum {
    private static final long                            serialVersionUID = 1L;
    private static final Map<String, PaymentGatewayType> TYPES            = new LinkedHashMap<String, PaymentGatewayType>();
    public static final PaymentGatewayType               TEMPORARY        = new PaymentGatewayType(
                                                                                  "Temporary",
                                                                                  "This is a temporary Order Payment");
    public static final PaymentGatewayType               PASSTHROUGH      = new PaymentGatewayType(
                                                                                  "Passthrough",
                                                                                  "Passthrough Payment");

    public static PaymentGatewayType getInstance(final String type) {
        return TYPES.get(type);
    }
    private String type;
    private String friendlyType;

    public PaymentGatewayType() {
        // do nothing
    }

    public PaymentGatewayType(final String type, final String friendlyType) {
        this.friendlyType = friendlyType;
        setType(type);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getFriendlyType() {
        return friendlyType;
    }

    private void setType(final String type) {
        this.type = type;
        if (!TYPES.containsKey(type)) {
            TYPES.put(type, this);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PaymentGatewayType other = (PaymentGatewayType) obj;
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        }
        else if (!type.equals(other.type)) {
            return false;
        }
        return true;
    }
}
