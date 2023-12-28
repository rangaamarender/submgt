package com.lucid.subscription;

import com.lucid.core.base.BaseService;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.entity.AuditLog;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface AuditLogService extends BaseService {
    void saveAuditLog(AuditLog auditLog) throws ApplicationException;

    Page<AuditLog> retrieveAllAuditLogs(Map<String,Object> filterData) throws ApplicationException;
}
