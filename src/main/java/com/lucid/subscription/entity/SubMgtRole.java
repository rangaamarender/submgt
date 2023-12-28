/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.entity;

import java.util.Date;
import com.lucid.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 23:20:44 IST 2021
 */
@Entity
@Table(name = SubMgtRole.TABLE_NAME)
public class SubMgtRole extends BaseEntity {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = 1L;
  public static final String TABLE_NAME = "SUBMGT_ROLE";
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ROLE_ID", nullable = false)
  private Long roleID;
  @Column(name = "CREATED_BY", nullable = false, length = 100)
  private String createdBy;
  @Column(name = "CREATED_DT", nullable = false)
  private Date createdDt;
  @Column(name = "UPDATED_BY", nullable = true, length = 100)
  private String updatedBy;
  @Column(name = "UPDATED_DT", nullable = true)
  private Date updatedDt;
  @Column(name = "EXTERNAL_CODE", nullable = true, length = 100)
  private String externalCode;
  @Column(name = "ROLE_DESC", nullable = true, length = 400)
  private String roleDesc;
  @Column(name = "ROLE_CODE", nullable = false, length = 25)
  private String roleCode;
  @Column(name = "ROLE_NAME", nullable = false, length = 100)
  private String roleName;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubRole</code>
   */
  public SubMgtRole() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
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
   * @return Returns the roleDesc.
   */
  public String getRoleDesc() {
    return roleDesc;
  }

  /**
   * @param roleDesc The roleDesc to set.
   */
  public void setRoleDesc(String roleDesc) {
    this.roleDesc = roleDesc;
  }

  /**
   * @return Returns the roleCode.
   */
  public String getRoleCode() {
    return roleCode;
  }

  /**
   * @param roleCode The roleCode to set.
   */
  public void setRoleCode(String roleCode) {
    this.roleCode = roleCode;
  }

  /**
   * @return Returns the roleName.
   */
  public String getRoleName() {
    return roleName;
  }

  /**
   * @param roleName The roleName to set.
   */
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
