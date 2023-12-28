/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription.data;

import java.util.Date;
import com.lucid.core.constants.EnumStatus;
import com.lucid.core.vo.BaseVO;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 23:20:29 IST 2021
 */
public class SubMgtUserVO extends BaseVO {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 1L;
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  private String userID;
  private String createdBy;
  private Date createdDt;
  private String updatedBy;
  private Date updatedDt;
  private String emailID;
  private String externalCode;
  private Date lastLoginDt;
  private String password;
  private String salt;
  private Integer status;
  private Long roleID;
  private String username;
  private String userType;
  private SubMgtRoleVO subMgtRole;
  private String phoneNbr;
  private byte[] photo;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubUserVO</code>
   */
  public SubMgtUserVO() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @return Returns the userID.
   */
  public String getUserID() {
    return userID;
  }

  /**
   * @param userID The userID to set.
   */
  public void setUserID(String userID) {
    this.userID = userID;
  }

  /**
   * @return Returns the createdBy.
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * @param createdBy The createdBy to set.
   */
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * @return Returns the createdDt.
   */
  public Date getCreatedDt() {
    return createdDt;
  }

  /**
   * @param createdDt The createdDt to set.
   */
  public void setCreatedDt(Date createdDt) {
    this.createdDt = createdDt;
  }

  /**
   * @return Returns the updatedBy.
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * @param updatedBy The updatedBy to set.
   */
  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  /**
   * @return Returns the updatedDt.
   */
  public Date getUpdatedDt() {
    return updatedDt;
  }

  /**
   * @param updatedDt The updatedDt to set.
   */
  public void setUpdatedDt(Date updatedDt) {
    this.updatedDt = updatedDt;
  }

  /**
   * @return Returns the emailID.
   */
  public String getEmailID() {
    return emailID;
  }

  /**
   * @param emailID The emailID to set.
   */
  public void setEmailID(String emailID) {
    this.emailID = emailID;
  }

  /**
   * @return Returns the externalCode.
   */
  public String getExternalCode() {
    return externalCode;
  }

  /**
   * @param externalCode The externalCode to set.
   */
  public void setExternalCode(String externalCode) {
    this.externalCode = externalCode;
  }

  /**
   * @return Returns the lastLoginDt.
   */
  public Date getLastLoginDt() {
    return lastLoginDt;
  }

  /**
   * @param lastLoginDt The lastLoginDt to set.
   */
  public void setLastLoginDt(Date lastLoginDt) {
    this.lastLoginDt = lastLoginDt;
  }

  /**
   * @return Returns the password.
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password The password to set.
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return Returns the salt.
   */
  public String getSalt() {
    return salt;
  }

  /**
   * @param salt The salt to set.
   */
  public void setSalt(String salt) {
    this.salt = salt;
  }

  /**
   * @return Returns the status.
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * @param status The status to set.
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * @return
   */
  public String getStatusStr() {
    return EnumStatus.toString(status);
  }

  /**
   * @return Returns the roleID.
   */
  public Long getRoleID() {
    return roleID;
  }

  /**
   * @param roleID The roleID to set.
   */
  public void setRoleID(Long roleID) {
    this.roleID = roleID;
  }

  /**
   * @return Returns the username.
   */
  public String getUsername() {
    return username;
  }

  /**
   * @param username The username to set.
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * @return Returns the userType.
   */
  public String getUserType() {
    return userType;
  }

  /**
   * @param userType The userType to set.
   */
  public void setUserType(String userType) {
    this.userType = userType;
  }

  /**
   * @return Returns the subMgtRole.
   */
  public SubMgtRoleVO getSubMgtRole() {
    return subMgtRole;
  }

  /**
   * @param subMgtRole The subMgtRole to set.
   */
  public void setSubMgtRole(SubMgtRoleVO subMgtRole) {
    this.subMgtRole = subMgtRole;
  }

  /**
   * @return Returns the phoneNbr.
   */
  public String getPhoneNbr() {
    return phoneNbr;
  }

  /**
   * @param phoneNbr The phoneNbr to set.
   */
  public void setPhoneNbr(String phoneNbr) {
    this.phoneNbr = phoneNbr;
  }

  /**
   * @return Returns the photo.
   */
  public byte[] getPhoto() {
    return photo;
  }

  /**
   * @param photo The photo to set.
   */
  public void setPhoto(byte[] photo) {
    this.photo = photo;
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
