/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.lucid.subscription.data.SubContactVO;
import com.lucid.subscription.entity.SubContact;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:31:50 IST 2021
 */
@Mapper
public interface SubContactMapper {
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
  SubContact toEntity(SubContactVO data);

  /**
   * @param dataList
   * @return
   */
  List<SubContact> toEntityList(List<SubContactVO> dataList);

  /**
   * @param data
   * @return
   */
  SubContactVO toVO(SubContact data);

  /**
   * @param entityList
   * @return
   */
  List<SubContactVO> toVOList(List<SubContact> entityList);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
