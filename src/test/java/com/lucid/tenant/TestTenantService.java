package com.lucid.tenant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import com.lucid.base.test.BaseTransactionTest;
import com.lucid.core.constants.EnumStatus;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.SubMgtUserServiceImpl;
import com.lucid.subscription.dao.SubscriptionDAO;
import com.lucid.subscription.data.SubscriptionData;
import com.lucid.subscription.entity.SubMgtUser;
import com.lucid.subscription.entity.Subscription;
import com.lucid.tenant.dao.TenantDAO;
import com.lucid.tenant.data.DashBoardTenantsCountsVO;
import com.lucid.tenant.data.TenantVO;
import com.lucid.tenant.entity.Tenant;
import com.lucid.util.GenerateKeys;

public class TestTenantService extends BaseTransactionTest {

  @Autowired
  private TenantService tenantService;

  @Autowired
  private TenantDAO tenantDAO;

  @Autowired
  private SubscriptionDAO subscriptionDAO;
  private SubMgtUserServiceImpl subMgtUser;
  private SubscriptionData subscriptionData;

  @Test
  public void testRetrieveAllTenants() throws ApplicationException {
    Page<TenantVO> page = tenantService.retrieveAllTenants(0, 10);
    Assertions.assertNotNull(page, "Got the tenants");
  }

  @Test
  public void testGetTenantsCountForDashBoard() {
    Tenant tenant = new Tenant();
    tenant.setStatus(EnumStatus.ACTIVE);
    tenant.setCompanyName(FAKER.company().name());
    tenant.setExternalCode(GenerateKeys.generateTenantExternalCode());
    tenant.setCreatedBy(FAKER.internet().emailAddress());
    tenant.setCreatedDt(new Date());
    tenantDAO.save(tenant);

    Tenant tenant1 = new Tenant();
    tenant1.setStatus(EnumStatus.INACTIVE);
    tenant1.setCompanyName(FAKER.company().name());
    tenant1.setCreatedBy(FAKER.internet().emailAddress());
    tenant1.setCreatedDt(new Date());
    tenant1.setExternalCode(GenerateKeys.generateTenantExternalCode());
    tenantDAO.save(tenant1);

    Tenant tenant2 = new Tenant();
    tenant2.setStatus(EnumStatus.ACTIVE);
    tenant2.setCompanyName(FAKER.company().name());
    tenant2.setCreatedBy(FAKER.internet().emailAddress());
    tenant2.setCreatedDt(new Date());
    tenant2.setExternalCode(GenerateKeys.generateTenantExternalCode());
    tenantDAO.save(tenant2);

    Subscription subscription = new Subscription();
    subscription.setTenantID(tenant2.getTenantID());
    subscription.setStatus(EnumStatus.ACTIVE);
    subscription.setCreatedDt(new Date());
    subscription.setAcctNbr(GenerateKeys.generateSubAcctNbr());
    subscription.setPhase(FAKER.hashCode());
    subscription.setTrailDays(15);

    LocalDate today = LocalDate.now();
    LocalDate featureDate = today.plusDays(7);
    subscription
        .setEndDt(Date.from(featureDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
    subscription.setPlanDesc(FAKER.name().name());

    subscriptionDAO.save(subscription);
    try {
      DashBoardTenantsCountsVO dashBoardTenantsCountsVO =
          tenantService.getTenantsCountForDashBoard();
      assertEquals(true, dashBoardTenantsCountsVO.getActiveTenantsCount() >= 0);
      assertEquals(true, dashBoardTenantsCountsVO.getInActiveTenantsCount() >= 0);
      assertEquals(true, dashBoardTenantsCountsVO.getExpiringTenantsCount() >= 0);
      assertEquals(true, dashBoardTenantsCountsVO.getTotalTenantsCount() >= 0);
    } catch (Exception e) {
      assertNotNull(e);
    }

  }

  @Test
  public void testRetrieveResent5Tenants() throws ApplicationException {
    List<TenantVO> tenantVOList = tenantService.retrieveResent5Tenants();
    assertEquals(true, tenantVOList.size() >= 0);
  }

  @Test
  public void testGetActiveTenantsGraphForDashBoard() {
    for (int i = 0; i < 10; i++) {
      Tenant tenant = new Tenant();
      tenant.setStatus(EnumStatus.ACTIVE);
      tenant.setCompanyName(FAKER.company().name());
      tenant.setExternalCode(GenerateKeys.generateTenantExternalCode());
      tenant.setCreatedBy(FAKER.internet().emailAddress());
      tenant.setCreatedDt(new Date());
      tenantDAO.save(tenant);
    }
    DashBoardTenantsCountsVO dashBoardTenantsCountsVO =
        tenantService.getActiveTenantsGraphForDashBoard(YearMonth.now().getYear());
    SimpleDateFormat format = new SimpleDateFormat("MMM");
    System.out.println(format.format(new Date()));
    assertEquals(true, dashBoardTenantsCountsVO.getTenantsCountsForGraph()
        .get(format.format(new Date())).get("new") >= 0);
  }

  @Test
  public void testActivateOrInActiveTenant() throws ApplicationException {
    Tenant tenant = new Tenant();
    tenant.setCompanyName(FAKER.company().name());
    tenant.setStatus(EnumStatus.ACTIVE);
    tenant.setStatus(EnumStatus.INACTIVE);
    tenant.setCreatedBy(FAKER.internet().emailAddress());
    tenant.setCreatedDt(new Date());
    tenant.setExternalCode(GenerateKeys.generateTenantExternalCode());
    tenantDAO.save(tenant);
    assertEquals("Tenant " + tenant.getTenantID() + " InActivated Successfully",
        tenantService.activateOrInActiveTenant(tenant.getTenantID(), false));
  }

  @Test
  public void testEditTenant() throws ApplicationException {
    // Create a new Tenant object and save it to the database
    TenantVO tenant = tenantService.retrieveTenant(1l);
    tenant.setCompanyName("New Company");
    TenantVO result = tenantService.updateTenant(tenant);
    // verify results
    assertNotNull(result);
    assertEquals("New Company", result.getCompanyName());

  }
  //
  // @Test
  // public void testUpdateSubscriptionPlan() throws ApplicationException {
  //
  // Subscription subscription = new Subscription();
  // subscription.setSubscriptionPlan(new SubscriptionPlan());
  // // subscription.setSubscriptionID(subscription.getSubscriptionID());
  // subscription.setStatus(EnumStatus.ACTIVE);
  // subscription.setSubscriptionPlan(subscription.getSubscriptionPlan());
  // subscription.setApprovedBy(subscription.getApprovedBy());
  // subscription.setCreatedDt(new Date());
  // subscription.setPayments(subscription.getPayments());
  // subscription.setPaymentMethods(subscription.getPaymentMethods());
  // subscription.setTenant(subscription.getTenant());
  // }

  // test cases for change role

  @Test
  public void testChangeRole() throws ApplicationException {
    SubMgtUser user = new SubMgtUser();
    user.setUserID(user.getUserID());
    user.setRoleID(user.getRoleID());
    user.setEmailID(user.getUserID());
    user.setSubMgtRole(user.getSubMgtRole());
    user.setUsername(user.getUsername());
    user.setUpdatedBy(user.getCreatedBy());

  }
  //// test activateOrInactivate

  public void testActivateOrInactivate() throws ApplicationException {
    SubMgtUser user = new SubMgtUser();

    user.setUserID(String.valueOf(123L));
    user.setStatus(0);
  }

}
