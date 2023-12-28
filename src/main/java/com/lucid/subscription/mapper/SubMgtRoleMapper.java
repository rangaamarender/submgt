/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.lucid.subscription.data.SubMgtRoleVO;
import com.lucid.subscription.entity.SubMgtRole;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 23:20:44 IST 2021
 */
@Mapper
public interface SubMgtRoleMapper {
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
  SubMgtRole toEntity(SubMgtRoleVO data);

  /**
   * @param dataList
   * @return
   */
  List<SubMgtRole> toEntityList(List<SubMgtRoleVO> dataList);

  /**
   * @param data
   * @return
   */
  SubMgtRoleVO toVO(SubMgtRole data);

  /**
   * @param entityList
   * @return
   */
  List<SubMgtRoleVO> toVOList(List<SubMgtRole> entityList);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
