/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.lucid.subscription.data.SubPaymentVO;
import com.lucid.subscription.entity.SubPayment;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:35:27 IST 2021
 */
@Mapper
public interface SubPaymentMapper {
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
  SubPayment toEntity(SubPaymentVO data);

  /**
   * @param dataList
   * @return
   */
  List<SubPayment> toEntityList(List<SubPaymentVO> dataList);

  /**
   * @param data
   * @return
   */
  SubPaymentVO toVO(SubPayment data);

  /**
   * @param entityList
   * @return
   */
  List<SubPaymentVO> toVOList(List<SubPayment> entityList);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
