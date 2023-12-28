/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateTime;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.lucid.core.constants.EnumStatus;
import com.lucid.core.email.EmailContent;
import com.lucid.core.email.EmailHelper;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.config.PlanConfig;
import com.lucid.subscription.constants.EnumSubUserContactType;
import com.lucid.subscription.dao.PlanFeatureDAO;
import com.lucid.subscription.dao.SubBillingDAO;
import com.lucid.subscription.dao.SubContactDAO;
import com.lucid.subscription.dao.SubInvoiceDAO;
import com.lucid.subscription.dao.SubInvoiceItemDAO;
import com.lucid.subscription.dao.SubscriptionDAO;
import com.lucid.subscription.data.SalesDashBoardVO;
import com.lucid.subscription.data.SubInvoiceVO;
import com.lucid.subscription.entity.PlanFeature;
import com.lucid.subscription.entity.SubBilling;
import com.lucid.subscription.entity.SubContact;
import com.lucid.subscription.entity.SubInvoice;
import com.lucid.subscription.entity.SubInvoiceItem;
import com.lucid.subscription.entity.Subscription;
import com.lucid.subscription.jaxb.FeatureType;
import com.lucid.subscription.jaxb.PlanType;
import com.lucid.subscription.mapper.SubInvoiceMapper;
import com.lucid.util.EnvConfig;
import com.lucid.util.ServiceUtils;
import jakarta.persistence.PersistenceException;

/**
 * @author sgutti
 * @date May 3, 2022 6:50:09 AM
 */
@Component(SubInvoiceServiceImpl.SERVICE_NAME)
public class SubInvoiceServiceImpl extends BaseSubServiceImpl implements SubInvoiceService {
  // --------------------------------------------------------------- Constants
  public static final Logger LOGGER = LoggerFactory.getLogger(SubInvoiceServiceImpl.class);
  public static final String SERVICE_NAME = "subInvoiceService";
  public static final String ERROR_SUB_INV_0000 = "ERROR_SUB_INV_0000";
  public static final String ERROR_SUB_INV_0001 = "ERROR_SUB_INV_0001";
  public static final String ERROR_SUB_INV_0002 = "ERROR_SUB_INV_0002";
  public static final String ERROR_SUB_INV_0003 = "ERROR_SUB_INV_0003";
  public static final String ERROR_SUB_INV_0004 = "ERROR_SUB_INV_0004";
  public static final String ERROR_SUB_INV_0005 = "ERROR_SUB_INV_0005";
  public static final String ERROR_SUB_INV_0006 = "ERROR_SUB_INV_0006";
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Autowired
  private SubscriptionDAO subscriptionDAO;
  @Autowired
  private SubInvoiceDAO subInvoiceDAO;
  @Autowired
  private SubInvoiceItemDAO subInvoiceItemDAO;
  @Autowired
  private SubBillingDAO subBillingDAO;
  @Autowired
  private SubContactDAO subContactDAO;
  @Autowired
  private PlanFeatureDAO planFeatureDAO;
  @Autowired
  private EmailHelper emailHelper;

  @Autowired
  private EnvConfig envConfig;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubInvoiceServiceImpl</code>
   */
  public SubInvoiceServiceImpl() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * Step 1: Retrieve the Subscription details and plan Step 2: Get the next bill date Step 3: Get
   * the plan code , features and its price Step 4: Create invoice line items for each feature with
   * amount Step 5: Create invoice for the subscription Step 6: update the next bill date
   * appropriately.
   * 
   * @see com.lucid.subscription.SubInvoiceService#createInvoice(long)
   */
  @Override
  @Transactional
  public void createInvoice(long subscriptionID) throws ApplicationException {
    try {
      Optional<Subscription> tmp = subscriptionDAO.findById(subscriptionID);
      if (tmp.isEmpty()) {
        throw new ApplicationException(ERROR_SUB_INV_0000, "unable to find the subscripiton");
      }
      Subscription subscription = tmp.get();
      SubInvoice subInvoice = initalizeInvoice(subscription);
      subInvoiceDAO.save(subInvoice);
      // update the next bill date
      DateTime invoiceDt = new DateTime(subInvoice.getInvoiceDt());
      // Get the subscription billing

      Optional<SubBilling> subBillingResult = subBillingDAO.findById(subscriptionID);
      SubBilling subBilling = subBillingResult.isPresent() ? subBillingResult.get() : null;
      if (subBilling == null) {
        subBilling = new SubBilling();
        subBilling.setBillPeriodUnit(1);
        subBilling.setSubscriptionID(subscriptionID);
        subBilling.setBillcycleDay(1);
        subBilling.setInvoiceType(2);
        DateTime dateTime = new DateTime();
        subBilling.setEffectiveDt(dateTime.toDate());
        subBilling.setNextBillDt(dateTime.plusMonths(1).toDate());
        subBilling.setCreatedBy("SYSTEM");
        subBilling.setCreatedDt(Calendar.getInstance().getTime());
      }
      int billPeriodUnit = subBilling.getBillPeriodUnit();
      // Monthly billing
      if (billPeriodUnit == 1) {
        subBilling.setNextBillDt(invoiceDt.plusMonths(1).toDate());
      } else if (billPeriodUnit == 2) {
        // yearly billing
        subBilling.setNextBillDt(invoiceDt.plusYears(1).toDate());
      }
      subBillingDAO.save(subBilling);
    } catch (DataAccessException | PersistenceException e) {
      throw new ApplicationException(ERROR_SUB_INV_0001, e.getLocalizedMessage(), e);
    }
  }

