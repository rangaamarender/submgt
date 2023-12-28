/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.payment.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sgutti
 * @date 11-Nov-2023 1:56:06 pm
 * @param <T>
 */
public class CustomerCreditDTO<T> {
  protected T parent;
  protected Map<String, Object> additionalFields;
  protected String customerCreditAccountNum;
  protected String customerCreditAccountMasked;
  private String paymentID;

  public CustomerCreditDTO() {
    this.additionalFields = new HashMap<String, Object>();
  }

  public CustomerCreditDTO(T parent) {
    this.additionalFields = new HashMap<String, Object>();
    this.parent = parent;
  }

  public T done() {
    return parent;
  }

  public CustomerCreditDTO<T> additionalFields(String key, Object value) {
    additionalFields.put(key, value);
    return this;
  }

  public CustomerCreditDTO<T> customerCreditAccountNum(String customerCreditAccountNum) {
    this.customerCreditAccountNum = customerCreditAccountNum;
    return this;
  }

  public CustomerCreditDTO<T> customerCreditAccountMasked(String customerCreditAccountMasked) {
    this.customerCreditAccountMasked = customerCreditAccountMasked;
    return this;
  }

  /**
   * @return Returns the paymentID.
   */
  public String getPaymentID() {
    return paymentID;
  }

  /**
   * @param paymentID The paymentID to set.
   */
  public void setPaymentID(String paymentID) {
    this.paymentID = paymentID;
  }

}
