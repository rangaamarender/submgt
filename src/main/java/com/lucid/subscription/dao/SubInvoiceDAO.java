/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lucid.subscription.entity.SubInvoice;
import org.springframework.data.repository.query.Param;

/**
 * @author sgutti.ecrv
 * @date Sat May 15 13:32:21 IST 2021
 */
public interface SubInvoiceDAO extends JpaRepository<SubInvoice, Long> {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  // ---------------------------------------------------------- Public Methods
  /**
   * @param subscriptionID
   * @param pageable
   * @return
   */
  List<SubInvoice> findBySubscriptionID(Long subscriptionID, Pageable pageable);


  /**
   * @param subscriptionID
   * @return
   */
  List<SubInvoice> findBySubscriptionID(Long subscriptionID);

  /**
   * @param subscriptionID
   * @param subInvoiceID
   * @return
   */
  @Query(" from SubInvoice a where a.subscriptionID=?1 and a.subInvoiceID=?2 ")
  SubInvoice findBy(long subscriptionID, long subInvoiceID);

  @Query("FROM SubInvoice si ORDER BY si.invoiceDt DESC LIMIT 5")
  List<SubInvoice> fetchRecent5Invoice();

  @Query("SELECT SUM(si.invoiceAmt) FROM SubInvoice si WHERE si.invoiceDt>=:startDate AND si.invoiceDt<=:endDate")
  BigDecimal getSumOfInvoices(@Param("startDate") Date startDate,@Param("endDate") Date endDate);
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
