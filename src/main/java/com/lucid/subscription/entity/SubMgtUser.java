/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription.entity;

import java.util.Date;
import com.lucid.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 23:20:29 IST 2021
 */
@Entity
@Table(name = SubMgtUser.TABLE_NAME)
public class SubMgtUser extends BaseEntity {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 1L;
  public static final String TABLE_NAME = "SUBMGT_USER";
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Id
  @Column(name = "USER_ID", nullable = false, length = 100)
  private String userID;
  @Column(name = "CREATED_BY", nullable = false, length = 100)
  private String createdBy;
  @Column(name = "CREATED_DT", nullable = false)
  private Date createdDt;
  @Column(name = "UPDATED_BY", nullable = true, length = 100)
  private String updatedBy;
  @Column(name = "UPDATED_DT", nullable = true)
  private Date updatedDt;
  @Column(name = "EMAIL_ID", nullable = false, length = 200)
  private String emailID;
  @Column(name = "EXTERNAL_CODE", nullable = true, length = 100)
  private String externalCode;
  @Column(name = "LAST_LOGIN_DT", nullable = true)
  private Date lastLoginDt;
  @Column(name = "PASSWORD", nullable = false, length = 150)
  private String password;
  @Column(name = "SALT", nullable = false, length = 15)
  private String salt;
  @Column(name = "STATUS", nullable = false)
  private Integer status;
  @Column(name = "ROLE_ID", nullable = false)
  private Long roleID;
  @Column(name = "USERNAME", nullable = false, length = 200)
  private String username;
  @Column(name = "USER_TYPE", nullable = false, length = 25)
  private String userType;
  @Column(name = "PHONE_NBR", nullable = true, length = 25)
  private String phoneNbr;
  @Lob
  @Column(name = "PHOTO", nullable = true)
  private byte[] photo;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false, insertable = false)
  private SubMgtRole subMgtRole;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubUser</code>
   */
  public SubMgtUser() {
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
  public SubMgtRole getSubMgtRole() {
    return subMgtRole;
  }

  /**
   * @param subMgtRole The subMgtRole to set.
   */
  public void setSubMgtRole(SubMgtRole subMgtRole) {
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
