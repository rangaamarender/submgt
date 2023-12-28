package com.lucid.subscription;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.lucid.core.base.BaseServiceImpl;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.dao.PromotionDAO;
import com.lucid.subscription.data.PromotionData;
import com.lucid.subscription.data.PromotionVO;
import com.lucid.subscription.entity.Promotion;
import com.lucid.subscription.mapper.PromotionMapper;
import com.lucid.util.ServiceUtils;

@Component(PromotionsServiceImpl.SERVICE_NAME)
public class PromotionsServiceImpl extends BaseServiceImpl implements PromotionService {

    public static final String SERVICE_NAME = "PromotionsService";
    public static final Logger LOGGER = LoggerFactory.getLogger(PromotionsServiceImpl.SERVICE_NAME);

    public static final String ERROR_PROMOTION_0000 = "ERROR_PROMOTION_0000";
    public static final String ERROR_PROMOTION_0001 = "ERROR_PROMOTION_0001";
    public static final String ERROR_PROMOTION_0002 = "ERROR_PROMOTION_0002";
    public static final String ERROR_PROMOTION_0003 = "ERROR_PROMOTION_0003";
    public static final String ERROR_PROMOTION_0004 = "ERROR_PROMOTION_0004";
    public static final String ERROR_PROMOTION_0005 = "ERROR_PROMOTION_0005";

    @Autowired
    private PromotionDAO promotionDAO;

    @Override
    public PromotionVO createPromotion(PromotionData promotionData) throws ApplicationException {
        try {
            Promotion promotion = initializePromotion(promotionData);
            promotionDAO.save(promotion);
            PromotionMapper mapper = Mappers.getMapper(PromotionMapper.class);
            return mapper.toVO(promotion);
        } catch (Exception e) {
            throw new ApplicationException(ERROR_PROMOTION_0000, e.getLocalizedMessage());
        }
    }

    @Override
    public PromotionVO retrievePromotion(String promotionID) throws ApplicationException {
        try {
            Optional<Promotion> optionalPromotion = promotionDAO.findById(promotionID);
            if (optionalPromotion.isPresent()) {
                PromotionMapper mapper = Mappers.getMapper(PromotionMapper.class);
                return mapper.toVO(optionalPromotion.get());
            } else {
                throw new ApplicationException(ERROR_PROMOTION_0001, "Promotion not found with " + promotionID);
            }
        } catch (Exception e) {
            throw new ApplicationException(ERROR_PROMOTION_0001, e.getLocalizedMessage(), e);
        }
    }

    @Override
    public Page<PromotionVO> retrieveAllPromotions(Map<String, Object> filterData) throws ApplicationException {
        Pageable pageable = ServiceUtils.getPageableObject(filterData);
        try {
            Page<Promotion> promotions = promotionDAO.findAll(pageable);
            List<Promotion> promotionList = promotions.getContent();
            List<PromotionVO> promotionVOList = new ArrayList<>();
            if (!promotionList.isEmpty()) {
                PromotionMapper promotionMapper = Mappers.getMapper(PromotionMapper.class);
                promotionVOList = promotionMapper.toVOList(promotions.getContent());
            }
            return new PageImpl<>(promotionVOList, promotions.getPageable(), promotions.getTotalElements());
        } catch (Exception e) {
            throw new ApplicationException(ERROR_PROMOTION_0002, e.getLocalizedMessage(), e);
        }
    }

    /**
     * @see com.lucid.subscription.PromotionService#retrieveAllPromotions(int,
     *      int)
     */
    @Override
    public Page<PromotionVO> retrieveAllPromotions(int page, int pageSize) throws ApplicationException {
        try {
            Pageable pageable = PageRequest.of(page, pageSize);
            Page<Promotion> promotions = promotionDAO.findAll(pageable);
            List<Promotion> promotionList = promotions.getContent();
            List<PromotionVO> promotionVOList = new ArrayList<>();
            if (!promotionList.isEmpty()) {
                PromotionMapper promotionMapper = Mappers.getMapper(PromotionMapper.class);
                promotionVOList = promotionMapper.toVOList(promotions.getContent());
            }
            return new PageImpl<>(promotionVOList, promotions.getPageable(), promotions.getTotalElements());
        } catch (Exception e) {
            throw new ApplicationException(ERROR_PROMOTION_0002, e.getLocalizedMessage(), e);
        }
    }

    @Override
    public String changeStatusOfPromotion(String promotionID, Integer status) throws ApplicationException {
        try {
            Optional<Promotion> optionalPromotion = promotionDAO.findById(promotionID);
            if (optionalPromotion.isPresent()) {
                promotionDAO.updateStatus(promotionID, status);
                return "Promotion status updated successfully";
            }
            throw new ApplicationException(ERROR_PROMOTION_0002, "promotion not fount with " + promotionID);
        } catch (Exception e) {
            throw new ApplicationException(ERROR_PROMOTION_0002, e.getLocalizedMessage(), e);
        }
    }

    private Promotion initializePromotion(PromotionData promotionData) {
        Promotion promotion = new Promotion();
        promotion.setName(promotionData.getName());
        promotion.setPromotionType(promotionData.getPromotionType());
        promotion.setPromotionAmount(promotionData.getPromotionAmount());
        promotion.setDescription(promotionData.getDescription());
        promotion.setCreatedBy(promotionData.getCreatedBy());
        promotion.setPromotionStatus(promotionData.getPromotionStatus());
        promotion.setSalesStartDate(promotionData.getSalesStartDate());
        promotion.setSalesEndDate(promotion.getSalesEndDate());
        promotion.setCreatedDt(new Date());
        return promotion;
    }

}
