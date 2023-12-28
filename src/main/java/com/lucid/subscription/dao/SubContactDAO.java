/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lucid.subscription.entity.SubContact;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:31:50 IST 2021
 */
public interface SubContactDAO extends JpaRepository<SubContact, Long> {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @param subcriptionID
     * @param pageable
     * @return
     */
    @Query(" from SubContact a where a.subcriptionID=?1")
    List<SubContact> findBySubscriptionID(long subcriptionID, Pageable pageable);

    /**
     * @param subcriptionID
     * @return
     */
    @Query(" from SubContact a where a.subcriptionID=?1")
    List<SubContact> findBySubscriptionID(long subcriptionID);

    /**
     * @param subcriptionID
     * @param subContactID
     * @return
     */
    @Query(" from SubContact a where a.subcriptionID=?1 and a.subContactID=?2")
    SubContact findBySubscriptionID(long subcriptionID, long subContactID);

    /**
     * @param subcriptionID
     * @return
     */
    @Query(" from SubContact a where a.subcriptionID=?1 and a.contactType=1")
    SubContact findByPrimaryContact(long subcriptionID);
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
