package com.lucid.subscription.criteria;

import com.lucid.core.BaseCriteria;
import com.lucid.subscription.entity.AuditLog;
import com.lucid.subscription.entity.Note;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface NoteCriteria extends BaseCriteria {
    Page<Note> findByCriteria(Map<String,Object> filterData) throws Exception;
}
