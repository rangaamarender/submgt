/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.payment.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sgutti
 * @date 11-Nov-2023 1:56:14 pm
 * @param <T>
 */
public class GiftCardDTO<T> {
    protected T parent;
    protected Map<String, Object> additionalFields;
    protected String giftCardNum;
    protected String giftCardMasked;

    public GiftCardDTO() {
        this.additionalFields = new HashMap<String, Object>();
    }

    public GiftCardDTO(T parent) {
        this.additionalFields = new HashMap<String, Object>();
        this.parent = parent;
    }

    public T done() {
        return parent;
    }

    public GiftCardDTO<T> additionalFields(String key, Object value) {
        additionalFields.put(key, value);
        return this;
    }

    public GiftCardDTO<T> giftCardNum(String giftCardNum) {
        this.giftCardNum = giftCardNum;
        return this;
    }

    public GiftCardDTO<T> giftCardMasked(String giftCardMasked) {
        this.giftCardMasked = giftCardMasked;
        return this;
    }
}
