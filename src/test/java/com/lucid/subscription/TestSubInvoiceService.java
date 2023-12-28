/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mock.web.MockMultipartFile;

import com.lucid.base.test.BaseTransactionTest;
import com.lucid.core.constants.EnumStatus;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.constants.EnumSubUserContactType;
import com.lucid.subscription.dao.SubContactDAO;
import com.lucid.subscription.dao.SubscriptionDAO;
import com.lucid.subscription.data.SubInvoiceVO;
import com.lucid.subscription.entity.SubContact;
import com.lucid.subscription.entity.SubInvoice;
import com.lucid.subscription.entity.Subscription;
import com.lucid.tenant.dao.TenantDAO;
import com.lucid.tenant.entity.Tenant;
import com.lucid.util.GenerateKeys;

/**
 * @author sgutti
 * @date Aug 28, 2022 11:59:14 AM
 */
public class TestSubInvoiceService extends BaseTransactionTest {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private SubInvoiceService subInvoiceService;

    @Autowired
    private TenantDAO tenantDAO;

    @Autowired
    private SubscriptionDAO subscriptionDAO;

    @Autowired
    private SubContactDAO subContactDAO;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>TestSubInvoiceService</code>
     */
    public TestSubInvoiceService() {
        super();
    }

    // ---------------------------------------------------------- Public Methods

    public void testCreateInvoice() throws ApplicationException {
        subInvoiceService.createInvoice(3l);
    }

    public void retrieveRecent5Invoices() throws ApplicationException {
        for (int i = 0; i < 10; i++) {
            SubInvoice invoice = new SubInvoice();
            invoice.setInvoiceDt(new Date());
            invoice.setInvoiceStatus(1);
            invoice.setInvoiceAmt(new BigDecimal(500));
            invoice.setInvoiceDueDt(new Date());
            invoice.setSubscriptionID(1L);
        }
        List<SubInvoiceVO> subInvoiceVOList = subInvoiceService.retrieveRecent5Invoices();
        Assertions.assertEquals(5, subInvoiceVOList.size());
    }

    public void resendInvoice() {
        Tenant tenant = new Tenant();
        tenant.setCompanyName(FAKER.company().name());
        tenant.setCreatedDt(new Date());
        tenant.setStatus(EnumStatus.ACTIVE);
        tenant.setCreatedBy(FAKER.internet().emailAddress());
        tenant.setExternalCode(GenerateKeys.generateTenantExternalCode());
        tenantDAO.save(tenant);

        Subscription subscription = new Subscription();
        subscription.setTenantID(tenant.getTenantID());
        subscription.setTrailDays(15);
        subscription.setPhase(1);
        subscription.setStatus(EnumStatus.ACTIVE);
        subscription.setCreatedDt(new Date());
        subscription.setAcctNbr(GenerateKeys.generateSubAcctNbr());
        DateTime currentDate = new DateTime();
        subscription.setStartDt(currentDate.toDate());
        subscription.setEndDt(currentDate.plusDays(30).toDate());
        subscriptionDAO.save(subscription);

        SubContact contact = new SubContact();
        contact.setContactType(EnumSubUserContactType.ADMIN);
        contact.setEmailID(FAKER.internet().emailAddress());
        contact.setFirstName(FAKER.name().firstName());
        contact.setPhoneNbr("0000000000");
        contact.setLastName(FAKER.name().lastName());
        contact.setSubcriptionID(subscription.getSubscriptionID());
        subContactDAO.save(contact);
        String filename = "example";
        String content = "This is a test file.";
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        try {
            subInvoiceService.resendInvoice(subscription.getSubscriptionID(), new MockMultipartFile(filename, bytes));
        } catch (Exception e) {
            Assertions.assertEquals("Invalid file, File should be PDF", e.getLocalizedMessage());
        }
    }

    @Test
    public void testRetrieveInvoices() {
        Map<String, Object> filterData = new HashMap<>();
        filterData.put("page", 1);
        filterData.put("size", 10);
        try {
            Page<SubInvoiceVO> subInvoiceVOPage = subInvoiceService.retrieveInvoices(filterData);
            Assertions.assertEquals(0, subInvoiceVOPage.getPageable().getPageNumber());
            Assertions.assertEquals(10, subInvoiceVOPage.getPageable().getPageSize());
        } catch (ApplicationException e) {
            Assertions.assertEquals(SubInvoiceServiceImpl.ERROR_SUB_INV_0005, e.getErrorCode());
        }
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
