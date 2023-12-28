/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.tenant.mapper;

import java.util.List;
import com.lucid.core.base.BaseMapper;
import com.lucid.tenant.data.TenantProfileVO;
import com.lucid.tenant.entity.TenantProfile;

/**
 * @author sgutti
 * @date 22-Nov-2023 2:50:58 pm
 *
 */
public interface TenantProfileMapper extends BaseMapper {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  /**
   * @param data
   * @return
   */
  TenantProfile toEntity(TenantProfileVO data);

  /**
   * @param dataList
   * @return
   */
  List<TenantProfile> toEntityList(List<TenantProfileVO> dataList);

  /**
   * @param data
   * @return
   */
  TenantProfileVO toVO(TenantProfile data);

  /**
   * @param entityList
   * @return
   */
  List<TenantProfileVO> toVOList(List<TenantProfile> entityList);
  // ---------------------------------------------------------- Public Methods
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
