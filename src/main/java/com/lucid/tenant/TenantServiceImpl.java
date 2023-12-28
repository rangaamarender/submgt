/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.tenant;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.DataException;
import org.joda.time.DateTime;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.lucid.core.base.BaseServiceImpl;
import com.lucid.core.constants.EnumStatus;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.dao.SubContactDAO;
import com.lucid.subscription.dao.SubInvoiceDAO;
import com.lucid.subscription.dao.SubscriptionDAO;
import com.lucid.subscription.data.SubInvoiceVO;
import com.lucid.subscription.entity.SubInvoice;
import com.lucid.subscription.mapper.SubInvoiceMapper;
import com.lucid.tenant.dao.TenantDAO;
import com.lucid.tenant.data.DashBoardTenantsCountsVO;
import com.lucid.tenant.data.TenantVO;
import com.lucid.tenant.entity.Tenant;
import com.lucid.tenant.mapper.TenantMapper;

/**
 * @author sgutti
 * @date Oct 26, 2019 11:36:38 PM
 */
@Component(TenantServiceImpl.SERVICE_NAME)
public class TenantServiceImpl extends BaseServiceImpl implements TenantService {
  // --------------------------------------------------------------- Constants
  private static Logger LOGGER = LoggerFactory.getLogger(TenantServiceImpl.class);
  public static final String SERVICE_NAME = "tenantService";
  public static final String TNT_SVC_000 = "TNT_SVC_000";
  public static final String TNT_SVC_001 = "TNT_SVC_001";
  public static final String TNT_SVC_002 = "TNT_SVC_002";
  public static final String TNT_SVC_003 = "TNT_SVC_003";
  public static final String TNT_SVC_004 = "TNT_SVC_004";
  public static final String TNT_SVC_005 = "TNT_SVC_005";
  public static final String TNT_SVC_006 = "TNT_SVC_006";
  public static final String TNT_SVC_007 = "TNT_SVC_007";
  public static final String TNT_SVC_008 = "TNT_SVC_008";
  public static final String TNT_SVC_009 = "TNT_SVC_009";
  public static final String TNT_SVC_010 = "TNT_SVC_010";

  // subscription expiring days
  public static final Integer SUB_EXPIRING_DAYS = 10;
  public static final String NEW = "new";
  public static final String OLD = "old";

  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Autowired
  private TenantDAO tenantDAO;
  @Autowired
  private SubInvoiceDAO subInvoiceDAO;

  @Autowired
  private SubscriptionDAO subscriptionDAO;

  @Autowired
  private SubContactDAO subContactDAO;

  // ------------------------------------------------------------ Constructors

  /**
   * Create a new <code>TenantServiceImpl</code>
   */
  public TenantServiceImpl() {
    super();
  }

  // ---------------------------------------------------------- Public Methods

  /**
   * @see com.lucid.tenant.TenantService#retrieveAllTenants()
   */
  @Override
  public Page<TenantVO> retrieveAllTenants(int page, int pageSize) throws ApplicationException {
    Page<TenantVO> result = null;
    try {
      Pageable pageable = PageRequest.of(page, pageSize);
      Page<Tenant> tenantEntities = tenantDAO.findAll(pageable);
      if (tenantEntities.isEmpty()) {
        LOGGER.info("No tenants found in the search");
        return new PageImpl<TenantVO>(Collections.emptyList());
      }
      TenantMapper mapper = Mappers.getMapper(TenantMapper.class);
      List<TenantVO> tenantList = mapper.toVOList(tenantEntities.toList());
      result = new PageImpl<TenantVO>(tenantList, pageable, tenantEntities.getTotalElements());
    } catch (Exception e) {
      LOGGER.error(TNT_SVC_004, e);
      throw new ApplicationException(TNT_SVC_004, "Unable to retrieve tenants in the system");
    }
    return result;
  }

