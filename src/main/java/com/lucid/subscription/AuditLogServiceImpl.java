package com.lucid.subscription;

import com.lucid.core.BaseCriteria;
import com.lucid.core.base.BaseServiceImpl;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.criteria.AuditLogCriteria;
import com.lucid.subscription.dao.AuditLogDAO;
import com.lucid.subscription.entity.AuditLog;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component(AuditLogServiceImpl.SERVICE_NAME)
public class AuditLogServiceImpl extends BaseServiceImpl implements AuditLogService {

    public static final  String SERVICE_NAME="auditLogService";

    public static final  String ERROR_AUDIT_LOG_0000="ERROR_AUDIT_LOG_0000";
    public static final  String ERROR_AUDIT_LOG_0001="ERROR_AUDIT_LOG_0001";
    public static final  String ERROR_AUDIT_LOG_0002="ERROR_AUDIT_LOG_0002";

    @Autowired
    private AuditLogDAO auditLogDAO;

    @Autowired
    private AuditLogCriteria auditLogCriteria;

    @Override
    public void saveAuditLog(AuditLog auditLog) throws ApplicationException {
        try {
            auditLogDAO.save(auditLog);
        }
        catch (DataAccessException | PersistenceException e){
            throw new ApplicationException(ERROR_AUDIT_LOG_0000,e.getLocalizedMessage(),e);
        }
    }

    @Override
    public Page<AuditLog> retrieveAllAuditLogs(Map<String, Object> filterData) throws ApplicationException {
        try {
            return auditLogCriteria.findByCriteria(filterData);
        }
        catch (Exception e){
            throw new ApplicationException(ERROR_AUDIT_LOG_0001,e.getLocalizedMessage(),e);
        }
    }

}
