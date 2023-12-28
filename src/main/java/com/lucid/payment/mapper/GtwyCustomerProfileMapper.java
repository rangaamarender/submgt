/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.payment.mapper;

import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import com.lucid.core.base.BaseMapper;
import com.lucid.payment.data.GtwyCustomerProfileVO;
import com.lucid.payment.entity.GtwyCustomerProfile;

/**
 * @author sgutti
 * @date 23-Nov-2023 2:47:39 pm
 *
 */
@Mapper
public interface GtwyCustomerProfileMapper extends BaseMapper {
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
  GtwyCustomerProfile toEntity(GtwyCustomerProfileVO data);

  /**
   * @param dataList
   * @return
   */
  List<GtwyCustomerProfile> toEntityList(List<GtwyCustomerProfileVO> dataList);

  /**
   * @param data
   * @return
   */
  GtwyCustomerProfileVO toVO(GtwyCustomerProfile data);

  /**
   * @param entityList
   * @return
   */
  List<GtwyCustomerProfileVO> toVOList(Set<GtwyCustomerProfile> entityList);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
