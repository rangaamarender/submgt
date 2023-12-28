package com.lucid.subscription.dao;

import com.lucid.subscription.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogDAO extends JpaRepository<AuditLog,String> {
}
