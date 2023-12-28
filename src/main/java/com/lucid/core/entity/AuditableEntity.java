/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.core.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * @author sgutti
 * @date Sep 21, 2019 11:38:49 PM
 *
 */
@MappedSuperclass
public abstract class AuditableEntity extends BaseEntity {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = -2201318002468126886L;
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Column(name = "CREATED_DT", nullable = false)
  private Date createdDt;
  @Column(name = "CREATED_BY", nullable = false, length = 100)
  private String createdBy;
  @Column(name = "UPDATED_DT", nullable = true)
  private Date updatedDt;
  @Column(name = "UPDATED_BY", nullable = true, length = 100)
  private String updatedBy;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>AuditableEntity</code>
   */
  public AuditableEntity() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
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
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
