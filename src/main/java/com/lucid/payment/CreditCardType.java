/*
 * #%L Commerce Common Libraries %% Copyright (C) 2009 - 2013 
 * Commerce %% Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License. #L%
 */
package com.lucid.payment;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.lucid.core.BaseEnum;

/**
 * An extendible enumeration of credit card types.
 * 
 * @author jfischer
 */
public class CreditCardType implements Serializable, BaseEnum {
    private static final long serialVersionUID = 1L;
    private static final Map<String, CreditCardType> TYPES = new LinkedHashMap<String, CreditCardType>();
    public static final CreditCardType MASTERCARD = new CreditCardType(
            "MASTERCARD",
            "Master Card");
    public static final CreditCardType VISA = new CreditCardType(
            "VISA",
            "Visa");
    public static final CreditCardType AMEX = new CreditCardType(
            "AMEX",
            "American Express");
    public static final CreditCardType DINERSCLUB_CARTEBLANCHE = new CreditCardType(
            "DINERSCLUB_CARTEBLANCHE",
            "Diner's Club / Carte Blanche");
    public static final CreditCardType DISCOVER = new CreditCardType(
            "DISCOVER",
            "Discover");
    public static final CreditCardType ENROUTE = new CreditCardType(
            "ENROUTE",
            "En Route");
    public static final CreditCardType JCB = new CreditCardType(
            "JCB",
            "JCB");

    public static CreditCardType getInstance(final String type) {
        return TYPES.get(type);
    }
    private String type;
    private String friendlyType;

    public CreditCardType() {
        // do nothing
    }

    public CreditCardType(final String type, final String friendlyType) {
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
        CreditCardType other = (CreditCardType) obj;
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
