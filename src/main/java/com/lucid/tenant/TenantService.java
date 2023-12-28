/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.tenant;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.data.SubInvoiceVO;
import com.lucid.tenant.data.DashBoardTenantsCountsVO;
import com.lucid.tenant.data.TenantVO;

/**
 * @author sgutti
 * @date Oct 26, 2019 11:18:46 PM
 */
public interface TenantService {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  // ---------------------------------------------------------- Public Methods

  /**
   * @param page
   * @param pageSize
   * @return
   * @throws ApplicationException
   */
  Page<TenantVO> retrieveAllTenants(int page, int pageSize) throws ApplicationException;

  /**
   * @param matchingStr
   * @param pageable
   * @return
   * @throws ApplicationException
   */
  List<TenantVO> retrieveAllTenants(String matchingStr, Pageable pageable)
      throws ApplicationException;

  /**
   * @param tenantID
   * @return
   * @throws ApplicationException
   */
  TenantVO retrieveTenant(long tenantID) throws ApplicationException;

  /**
   * @param subscriptionID
   * @return
   * @throws ApplicationException
   */
  List<SubInvoiceVO> retrieveLast5OpenInvoices(long subscriptionID) throws ApplicationException;

  /**
   * @param invoiceID
   * @return
   * @throws ApplicationException
   */
  SubInvoiceVO retrieveInvoice(long invoiceID) throws ApplicationException;

  long getActiveTenantsCount() throws ApplicationException;

  long getInActiveTenantsCount() throws ApplicationException;

  long getTotalTenantsCount() throws ApplicationException;

  long getExpiringTenantsCount() throws ApplicationException;

  DashBoardTenantsCountsVO getTenantsCountForDashBoard() throws ApplicationException;

  /**
   * @return
   * @throws ApplicationException
   */
  List<TenantVO> retrieveResent5Tenants() throws ApplicationException;

  long getActiveTenantsCount(Date startDate, Date endDate);

  DashBoardTenantsCountsVO getActiveTenantsGraphForDashBoard(int year);

  String activateOrInActiveTenant(Long tenantId, boolean activate) throws ApplicationException;

  /**
   * @param tenantVO
   * @return
   * @throws ApplicationException
   */
  TenantVO updateTenant(TenantVO tenantVO) throws ApplicationException;

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
