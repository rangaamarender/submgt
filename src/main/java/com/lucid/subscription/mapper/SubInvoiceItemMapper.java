/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.lucid.subscription.data.SubInvoiceItemVO;
import com.lucid.subscription.entity.SubInvoiceItem;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:32:35 IST 2021
 */
@Mapper
public interface SubInvoiceItemMapper {
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
  SubInvoiceItem toEntity(SubInvoiceItemVO data);

  /**
   * @param dataList
   * @return
   */
  List<SubInvoiceItem> toEntityList(List<SubInvoiceItemVO> dataList);

  /**
   * @param data
   * @return
   */
  SubInvoiceItemVO toVO(SubInvoiceItem data);

  /**
   * @param entityList
   * @return
   */
  List<SubInvoiceItemVO> toVOList(List<SubInvoiceItem> entityList);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