  /**
   * @see com.lucid.subscription.SubscriptionService#createInvoice(long, java.lang.String,
   *      com.lucid.subscription.data.SubInvoiceVO)
   */
  @Override
  public void createInvoice(long subscriptionID, String createdBy, SubInvoiceVO subInvoiceVO)
      throws ApplicationException {
    try {
      Optional<Subscription> tmp = subscriptionDAO.findById(subscriptionID);
      if (tmp.isEmpty()) {
        throw new ApplicationException(ERROR_SUB_INV_0000, ERROR_SUB_INV_0000);
      }
      SubInvoiceMapper mapper = Mappers.getMapper(SubInvoiceMapper.class);
      SubInvoice subInvoice = mapper.toEntity(subInvoiceVO);
      subInvoice.setSubscriptionID(subscriptionID);
      Set<SubInvoiceItem> invoiceItems = subInvoice.getInvoiceItems();
      //
      for (SubInvoiceItem subInvoiceItem : invoiceItems) {
        subInvoice.addSubInvoiceItem(subInvoiceItem);
      }
      subInvoiceDAO.save(subInvoice);
      // subInvoiceItemDAO.saveAll(invoiceItems);
    } catch (DataAccessException | PersistenceException e) {
      throw new ApplicationException(ERROR_SUB_INV_0002, e.getLocalizedMessage(), e);
    }
  }

  /**
   * @see com.lucid.subscription.SubInvoiceService#retrieveInvoices(long, int, int)
   */
  @Override
  public List<SubInvoiceVO> retrieveInvoices(long subscriptionID, Pageable pageable)
      throws ApplicationException {
    List<SubInvoiceVO> invoices = null;
    try {
      Optional<Subscription> tmp = subscriptionDAO.findById(subscriptionID);
      if (tmp.isEmpty()) {
        throw new ApplicationException(ERROR_SUB_INV_0000, ERROR_SUB_INV_0000);
      }
      List<SubInvoice> subInvoices = subInvoiceDAO.findBySubscriptionID(subscriptionID, pageable);
      SubInvoiceMapper mapper = Mappers.getMapper(SubInvoiceMapper.class);
      invoices = mapper.toVOList(subInvoices);
    } catch (DataAccessException | PersistenceException e) {
      throw new ApplicationException(ERROR_SUB_INV_0003, e.getLocalizedMessage(), e);
    }
    return invoices;
  }

  /**
   * @see com.lucid.subscription.SubInvoiceService#updateInvoice(long, java.lang.String,
   *      com.lucid.subscription.data.SubInvoiceVO)
   */
  @Override
  public void updateInvoice(long subscriptionID, String modifiedBy, SubInvoiceVO subInvoiceVO)
      throws ApplicationException {
    try {
      Optional<Subscription> tmp = subscriptionDAO.findById(subscriptionID);
      if (tmp.isEmpty()) {
        throw new ApplicationException(ERROR_SUB_INV_0000, ERROR_SUB_INV_0000);
      }
      SubInvoiceMapper mapper = Mappers.getMapper(SubInvoiceMapper.class);
      SubInvoice subInvoice = mapper.toEntity(subInvoiceVO);
      Set<SubInvoiceItem> invoiceItems = subInvoice.getInvoiceItems();
      //
      subInvoiceDAO.save(subInvoice);
      for (SubInvoiceItem subInvoiceItem : invoiceItems) {
        subInvoiceItem.setSubInvoice(subInvoice);
      }
      subInvoiceItemDAO.saveAll(invoiceItems);
    } catch (DataAccessException | PersistenceException e) {
      throw new ApplicationException(ERROR_SUB_INV_0004, e.getLocalizedMessage(), e);
    }
  }

