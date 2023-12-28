/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;
import java.util.Set;

import com.lucid.core.base.BaseMapper;
import com.lucid.subscription.data.PromotionVO;
import com.lucid.subscription.entity.Promotion;
import org.mapstruct.Mapper;

/**
 * @author sgutti
 * @date 10-May-2023 10:33:01 pm
 */

@Mapper
public interface PromotionMapper extends BaseMapper {
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
    Promotion toEntity(PromotionVO data);

    /**
     * @param dataList
     * @return
     */
    List<Promotion> toEntityList(List<PromotionVO> dataList);

    /**
     * @param data
     * @return
     */
    PromotionVO toVO(Promotion data);

    /**
     * @param entityList
     * @return
     */
    List<PromotionVO> toVOList(List<Promotion> entityList);
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
