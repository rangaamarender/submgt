/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.lucid.subscription.data.SubscriptionVO;
import com.lucid.subscription.entity.Subscription;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:26:33 IST 2021
 */
@Mapper
public interface SubscriptionMapper {
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
  Subscription toEntity(SubscriptionVO data);

  /**
   * @param dataList
   * @return
   */
  List<Subscription> toEntityList(List<SubscriptionVO> dataList);

  /**
   * @param data
   * @return
   */
  SubscriptionVO toVO(Subscription data);

  /**
   * @param entityList
   * @return
   */
  List<SubscriptionVO> toVOList(List<Subscription> entityList);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