  /**
   * @see com.lucid.subscription.SubInvoiceService#retrieveInvoice(long, long)
   */
  @Override
  public SubInvoiceVO retrieveInvoice(long subscriptionID, long subInvoiceID)
      throws ApplicationException {
    throwExceptionIfNoTenant(subscriptionID);
    SubInvoiceVO result = null;
    try {
      Optional<Subscription> tmp = subscriptionDAO.findById(subscriptionID);
      if (tmp.isEmpty()) {
        throw new ApplicationException(ERROR_SUB_INV_0000, ERROR_SUB_INV_0000);
      }
      SubInvoice subInvoice = subInvoiceDAO.findBy(subscriptionID, subInvoiceID);
      SubInvoiceMapper mapper = Mappers.getMapper(SubInvoiceMapper.class);
      result = mapper.toVO(subInvoice);
    } catch (DataAccessException | PersistenceException e) {
      throw new ApplicationException(ERROR_SUB_INV_0005, e.getLocalizedMessage(), e);
    }
    return result;
  }

  @Override
  public List<SubInvoiceVO> retrieveRecent5Invoices() throws ApplicationException {
    List<SubInvoiceVO> invoiceList = null;
    try {
      List<SubInvoice> invoiceEntities = subInvoiceDAO.fetchRecent5Invoice();
      if (invoiceEntities.isEmpty()) {
        LOGGER.info("No Invoices found in the search");
        return Collections.emptyList();
      }
      SubInvoiceMapper mapper = Mappers.getMapper(SubInvoiceMapper.class);
      invoiceList = mapper.toVOList(invoiceEntities);
    } catch (Exception e) {
      LOGGER.error(ERROR_SUB_INV_0004, e);
      throw new ApplicationException(ERROR_SUB_INV_0004,
          "Unable to retrieve invoices in the system");
    }
    return invoiceList;
  }

  @Override
  public SalesDashBoardVO getSalesGraphDetails(String timePeriod) throws ApplicationException {
    Map<String, BigDecimal> salesGraphDetails = new HashMap<>();
    if (timePeriod.equalsIgnoreCase("Last Week")) {
      final ZonedDateTime input = ZonedDateTime.now();
      final ZonedDateTime startOfLastWeek = input.minusWeeks(1).with(DayOfWeek.MONDAY);
      for (int i = 0; i < 7; i++) {
        LocalDateTime startOfDay = startOfLastWeek.toLocalDate().atStartOfDay().plusDays(i);
        Date startDate = Date.from(startOfDay.atZone(java.time.ZoneId.systemDefault()).toInstant());
        LocalDateTime endOfDay = startOfLastWeek.toLocalDate().atTime(23, 59, 59).plusDays(i);
        Date endDate = Date.from(endOfDay.atZone(java.time.ZoneId.systemDefault()).toInstant());
        salesGraphDetails.put(startOfDay.toLocalDate().toString(),
            subInvoiceDAO.getSumOfInvoices(startDate, endDate));
      }
    } else if (timePeriod.equalsIgnoreCase("Last Month")) {
      LocalDate localDate = LocalDate.now();
      int year = localDate.getYear();
      int month = localDate.getMonth().getValue();
      if (month == 1) {
        year = year - 1;
        month = 12;
      }
      LocalDate lastMonth = LocalDate.of(year, month, 1);
      LocalDateTime firstDayOfLastMonth = lastMonth.withDayOfMonth(1).atStartOfDay();
      LocalDateTime lastDayOfLastMonth =
          lastMonth.with(TemporalAdjusters.lastDayOfMonth()).atTime(23, 59, 59);
      int weekCounter = 1;
      LocalDateTime weekStart = firstDayOfLastMonth;
      while (!weekStart.isAfter(lastDayOfLastMonth)) {
        LocalDateTime weekEnd = weekStart.with(TemporalAdjusters
            .nextOrSame(LocalDate.of(weekStart.getYear(), weekStart.getMonth(), 7).getDayOfWeek()));
        if (weekEnd.isAfter(lastDayOfLastMonth)) {
          weekEnd = lastDayOfLastMonth;
        }
        salesGraphDetails.put("Week " + weekCounter,
            subInvoiceDAO.getSumOfInvoices(
                Date.from(weekStart.atZone(java.time.ZoneId.systemDefault()).toInstant()),
                Date.from(weekEnd.atZone(java.time.ZoneId.systemDefault()).toInstant())));
        weekStart = weekEnd.plusDays(1);
        weekCounter++;
      }
    } else if (timePeriod.equalsIgnoreCase("Quarter")) {
      YearMonth currentMonth = YearMonth.now(); // current year and month
      for (int i = 0; i < 3; i++) {
        YearMonth month = currentMonth.minus(i + 1, ChronoUnit.MONTHS);
        LocalDateTime startOfDay = month.atDay(1).atStartOfDay();
        Date startDate = Date.from(startOfDay.atZone(java.time.ZoneId.systemDefault()).toInstant());
        LocalDateTime endOfDay = month.atEndOfMonth().atTime(23, 59, 59);
        Date endDate = Date.from(endOfDay.atZone(java.time.ZoneId.systemDefault()).toInstant());
        salesGraphDetails.put(month.toString(), subInvoiceDAO.getSumOfInvoices(startDate, endDate));
      }
    } else if (timePeriod.equalsIgnoreCase("Year")) {
      int oldYear = YearMonth.now().getYear() - 1;
      for (int i = 0; i < 12; i++) {
        YearMonth oldYearMonth = YearMonth.of(oldYear, i + 1);
        LocalDateTime startOfDay = oldYearMonth.atDay(1).atStartOfDay();
        Date startDate = Date.from(startOfDay.atZone(java.time.ZoneId.systemDefault()).toInstant());
        LocalDateTime endOfDay = oldYearMonth.atEndOfMonth().atTime(23, 59, 59);
        Date endDate = Date.from(endOfDay.atZone(java.time.ZoneId.systemDefault()).toInstant());
        salesGraphDetails.put(oldYearMonth.toString(),
            subInvoiceDAO.getSumOfInvoices(startDate, endDate));
      }
    }
    SalesDashBoardVO salesDashBoardVO = new SalesDashBoardVO();
    salesDashBoardVO.setSalesGraphDetails(salesGraphDetails);
    return salesDashBoardVO;
  }

