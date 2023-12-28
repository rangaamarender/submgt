/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.lucid.subscription.data.SubInvoiceVO;
import com.lucid.subscription.entity.SubInvoice;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:32:21 IST 2021
 */
@Mapper
public interface SubInvoiceMapper {
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
  SubInvoice toEntity(SubInvoiceVO data);

  /**
   * @param dataList
   * @return
   */
  List<SubInvoice> toEntityList(List<SubInvoiceVO> dataList);

  /**
   * @param data
   * @return
   */
  SubInvoiceVO toVO(SubInvoice data);

  /**
   * @param entityList
   * @return
   */
  List<SubInvoiceVO> toVOList(List<SubInvoice> entityList);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
