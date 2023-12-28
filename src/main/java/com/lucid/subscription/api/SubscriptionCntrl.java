/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucid.core.exception.ApplicationException;
import com.lucid.payment.dto.CreditCardDTO;
import com.lucid.subscription.SubscriptionService;
import com.lucid.subscription.data.SignupTrackerVO;
import com.lucid.subscription.data.SubscriptionData;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author sgutti
 * @date 03-Feb-2023 11:13:29 pm
 */
@Tag(name = "Subscription", description = "Endpoints for Subscription operations")
@RestController
@RequestMapping
public class SubscriptionCntrl {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private SubscriptionService subscriptionService;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>SubscriptionCntrl</code>
     */
    public SubscriptionCntrl() {
        super();
    }

    // ---------------------------------------------------------- Public Methods

    /**
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping(path = "/subscriptions")
    public ResponseEntity<?> getSubscriptions(int page, int pageSize) {
        try {
            return ResponseEntity.ok(subscriptionService.retrieveAll(page, pageSize));
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param subscriptionID
     * @return
     */
    @GetMapping(path = "/paymentMethods/{subscriptionID}")
    public ResponseEntity<?> getPaymentMethods(@PathVariable
    long subscriptionID) {
        try {
            return ResponseEntity.ok(subscriptionService.retrievePaymentMethods(subscriptionID));
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param tenantID
     * @return
     */
    @GetMapping(path = "/subscription/{tenantID}")
    public ResponseEntity<?> getSubscription(@PathVariable
    long tenantID) {
        try {
            return ResponseEntity.ok(subscriptionService.retrieveSubscription(tenantID));
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param tenantID
     * @param creditCardDTO
     * @return
     */
    @PostMapping(path = "/paymentMethod/{subscriptionID}")
    public ResponseEntity<?> addPaymentMethod(@PathVariable
    long subscriptionID,
                                              @RequestBody
                                              CreditCardDTO creditCardDTO) {
        try {
            return ResponseEntity.ok(subscriptionService.addPaymentMethod(subscriptionID, creditCardDTO));
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param signupTrackerVO
     * @return
     */
    @PostMapping(path = "/signup")
    public ResponseEntity<?> signup(@RequestBody
    SignupTrackerVO signupTrackerVO) {
        try {
            return ResponseEntity.ok(subscriptionService.signup(signupTrackerVO));
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param subscriptionData
     * @return
     */
    @PostMapping(path = "/completeSignup")
    public ResponseEntity<?> completeSignup(@RequestBody
    SubscriptionData subscriptionData) {
        try {
            return ResponseEntity.ok(subscriptionService.createTenant(subscriptionData));
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/verifySignup/{trackerCode}")
    public ResponseEntity<?> verifySignup(@PathVariable
    String trackerCode) {
        try {
            return ResponseEntity.ok(subscriptionService.verifySignup(trackerCode));
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.BAD_REQUEST);
        }
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
