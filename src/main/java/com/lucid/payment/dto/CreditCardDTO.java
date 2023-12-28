/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.payment.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sgutti
 * @date 11-Nov-2023 1:13:51 pm
 * @param <T>
 */
public class CreditCardDTO<T> {
  protected T parent;
  protected Map<String, Object> additionalFields;
  protected String creditCardHolderName;
  protected String creditCardType;
  protected String creditCardNum;
  protected String creditCardLastFour;
  protected String creditCardExpDate;
  protected String creditCardExpMonth;
  protected String creditCardExpYear;
  protected String creditCardCvv;
  //
  protected String name;

  protected String paymentID;

  public CreditCardDTO() {
    this.additionalFields = new HashMap<String, Object>();
  }

  public CreditCardDTO(T parent) {
    this.additionalFields = new HashMap<String, Object>();
    this.parent = parent;
  }

  public T done() {
    return parent;
  }

  public CreditCardDTO<T> additionalFields(String key, Object value) {
    additionalFields.put(key, value);
    return this;
  }

  public CreditCardDTO<T> creditCardHolderName(String creditCardHolderName) {
    this.creditCardHolderName = creditCardHolderName;
    return this;
  }

  public CreditCardDTO<T> creditCardType(String creditCardType) {
    this.creditCardType = creditCardType;
    return this;
  }

  public CreditCardDTO<T> creditCardNum(String creditCardNum) {
    this.creditCardNum = creditCardNum;
    return this;
  }

  public CreditCardDTO<T> creditCardLastFour(String creditCardLastFour) {
    this.creditCardLastFour = creditCardLastFour;
    return this;
  }

  public CreditCardDTO<T> creditCardExpDate(String creditCardExpDate) {
    this.creditCardExpDate = creditCardExpDate;
    return this;
  }

  public CreditCardDTO<T> creditCardExpMonth(String creditCardExpMonth) {
    this.creditCardExpMonth = creditCardExpMonth;
    return this;
  }

  public CreditCardDTO<T> creditCardExpYear(String creditCardExpYear) {
    this.creditCardExpYear = creditCardExpYear;
    return this;
  }

  public CreditCardDTO<T> creditCardCvv(String creditCardCvv) {
    this.creditCardCvv = creditCardCvv;
    return this;
  }

  public Map<String, Object> getAdditionalFields() {
    return additionalFields;
  }

  public String getCreditCardHolderName() {
    return creditCardHolderName;
  }

  public String getCreditCardType() {
    return creditCardType;
  }

  public String getCreditCardNum() {
    return creditCardNum;
  }

  public String getCreditCardLastFour() {
    return creditCardLastFour;
  }

  public String getCreditCardExpDate() {
    return creditCardExpDate;
  }

  public String getCreditCardExpMonth() {
    return creditCardExpMonth;
  }

  public String getCreditCardExpYear() {
    return creditCardExpYear;
  }

  public String getCreditCardCvv() {
    return creditCardCvv;
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

  /**
   * @return Returns the name.
   */
  public String getName() {
    return name;
  }

  /**
   * @param name The name to set.
   */
  public void setName(String name) {
    this.name = name;
  }

  public boolean creditCardPopulated() {
    return ((getAdditionalFields() != null && !getAdditionalFields().isEmpty())
        || getCreditCardHolderName() != null || getCreditCardType() != null
        || getCreditCardNum() != null || getCreditCardLastFour() != null
        || getCreditCardExpDate() != null || getCreditCardExpMonth() != null
        || getCreditCardExpYear() != null || getCreditCardCvv() != null);
  }
}
