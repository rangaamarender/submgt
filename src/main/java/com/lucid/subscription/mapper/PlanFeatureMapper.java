/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import com.lucid.subscription.data.PlanFeatureVO;
import com.lucid.subscription.entity.PlanFeature;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:30:33 IST 2021
 */
@Mapper
public interface PlanFeatureMapper {
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
  PlanFeature toEntity(PlanFeatureVO data);

  /**
   * @param dataList
   * @return
   */
  List<PlanFeature> toEntityList(List<PlanFeatureVO> dataList);

  /**
   * @param data
   * @return
   */
  PlanFeatureVO toVO(PlanFeature data);

  /**
   * @param entityList
   * @return
   */
  List<PlanFeatureVO> toVOList(Set<PlanFeature> entityList);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
