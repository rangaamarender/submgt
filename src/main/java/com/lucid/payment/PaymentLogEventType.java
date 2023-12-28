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
 * An extendible enumeration of payment log types.
 * 
 * @author jfischer
 */
public class PaymentLogEventType implements Serializable, BaseEnum {
    private static final long serialVersionUID = 1L;
    private static final Map<String, PaymentLogEventType> TYPES = new LinkedHashMap<String, PaymentLogEventType>();
    public static final PaymentLogEventType START = new PaymentLogEventType(
            "START",
            "Start");
    public static final PaymentLogEventType FINISHED = new PaymentLogEventType(
            "FINISHED",
            "Finished");

    public static PaymentLogEventType getInstance(final String type) {
        return TYPES.get(type);
    }
    private String type;
    private String friendlyType;

    public PaymentLogEventType() {
        // do nothing
    }

    public PaymentLogEventType(final String type, final String friendlyType) {
        this.friendlyType = friendlyType;
        setType(type);
    }

    public String getType() {
        return type;
    }

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
        PaymentLogEventType other = (PaymentLogEventType) obj;
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        return true;
    }
}
