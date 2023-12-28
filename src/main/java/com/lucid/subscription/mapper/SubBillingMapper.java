/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.lucid.subscription.data.SubBillingVO;
import com.lucid.subscription.entity.SubBilling;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:31:50 IST 2021
 */
@Mapper
public interface SubBillingMapper {
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
  SubBilling toEntity(SubBillingVO data);

  /**
   * @param dataList
   * @return
   */
  List<SubBilling> toEntityList(List<SubBillingVO> dataList);

  /**
   * @param data
   * @return
   */
  SubBillingVO toVO(SubBilling data);

  /**
   * @param entityList
   * @return
   */
  List<SubBillingVO> toVOList(List<SubBilling> entityList);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
