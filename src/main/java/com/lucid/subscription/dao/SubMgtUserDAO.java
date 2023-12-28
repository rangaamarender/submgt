/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.lucid.subscription.entity.SubMgtUser;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 23:20:29 IST 2021
 */
public interface SubMgtUserDAO extends JpaRepository<SubMgtUser, String> {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  // ---------------------------------------------------------- Public Methods

  /**
   * @param username
   * @return
   */
  SubMgtUser findByUserID(String userID);

  /**
   * @return
   */
  @Query(" from SubMgtUser a where a.status=?1")
  List<SubMgtUser> findAllByStatus(Integer status);


  @Modifying
  @Transactional
  @Query("UPDATE SubMgtUser smu SET smu.status =:status WHERE smu.userID = :userID")
  long updateStatus(@Param("userID") Long userID, @Param("status") int status);

  @Modifying
  @Transactional
  @Query("UPDATE SubMgtUser smu SET smu.roleID = :roleID WHERE smu.userID = :userID")
  long updateRole(@Param("userID") Long userID, @Param("roleID") Long roleID);

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
