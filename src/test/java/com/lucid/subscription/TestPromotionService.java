package com.lucid.subscription;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.lucid.base.test.BaseTransactionTest;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.data.PromotionData;
import com.lucid.subscription.data.PromotionVO;

public class TestPromotionService extends BaseTransactionTest {

    @Autowired
    private PromotionService promotionService;

    @Test
    public void testCreatePromotion() throws ApplicationException {
        PromotionData promotionData = new PromotionData();
        promotionData.setName("TestPromotion");
        promotionData.setPromotionType(1);
        promotionData.setSalesStartDate(new Date());
        promotionData.setCreatedBy(FAKER.internet().emailAddress());
        promotionData.setPromotionStatus(3);
        promotionData.setPromotionAmount(new BigDecimal(50));
        PromotionVO promotion = promotionService.createPromotion(promotionData);
        Assertions.assertNotNull(promotion.getPromotionID());
    }

    @Test
    public void testRetrievePromotion() {
        String promotionId = UUID.randomUUID().toString();
        try {
            PromotionVO promotionVO = promotionService.retrievePromotion(promotionId);
            Assertions.assertNotNull(promotionVO.getPromotionID());
        } catch (Exception e) {
            Assertions.assertEquals("Promotion not found with " + promotionId, e.getLocalizedMessage());
        }
    }

    @Test
    public void testRetrieveAllPromotions() {
        try {
            Page<PromotionVO> promotionVOPage = promotionService.retrieveAllPromotions(0, 10);
            Assertions.assertNotNull(promotionVOPage.getPageable());
            Assertions.assertNotNull(promotionVOPage.getContent());
        } catch (Exception e) {
            Assertions.assertNotNull(e.getLocalizedMessage());
        }
    }

    @Test
    public void testChangeStatus() {
        String promotionId = UUID.randomUUID().toString();
        try {
            String result = promotionService.changeStatusOfPromotion(promotionId, 1);
            Assertions.assertEquals("Promotion status updated successfully", result);
        } catch (Exception e) {
            Assertions.assertNotNull(e);
        }

    }

}