  @Override
  public String resendInvoice(Long subscriptionID, MultipartFile invoice)
      throws ApplicationException {
    try {
      Optional<Subscription> subscription = subscriptionDAO.findById(subscriptionID);
      if (subscription.isPresent()) {
        if (invoice != null && invoice.getContentType() != null
            && invoice.getContentType().equalsIgnoreCase("application/pdf")) {
          List<SubContact> subContacts = subContactDAO.findBySubscriptionID(subscriptionID);
          if (CollectionUtils.isNotEmpty(subContacts)) {
            List<String> adminsMails = subContacts.stream()
                .filter(subContact -> subContact.getContactType() == EnumSubUserContactType.ADMIN
                    || subContact.getContactType() == EnumSubUserContactType.PRIMARY)
                .map(subContact -> subContact.getEmailID()).collect(Collectors.toList());
            if (adminsMails != null && adminsMails.size() > 0) {
              if (envConfig.isProdMode()) {
                // byte[] data = invoice.getBytes();
                EmailContent emailContent = initializeEmailContentToSendInvoice(adminsMails);
                emailHelper.sendEmailWithAttachment(emailContent, invoice);
                LOGGER.info("Invoice sent successfully");
                return "Invoice sent successfully";
              } else {
                LOGGER.info("Invoice sent successfully");
                return "Invoice sent successfully";
              }
            }
            LOGGER.info("No Admins found to send invoice");
            throw new ApplicationException(ERROR_SUB_INV_0002, "No Admins found to send invoice");
          }
          LOGGER.info("No Admins found to send invoice");
          throw new ApplicationException(ERROR_SUB_INV_0002, "No Admins found to send invoice");
        }
        LOGGER.info("Invalid file, File should be PDF");
        throw new ApplicationException(ERROR_SUB_INV_0003, "Invalid file, File should be PDF");
      }
      LOGGER.info("Subscription not found to resendInvoice");
      throw new ApplicationException(ERROR_SUB_INV_0001, "Subscription not found to resendInvoice");
    } catch (Exception e) {
      LOGGER.error(e.getLocalizedMessage());
      throw new ApplicationException(ERROR_SUB_INV_0000, e.getLocalizedMessage());
    }
  }

