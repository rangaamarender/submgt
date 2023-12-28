/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.lucid.tenant.entity.Tenant;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 18:21:24 IST 2021
 */
public interface TenantDAO extends JpaRepository<Tenant, Long> {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  // ---------------------------------------------------------- Public Methods
  /**
   * @param tenantID
   * @return
   */
  Tenant findByTenantID(Long tenantID);

  /**
   * @param externalCode
   * @return
   */
  @Query(" from Tenant t where t.externalCode=?1")
  Tenant findByExternalCode(String externalCode);

  @Query("SELECT t.tenantID FROM Tenant t WHERE t.status=:status")
  List<Long> findAllTenantsIdsByStatus(@Param("status") Integer status);

  @Query("FROM Tenant t WHERE t.status=1 ORDER BY t.createdDt DESC LIMIT 5")
  List<Tenant> fetchRecent5Tenants();


  @Query("SELECT COUNT(tn) FROM Tenant tn WHERE tn.status =:status AND tn.createdDt>=:startDate AND tn.createdDt<=:endDate")
  long getActiveTenantsCount(@Param("startDate")Date startDate, @Param("endDate")Date endDate,@Param("status") Integer status);

  @Modifying
  @Transactional
  @Query("UPDATE Tenant tnt SET tnt.status =:status WHERE tnt.tenantID =:tenantID")
  int updateStatus(@Param("tenantID") Long tenantID, @Param("status")Integer status);

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