  /**
   * @see com.lucid.tenant.TenantService#retrieveAllTenants(java.lang.String, Pageable)
   */
  @Override
  @Transactional(readOnly = true)
  public List<TenantVO> retrieveAllTenants(String matchingStr, Pageable pageable)
      throws ApplicationException {
    List<TenantVO> tenantList = null;
    try {
      Tenant filterBy = new Tenant();
      if (StringUtils.isBlank(matchingStr)) {
        matchingStr = "";
      }
      filterBy.setCompanyName(matchingStr);
      // Match string containing pattern - ignore case sensitivity
      ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING)
          .withIgnoreCase("companyName").withIgnorePaths("status");
      Example<Tenant> example = Example.of(filterBy, matcher);
      Page<Tenant> tenantEntities = tenantDAO.findAll(example, pageable);
      if (tenantEntities == null || tenantEntities.isEmpty()) {
        return Collections.emptyList();
      }
      TenantMapper mapper = Mappers.getMapper(TenantMapper.class);
      tenantList = mapper.toVOList(tenantEntities.toList());
    } catch (Exception e) {
      LOGGER.error(TNT_SVC_005, e);
      throw new ApplicationException(TNT_SVC_005, "Unable to retrieve tenants in the system");
    }
    return tenantList;
  }

  /**
   * @see com.lucid.tenant.TenantService#retrieveTenant(long)
   */
  @Override
  public TenantVO retrieveTenant(long tenantID) throws ApplicationException {
    TenantVO tenantVO = null;
    try {
      Tenant tenant = tenantDAO.findByTenantID(tenantID);
      if (tenant == null) {
        LOGGER.info("No tenant found in the search");
        throw new ApplicationException(TNT_SVC_006, TNT_SVC_006);
      }
      TenantMapper mapper = Mappers.getMapper(TenantMapper.class);
      tenantVO = mapper.toVO(tenant);
      // Subscription subscription = subscriptionDAO.findByTenantID(tenant.getTenantID());
      // if (subscription != null) {
      // SubscriptionMapper subscriptionMapper = Mappers.getMapper(SubscriptionMapper.class);
      // tenantVO.setSubscription(subscriptionMapper.toVO(subscription));
      // }
    } catch (Exception e) {
      LOGGER.error(TNT_SVC_005, e);
      throw new ApplicationException(TNT_SVC_005, "Unable to retrieve tenants in the system");
    }
    return tenantVO;
  }

  /**
   * @see com.lucid.tenant.TenantService#retrieveLast5OpenInvoices(long)
   */
  @Override
  public List<SubInvoiceVO> retrieveLast5OpenInvoices(long subscriptionID)
      throws ApplicationException {
    List<SubInvoiceVO> result = null;
    try {
      List<SubInvoice> invoices = subInvoiceDAO.findBySubscriptionID(subscriptionID);
      SubInvoiceMapper mapper = Mappers.getMapper(SubInvoiceMapper.class);
      result = mapper.toVOList(invoices);
    } catch (Exception e) {
      LOGGER.error(TNT_SVC_006, e);
      throw new ApplicationException(TNT_SVC_006, "Unable to retrieve invoices from the system");
    }
    return result;
  }

  /**
   * @see com.lucid.tenant.TenantService#retrieveInvoice(long)
   */
  @Override
  public SubInvoiceVO retrieveInvoice(long invoiceID) throws ApplicationException {
    SubInvoiceVO result = null;
    try {
      Optional<SubInvoice> invoice = subInvoiceDAO.findById(invoiceID);
      SubInvoiceMapper mapper = Mappers.getMapper(SubInvoiceMapper.class);
      result = mapper.toVO(invoice.get());
    } catch (Exception e) {
      LOGGER.error(TNT_SVC_006, e);
      throw new ApplicationException(TNT_SVC_006, "Unable to retrieve invoices from the system");
    }
    return result;
  }

  /**
   * @return
   * @throws ApplicationException
   */
  @Override
  public long getActiveTenantsCount() throws ApplicationException {
    long count = 0;
    try {
      Tenant filter = new Tenant();
      filter.setStatus(EnumStatus.ACTIVE);
      ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING)
          .withIgnoreCase("status");
      Example<Tenant> example = Example.of(filter, matcher);
      count = tenantDAO.count(example);
      return count;
    } catch (DataException de) {
      throw new ApplicationException(TNT_SVC_004, de.getLocalizedMessage());
    }
  }

  /**
   * @return
   * @throws ApplicationException
   */
  @Override
  public long getInActiveTenantsCount() throws ApplicationException {
    long count = 0;
    try {
      Tenant filter = new Tenant();
      filter.setStatus(EnumStatus.INACTIVE);
      ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING)
          .withIgnoreCase("status");
      Example<Tenant> example = Example.of(filter, matcher);
      count = tenantDAO.count(example);
      return count;
    } catch (DataException de) {
      throw new ApplicationException(TNT_SVC_004, de.getLocalizedMessage());
    }
  }

  /**
   * @return
   * @throws ApplicationException
   */
  @Override
  public long getTotalTenantsCount() throws ApplicationException {
    long count = 0;
    try {
      count = tenantDAO.count();
      return count;
    } catch (DataException de) {
      throw new ApplicationException(TNT_SVC_004, de.getLocalizedMessage());
    }
  }

  /**
   * @return
   * @throws ApplicationException
   */
  @Override
  public long getExpiringTenantsCount() throws ApplicationException {
    try {
      DateTime currentDate = new DateTime();
      return subscriptionDAO.getSubscriptionExpiringCount(EnumStatus.ACTIVE, currentDate.toDate(),
          currentDate.plusDays(SUB_EXPIRING_DAYS).toDate());
    } catch (DataAccessException da) {
      throw new ApplicationException(TNT_SVC_004, da.getLocalizedMessage());
    }
  }

  @Override
  public DashBoardTenantsCountsVO getTenantsCountForDashBoard() throws ApplicationException {
    DashBoardTenantsCountsVO dashBoardTenantsCountsVO = new DashBoardTenantsCountsVO();
    try {
      dashBoardTenantsCountsVO.setActiveTenantsCount(getActiveTenantsCount());
      dashBoardTenantsCountsVO.setInActiveTenantsCount(getInActiveTenantsCount());
      dashBoardTenantsCountsVO.setTotalTenantsCount(getTotalTenantsCount());
      dashBoardTenantsCountsVO.setExpiringTenantsCount(getExpiringTenantsCount());
      return dashBoardTenantsCountsVO;
    } catch (ApplicationException e) {
      throw e;
    }
  }

  /**
   * @see com.lucid.tenant.TenantService#retrieveResent5Tenants()
   */
  @Override
  public List<TenantVO> retrieveResent5Tenants() throws ApplicationException {
    List<TenantVO> tenantList = null;
    try {
      List<Tenant> tenants = tenantDAO.fetchRecent5Tenants();
      if (tenants.isEmpty()) {
        LOGGER.info("No tenants found in the search");
        return Collections.emptyList();
      }
      TenantMapper mapper = Mappers.getMapper(TenantMapper.class);
      tenantList = mapper.toVOList(tenants);
    } catch (Exception e) {
      LOGGER.error(TNT_SVC_004, e);
      throw new ApplicationException(TNT_SVC_004, "Unable to retrieve tenants in the system");
    }
    return tenantList;
  }

  @Override
  public long getActiveTenantsCount(Date startDate, Date endDate) {
    return tenantDAO.getActiveTenantsCount(startDate, endDate, EnumStatus.ACTIVE);
  }

  @Override
  public DashBoardTenantsCountsVO getActiveTenantsGraphForDashBoard(int year) {
    int newYear = year;
    int oldYear = year - 1;
    Map<String, Map<String, Long>> tenantsCountMonthWise = new HashMap<>();
    for (int i = 0; i < 12; i++) {
      Map<String, Long> tenantCountForMonth = new HashMap<>();
      SimpleDateFormat format = new SimpleDateFormat("MMM");
      // for new year month wise
      YearMonth newYearMonth = YearMonth.of(newYear, i + 1);
      LocalDateTime startOfDay = newYearMonth.atDay(1).atStartOfDay();
      Date startDate = Date.from(startOfDay.atZone(java.time.ZoneId.systemDefault()).toInstant());
      LocalDateTime endOfDay = newYearMonth.atEndOfMonth().atTime(23, 59, 59);
      Date endDate = Date.from(endOfDay.atZone(java.time.ZoneId.systemDefault()).toInstant());
      tenantCountForMonth.put(NEW, getActiveTenantsCount(startDate, endDate));

      // for old year month wise
      YearMonth oldYearMonth = YearMonth.of(oldYear, i + 1);
      startOfDay = oldYearMonth.atDay(1).atStartOfDay();
      startDate = Date.from(startOfDay.atZone(java.time.ZoneId.systemDefault()).toInstant());
      endOfDay = oldYearMonth.atEndOfMonth().atTime(23, 59, 59);
      endDate = Date.from(endOfDay.atZone(java.time.ZoneId.systemDefault()).toInstant());
      tenantCountForMonth.put(OLD, getActiveTenantsCount(startDate, endDate));
      tenantsCountMonthWise.put(format.format(startDate), tenantCountForMonth);
    }
    DashBoardTenantsCountsVO dashBoardTenantsCountsVO = new DashBoardTenantsCountsVO();
    dashBoardTenantsCountsVO.setTenantsCountsForGraph(tenantsCountMonthWise);
    return dashBoardTenantsCountsVO;
  }

  // activateOrInActiveTenant
  @Override
  public String activateOrInActiveTenant(Long tenantID, boolean activate)
      throws ApplicationException {
    Optional<Tenant> tenant = tenantDAO.findById(tenantID);
    if (tenant.isPresent()) {
      try {
        if (activate) {
          tenantDAO.updateStatus(tenantID, 1);
          subscriptionDAO.updateStatus(tenantID, 1);
          return "Tenant " + tenantID + " Activated Successfully";
        } else {
          tenantDAO.updateStatus(tenantID, 0);
          subscriptionDAO.updateStatus(tenantID, 0);
          return "Tenant " + tenantID + " InActivated Successfully";
        }
      } catch (Exception e) {
        throw new ApplicationException(TNT_SVC_004, e.getLocalizedMessage());
      }
    }
    throw new ApplicationException(TNT_SVC_000, "Tenant Not Found With " + tenantID);
  }

  // EditTenant

  /**
   * @see com.lucid.tenant.TenantService#updateTenant(com.lucid.tenant.data.TenantVO)
   */
  @Override
  public TenantVO updateTenant(TenantVO tenantVO) throws ApplicationException {
    TenantVO result = null;
    try {
      Optional<Tenant> optionalTenant = tenantDAO.findById(tenantVO.getTenantID());
      if (!optionalTenant.isPresent()) {
        throw new ApplicationException(TNT_SVC_000,
            "Tenant not found with ID " + tenantVO.getTenantID());
      }
      TenantMapper mapper = Mappers.getMapper(TenantMapper.class);
      Tenant tenant = mapper.toEntity(tenantVO);
      tenant.setUpdatedDt(Calendar.getInstance().getTime());
      tenantDAO.save(tenant);
      result = mapper.toVO(tenant);
    } catch (Exception e) {
      throw new ApplicationException(TNT_SVC_005, e.getLocalizedMessage());
    }
    return result;
  }

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