  @Override
  public Page<SubInvoiceVO> retrieveInvoices(Map<String, Object> filterParam)
      throws ApplicationException {
    Page<SubInvoice> subInvoices = null;
    filterParam.put("pageable", ServiceUtils.getPageableObject(filterParam));
    try {
      subInvoices = subInvoiceDAO.findAll((Pageable) filterParam.get("pageable"));
      SubInvoiceMapper subInvoiceMapper = Mappers.getMapper(SubInvoiceMapper.class);
      return new PageImpl<>(subInvoiceMapper.toVOList(subInvoices.getContent()),
          subInvoices.getPageable(), subInvoices.getTotalElements());
    } catch (Exception e) {
      throw new ApplicationException(ERROR_SUB_INV_0005, e.getLocalizedMessage());
    }
  }


  /**
   * @see com.lucid.subscription.SubInvoiceService#retrieveInvoices(long, int, int)
   */
  @Override
  public Page<SubInvoiceVO> retrieveInvoices(long tenantID, int page, int pageSize)
      throws ApplicationException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * @see com.lucid.subscription.SubInvoiceService#retrieveInvoices(int, int)
   */
  @Override
  public Page<SubInvoiceVO> retrieveInvoices(int page, int pageSize) throws ApplicationException {
    Page<SubInvoiceVO> result = null;
    try {
      Pageable pageable = PageRequest.of(page, pageSize);
      Page<SubInvoice> subInvoicePage = subInvoiceDAO.findAll(pageable);
      SubInvoiceMapper mapper = Mappers.getMapper(SubInvoiceMapper.class);
      List<SubInvoiceVO> subInvoiceList = mapper.toVOList(subInvoicePage.toList());
      result =
          new PageImpl<SubInvoiceVO>(subInvoiceList, pageable, subInvoicePage.getTotalElements());
    } catch (DataAccessException | PersistenceException e) {
      LOGGER.error(ERROR_SUB_INV_0006, e.getLocalizedMessage(), e);
      throw new ApplicationException(ERROR_SUB_INV_0006, e.getLocalizedMessage(), e);
    }
    return result;
  }

  private EmailContent initializeEmailContentToSendInvoice(List<String> adminsMails) {
    EmailContent content = new EmailContent();
    content.setToList(adminsMails);
    content.setFrom(envConfig.getSupportEmailAddress());
    content.setSubject("InVoice Details");
    content.setBody("Invoice Details");
    return content;
  }

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  /**
   * @param subscription
   * @return
   */
  private SubInvoice initalizeInvoice(Subscription subscription) {
    String planCode = subscription.getPlanCode();
    PlanType planType = PlanConfig.getInstance().getPlan(planCode);
    Map<String, FeatureType> map = createFeaturesMap(planType.getFeature());
    SubInvoice subInvoice = new SubInvoice();
    DateTime currentDt = new DateTime();
    subInvoice.setInvoiceDt(currentDt.toDate());
    subInvoice.setInvoiceDueDt(currentDt.plusDays(15).toDate());
    subInvoice.setInvoiceStatus(EnumStatus.INACTIVE);
    subInvoice.setSubscriptionID(subscription.getSubscriptionID());
    subInvoice.setUpdatedDt(currentDt.toDate());
    // invoice items
    List<PlanFeature> planFeatures =
        planFeatureDAO.findBySubscriptionID(subscription.getSubscriptionID());
    BigDecimal totalAmt = new BigDecimal(0);
    subInvoice.setInvoiceAmt(totalAmt);
    if (CollectionUtils.isEmpty(planFeatures)) {
      return subInvoice;
    }
    for (PlanFeature planFeature : planFeatures) {
      SubInvoiceItem subInvoiceItem = new SubInvoiceItem();
      subInvoiceItem.setItemCode(planFeature.getFeatureCode());
      subInvoiceItem.setDescription(planFeature.getFeatureDesc());
      BigDecimal quantity = BigDecimal.valueOf(1);
      subInvoiceItem.setQty(quantity);
      FeatureType featureType = map.get(planFeature.getFeatureCode());
      BigDecimal featureAmount = featureType.getFeatureAmount();
      subInvoiceItem.setRate(featureAmount);
      BigDecimal amount = quantity.multiply(featureAmount);
      subInvoiceItem.setAmt(amount);
      totalAmt = totalAmt.add(amount);
      subInvoice.addSubInvoiceItem(subInvoiceItem);
    }
    //
    subInvoice.setInvoiceAmt(totalAmt);
    return subInvoice;
  }

  /**
   * @param featureTypes
   * @return
   */
  private Map<String, FeatureType> createFeaturesMap(List<FeatureType> featureTypes) {
    Map<String, FeatureType> map = new HashMap<>();
    for (FeatureType featureType : featureTypes) {
      map.put(featureType.getFeatureCode(), featureType);
    }
    return map;
  }

  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
