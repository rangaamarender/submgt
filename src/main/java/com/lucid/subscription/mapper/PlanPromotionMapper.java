/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;
import java.util.Set;

import com.lucid.core.base.BaseMapper;
import com.lucid.subscription.data.PlanPromotionVO;
import com.lucid.subscription.entity.PlanPromotion;

/**
 * @author sgutti
 * @date 10-May-2023 10:33:01 pm
 */
public interface PlanPromotionMapper extends BaseMapper {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @param data
     * @return
     */
    PlanPromotion toEntity(PlanPromotionVO data);

    /**
     * @param dataList
     * @return
     */
    List<PlanPromotion> toEntityList(List<PlanPromotionVO> dataList);

    /**
     * @param data
     * @return
     */
    PlanPromotionVO toVO(PlanPromotion data);

    /**
     * @param entityList
     * @return
     */
    List<PlanPromotionVO> toVOList(Set<PlanPromotion> entityList);
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
