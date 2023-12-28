package com.lucid.subscription.criteria;

import com.lucid.subscription.entity.AuditLog;
import com.lucid.util.ServiceUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository(AuditLogCriteriaImpl.CUSTOM_REPOSITORY)
public class AuditLogCriteriaImpl implements AuditLogCriteria {

    public static final String  CUSTOM_REPOSITORY = "auditLogCriteria";

    public static final String SORT = "sort";

    @Autowired
    private EntityManager entityManager;

    @Override
    public  Page<AuditLog> findByCriteria(Map<String, Object> filterData) throws Exception {
        try{
            Pageable pageable = ServiceUtils.getPageableObject(filterData);
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<AuditLog> query = builder.createQuery(AuditLog.class);
            Root<AuditLog> root = query.from(AuditLog.class);
            List<Predicate> predicates = new ArrayList<>();
            for (Map.Entry<String, Object> entry : filterData.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    predicates.add(builder.like(root.get(key), "%" + value + "%"));
                }
            }
            Predicate finalPredicate = builder.and(predicates.toArray(new Predicate[predicates.size()]));
            query.where(finalPredicate);
            if(filterData.containsKey(SORT)){
                Sort sort = (Sort) filterData.get(SORT);
                if (sort != null) {
                    List<Order> orders = new ArrayList<>();
                    for (Sort.Order sortOrder : sort) {
                        if (sortOrder.getDirection() == Sort.Direction.ASC) {
                            orders.add(builder.asc(root.get(sortOrder.getProperty())));
                        } else {
                            orders.add(builder.desc(root.get(sortOrder.getProperty())));
                        }
                    }
                    query.orderBy(orders);
                }
            }
            TypedQuery<AuditLog> typedQuery = entityManager.createQuery(query);
            typedQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
            typedQuery.setMaxResults(pageable.getPageSize());

            CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
            countQuery.select(builder.count(countQuery.from(AuditLog.class)));
            countQuery.where(finalPredicate);
            Long totalCount = entityManager.createQuery(countQuery).getSingleResult();

            Page<AuditLog> page = new PageImpl<>(typedQuery.getResultList(), pageable, totalCount);
            return page;
        }
        catch (Exception e){
            throw  e;
        }
    }

}
