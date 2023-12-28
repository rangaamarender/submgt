/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.payment.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.lucid.core.base.BaseMapper;
import com.lucid.payment.data.GtwyCustomerPymntProfileVO;
import com.lucid.payment.entity.GtwyCustomerPymntProfile;

/**
 * @author sgutti
 * @date 23-Nov-2023 2:47:39 pm
 *
 */
@Mapper
public interface GtwyCustomerPymntProfileMapper extends BaseMapper {
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
  GtwyCustomerPymntProfile toEntity(GtwyCustomerPymntProfileVO data);

  /**
   * @param dataList
   * @return
   */
  List<GtwyCustomerPymntProfile> toEntityList(List<GtwyCustomerPymntProfileVO> dataList);

  /**
   * @param data
   * @return
   */
  GtwyCustomerPymntProfileVO toVO(GtwyCustomerPymntProfile data);

  /**
   * @param entityList
   * @return
   */
  List<GtwyCustomerPymntProfileVO> toVOList(List<GtwyCustomerPymntProfile> entityList);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
