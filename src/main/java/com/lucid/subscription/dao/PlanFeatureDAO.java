/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lucid.subscription.entity.PlanFeature;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:30:33 IST 2021
 */
public interface PlanFeatureDAO extends JpaRepository<PlanFeature, Long> {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @param subscriptionID
     * @return
     */
    @Query(" from PlanFeature a where a.subscriptionID=?1")
    List<PlanFeature> findBySubscriptionID(long subscriptionID);
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
