/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.data;

import java.math.BigDecimal;
import java.util.Date;
import com.lucid.core.vo.BaseVO;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:35:27 IST 2021
 */
public class SubPaymentVO extends BaseVO {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 1L;
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  private Long subPymntID;
  private Long subscriptionID;
  private BigDecimal pymntAmt;
  private Date pymntDt;
  private Integer pymntStatus;
  private Date updateDt;
  private Long pymntMethodID;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubPaymentVO</code>
   */
  public SubPaymentVO() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @return Returns the subPymntID.
   */
  public Long getSubPymntID() {
    return subPymntID;
  }

  /**
   * @param subPymntID The subPymntID to set.
   */
  public void setSubPymntID(Long subPymntID) {
    this.subPymntID = subPymntID;
  }

  /**
   * @return Returns the subscriptionID.
   */
  public Long getSubscriptionID() {
    return subscriptionID;
  }

  /**
   * @param subscriptionID The subscriptionID to set.
   */
  public void setSubscriptionID(Long subscriptionID) {
    this.subscriptionID = subscriptionID;
  }

  /**
   * @return Returns the pymntAmt.
   */
  public BigDecimal getPymntAmt() {
    return pymntAmt;
  }

  /**
   * @param pymntAmt The pymntAmt to set.
   */
  public void setPymntAmt(BigDecimal pymntAmt) {
    this.pymntAmt = pymntAmt;
  }

  /**
   * @return Returns the pymntDt.
   */
  public Date getPymntDt() {
    return pymntDt;
  }

  /**
   * @param pymntDt The pymntDt to set.
   */
  public void setPymntDt(Date pymntDt) {
    this.pymntDt = pymntDt;
  }

  /**
   * @return Returns the pymntStatus.
   */
  public Integer getPymntStatus() {
    return pymntStatus;
  }

  /**
   * @param pymntStatus The pymntStatus to set.
   */
  public void setPymntStatus(Integer pymntStatus) {
    this.pymntStatus = pymntStatus;
  }

  /**
   * @return Returns the updateDt.
   */
  public Date getUpdateDt() {
    return updateDt;
  }

  /**
   * @param updateDt The updateDt to set.
   */
  public void setUpdateDt(Date updateDt) {
    this.updateDt = updateDt;
  }

  /**
   * @return Returns the pymntMethodID.
   */
  public Long getPymntMethodID() {
    return pymntMethodID;
  }

  /**
   * @param pymntMethodID The pymntMethodID to set.
   */
  public void setPymntMethodID(Long pymntMethodID) {
    this.pymntMethodID = pymntMethodID;
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
