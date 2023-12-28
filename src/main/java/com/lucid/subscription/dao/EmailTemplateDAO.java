package com.lucid.subscription.dao;

import com.lucid.subscription.entity.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailTemplateDAO extends JpaRepository<EmailTemplate,String> {
}
