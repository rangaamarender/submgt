/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.lucid.subscription.data.PlanLimitVO;
import com.lucid.subscription.entity.PlanLimit;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:31:09 IST 2021
 */
@Mapper
public interface PlanLimitMapper {
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
  PlanLimit toEntity(PlanLimitVO data);

  /**
   * @param dataList
   * @return
   */
  List<PlanLimit> toEntityList(List<PlanLimitVO> dataList);

  /**
   * @param data
   * @return
   */
  PlanLimitVO toVO(PlanLimit data);

  /**
   * @param entityList
   * @return
   */
  List<PlanLimitVO> toVOList(List<PlanLimit> entityList);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
