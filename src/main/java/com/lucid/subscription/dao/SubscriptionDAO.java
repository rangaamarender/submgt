/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription.dao;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.lucid.subscription.entity.Subscription;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:26:33 IST 2021
 */
public interface SubscriptionDAO extends JpaRepository<Subscription, Long> {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  // ---------------------------------------------------------- Public Methods
  // /**
  // * @param tenantID
  // * @return
  // */
  // @Query(" from Subscription s where s.tenantID=?1")
  // Subscription findByTenantID(Long tenantID);
  //
  /**
   * @param status
   * @param startDate
   * @param endDate
   * @return
   */
  @Query("SELECT COUNT(sb) FROM Subscription sb WHERE sb.status =:status AND sb.endDt>=:startDate AND sb.endDt<=:endDate")
  long getSubscriptionExpiringCount(@Param("status") Integer status,
      @Param("startDate") Date startDate, @Param("endDate") Date endDate);

  // // ------------------------------------------------------- Protected Methods
  //
  @Modifying
  @Transactional
  @Query("UPDATE Subscription su SET su.status = :status WHERE su.subscriptionID = :subscriptionID")
  int updateStatus(@Param("subscriptionID") Long subscriptionID, @Param("status") Integer status);



  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
