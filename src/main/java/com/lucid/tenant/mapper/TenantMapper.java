/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.tenant.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.lucid.tenant.data.TenantVO;
import com.lucid.tenant.entity.Tenant;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 18:21:24 IST 2021
 */
@Mapper
public interface TenantMapper {
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
  Tenant toEntity(TenantVO data);

  /**
   * @param dataList
   * @return
   */
  List<Tenant> toEntityList(List<TenantVO> dataList);

  /**
   * @param data
   * @return
   */
  TenantVO toVO(Tenant data);

  /**
   * @param entityList
   * @return
   */
  List<TenantVO> toVOList(List<Tenant> entityList);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
