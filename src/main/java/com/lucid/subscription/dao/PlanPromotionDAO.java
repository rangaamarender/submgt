/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.dao;

import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lucid.subscription.entity.PlanPromotion;

/**
 * @author sgutti
 * @date 10-May-2023 10:31:50 pm
 */
public interface PlanPromotionDAO extends JpaRepository<PlanPromotion, String> {

    /**
     * @param promotionIds
     * @return
     */
    @Query("SELECT pp.promotionID, COUNT(pp) FROM plan_promotions pp WHERE pp.promotionID IN:promotionIds GROUP BY pp.promotionID")
    Map<String, Long> countPlanPromotionByPromotionID(@Param("promotionIds")
    Set<String> promotionIds);
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
