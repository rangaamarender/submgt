/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.tenant;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.AuditLogService;
import com.lucid.subscription.SubscriptionService;
import com.lucid.subscription.data.SubscriptionData;
import com.lucid.tenant.data.TenantVO;

/**
 * @author sgutti
 * @date 18-Dec-2022 2:08:48 am
 */
@RestController
@RequestMapping
public class TenantController {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private TenantService tenantService;
    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private AuditLogService auditLogService;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>TenantController</code>
     */
    public TenantController() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return
     */
    @GetMapping(path = "/tenants")
    public ResponseEntity<?> getTenants(int page, int pageSize) {
        try {
            Page<TenantVO> result = tenantService.retrieveAllTenants(page, pageSize);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("unable to response");
        }
    }

    /**
     * @param tenantID
     * @return
     */
    @GetMapping(path = "/tenant/{tenantID}")
    public TenantVO getTenant(@PathVariable
    long tenantID) {
        TenantVO result = null;
        try {
            result = tenantService.retrieveTenant(tenantID);
        } catch (ApplicationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;

    }

    /**
     * @param subscriptionData
     * @return
     */
    @PostMapping(path = "/createTenant")
    public ResponseEntity<String> createTenant(@RequestBody
    SubscriptionData subscriptionData) {
        try {
            subscriptionService.createSubscription(subscriptionData);
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Success");
    }

    /**
     * @return
     */
    @GetMapping("getTenantsCountForDashBoard")
    public ResponseEntity<Object> getTenantsCountForDashBoard() {
        try {
            return ResponseEntity.ok(tenantService.getTenantsCountForDashBoard());
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getTenantsCountForDashBoardGraph/{year}")
    public ResponseEntity<Object> getTenantsCountForDashBoardGraph(@PathVariable
    int year) {
        return ResponseEntity.ok(tenantService.getActiveTenantsGraphForDashBoard(year));
    }

    @GetMapping("getRecent5Tenants")
    public ResponseEntity<Object> getRecent5Tenants() {
        try {
            return ResponseEntity.ok(tenantService.retrieveResent5Tenants());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }

    }

    // activateOrDeActivateTenant

    @PatchMapping("/activateOrDeActivateTenant/{tenantID}/{activate}")
    public ResponseEntity<Object> activateOrDeActivateTenant(@PathVariable
    Long tenantId,
                                                             @PathVariable
                                                             boolean activate) {
        try {
            return ResponseEntity.ok(tenantService.activateOrInActiveTenant(tenantId, activate));
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // updateTenantDetails
    @PatchMapping("/updateTenantDetails/{tenantID}")
    public ResponseEntity<Object> editTenant(@RequestBody
    TenantVO updatedTenant) {
        try {
            TenantVO tenant = tenantService.updateTenant(updatedTenant);
            return ResponseEntity.ok(tenant);
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // change subscription
    @PatchMapping("/subscription/{subscriptionId}")
    public ResponseEntity<Object> updateSubscriptionPlan(@PathVariable
    Long subscriptionId,
                                                         @RequestParam
                                                         String newPlanId) {
        try {
            return ResponseEntity
                    .ok(subscriptionService.updateSubscriptionPlan(subscriptionId, newPlanId));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getAuditLogs")
    public ResponseEntity<Object> fetchAuditLogs(@RequestBody
    Map<String, Object> filterData) {
        try {
            return ResponseEntity.ok(auditLogService.retrieveAllAuditLogs(filterData));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
