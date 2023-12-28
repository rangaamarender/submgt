package com.lucid.subscription;

import com.lucid.core.base.BaseService;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.entity.EmailTemplate;

public interface EmailTemplateService extends BaseService {
    String updateEmailTemplate(String emailTemplateCode, EmailTemplate emailTemplate) throws ApplicationException;

    String testSendEmail(String toEmailId,String emailTemplateCode) throws ApplicationException;
}
