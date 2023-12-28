/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.lucid.subscription.data.SubMgtUserVO;
import com.lucid.subscription.entity.SubMgtUser;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 23:20:29 IST 2021
 */
@Mapper
public interface SubMgtUserMapper {
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
  SubMgtUser toEntity(SubMgtUserVO data);

  /**
   * @param dataList
   * @return
   */
  List<SubMgtUser> toEntityList(List<SubMgtUserVO> dataList);

  /**
   * @param data
   * @return
   */
  SubMgtUserVO toVO(SubMgtUser data);

  /**
   * @param entityList
   * @return
   */
  List<SubMgtUserVO> toVOList(List<SubMgtUser> entityList);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
