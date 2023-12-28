package com.lucid.subscription.criteria;

import com.lucid.core.BaseCriteria;
import com.lucid.subscription.entity.AuditLog;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface AuditLogCriteria extends BaseCriteria {
     Page<AuditLog> findByCriteria(Map<String,Object> filterData) throws Exception;
}
