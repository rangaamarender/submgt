/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.lucid.subscription.data.SubscriptionTrackerVO;
import com.lucid.subscription.entity.SubscriptionTracker;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 23:20:44 IST 2021
 */
@Mapper
public interface SubscriptionTrackerMapper {
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
  SubscriptionTracker toEntity(SubscriptionTrackerVO data);

  /**
   * @param dataList
   * @return
   */
  List<SubscriptionTracker> toEntityList(List<SubscriptionTrackerVO> dataList);

  /**
   * @param data
   * @return
   */
  SubscriptionTrackerVO toVO(SubscriptionTracker data);

  /**
   * @param entityList
   * @return
   */
  List<SubscriptionTrackerVO> toVOList(List<SubscriptionTracker> entityList);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
