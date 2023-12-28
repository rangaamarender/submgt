/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription;

import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import com.lucid.core.base.BaseService;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.data.SalesDashBoardVO;
import com.lucid.subscription.data.SubInvoiceVO;

/**
 * @author sgutti
 * @date May 3, 2022 6:48:36 AM
 */
public interface SubInvoiceService extends BaseService {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  // ---------------------------------------------------------- Public Methods
  /**
   * @param subscriptionID
   * @throws ApplicationException
   */
  void createInvoice(long subscriptionID) throws ApplicationException;

  /**
   * @param subscriptionID
   * @param modifiedBy
   * @param subInvoiceVO
   * @throws ApplicationException
   */
  void updateInvoice(long subscriptionID, String modifiedBy, SubInvoiceVO subInvoiceVO)
      throws ApplicationException;

  /**
   * @param subscriptionID
   * @param createdBy
   * @param subInvoiceVO
   * @throws ApplicationException
   */
  void createInvoice(long subscriptionID, String createdBy, SubInvoiceVO subInvoiceVO)
      throws ApplicationException;

  /**
   * @param subscriptionID
   * @param pageable
   * @return
   * @throws ApplicationException
   */
  List<SubInvoiceVO> retrieveInvoices(long subscriptionID, Pageable pageable)
      throws ApplicationException;

  /**
   * @param subscriptionID
   * @param subInvoiceID
   * @return
   * @throws ApplicationException
   */
  SubInvoiceVO retrieveInvoice(long subscriptionID, long subInvoiceID) throws ApplicationException;

  /**
   * @return
   * @throws ApplicationException
   */
  List<SubInvoiceVO> retrieveRecent5Invoices() throws ApplicationException;

  /**
   * @param period
   * @return map
   * @throws ApplicationException
   */
  SalesDashBoardVO getSalesGraphDetails(String period) throws ApplicationException;

  String resendInvoice(Long subscriptionID, MultipartFile invoice) throws ApplicationException;

  Page<SubInvoiceVO> retrieveInvoices(Map<String, Object> filterParams) throws ApplicationException;

  /**
   * @param page
   * @param pageSize
   * @return
   * @throws ApplicationException
   */
  Page<SubInvoiceVO> retrieveInvoices(int page, int pageSize) throws ApplicationException;


  /**
   * @param tenantID
   * @param page
   * @param pageSize
   * @return
   * @throws ApplicationException
   */
  Page<SubInvoiceVO> retrieveInvoices(long tenantID, int page, int pageSize)
      throws ApplicationException;

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
