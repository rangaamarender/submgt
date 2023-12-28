package com.lucid.subscription;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.lucid.core.base.BaseService;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.data.PromotionData;
import com.lucid.subscription.data.PromotionVO;

public interface PromotionService extends BaseService {

    PromotionVO createPromotion(PromotionData promotionData) throws ApplicationException;

    PromotionVO retrievePromotion(String promotionID) throws ApplicationException;

    Page<PromotionVO> retrieveAllPromotions(Map<String, Object> filterData) throws ApplicationException;

    /**
     * @param page
     * @param pageSize
     * @return
     * @throws ApplicationException
     */
    Page<PromotionVO> retrieveAllPromotions(int page, int pageSize) throws ApplicationException;

    String changeStatusOfPromotion(String promotionID, Integer status) throws ApplicationException;

}
