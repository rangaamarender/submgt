package com.lucid.subscription.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.lucid.subscription.PromotionService;
import com.lucid.subscription.data.PromotionData;

@RestController
@RequestMapping
public class PromotionCntrl {

    @Autowired
    private PromotionService promotionService;

    @PostMapping("/createPromotion")
    public ResponseEntity<Object> createPromotion(@RequestBody
    PromotionData promotionData) {
        try {
            return ResponseEntity.ok(promotionService.createPromotion(promotionData));
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/retrievePromotion/{promotionID}")
    public ResponseEntity<Object> retrievePromotion(@PathVariable
    String promotionID) {
        try {
            return ResponseEntity.ok(promotionService.retrievePromotion(promotionID));
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param filterData
     * @return
     */
    @GetMapping("/promotions")
    public ResponseEntity<Object> retrieveAllPromotions(
                                                        @RequestParam
                                                        Map<String, Object> filterData) {
        try {
            return ResponseEntity.ok(promotionService.retrieveAllPromotions(filterData));
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/retrievePromotions")
    public ResponseEntity<Object> retrieveAllPromotions(@RequestParam
    int page,
                                                        @RequestParam
                                                        int pageSize) {
        try {
            return ResponseEntity.ok(promotionService.retrieveAllPromotions(page, pageSize));
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/updateStatus/{promotionID}/{status}")
    public ResponseEntity<Object> updateStatus(@PathVariable
    String promotionId,
                                               @PathVariable
                                               Integer status) {
        try {
            return ResponseEntity.ok(promotionService.changeStatusOfPromotion(promotionId, status));
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
