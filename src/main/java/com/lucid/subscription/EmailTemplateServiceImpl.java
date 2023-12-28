package com.lucid.subscription;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.lucid.core.base.BaseServiceImpl;
import com.lucid.core.email.EmailContent;
import com.lucid.core.email.EmailHelper;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.dao.EmailTemplateDAO;
import com.lucid.subscription.entity.EmailTemplate;
import com.lucid.util.EnvConfig;

import jakarta.persistence.PersistenceException;

@Component(EmailTemplateServiceImpl.SERVICE_NAME)
public class EmailTemplateServiceImpl extends BaseServiceImpl
        implements EmailTemplateService {
    public static final String SERVICE_NAME = "EmailTemplateService";

    public static final String ERROR_EMAIL_TEMPLATE_0001 = "ERROR_EMAIL_TEMPLATE_0001";
    public static final String ERROR_EMAIL_TEMPLATE_0002 = "ERROR_EMAIL_TEMPLATE_0002";
    public static final String ERROR_EMAIL_TEMPLATE_0003 = "ERROR_EMAIL_TEMPLATE_0003";

    @Autowired
    private EmailTemplateDAO emailTemplateDAO;

    @Autowired
    private EmailHelper emailHelper;

    @Autowired
    private EnvConfig envConfig;

    @Override
    public String updateEmailTemplate(String emailTemplateCode,
                                      EmailTemplate emailTemplate)
            throws ApplicationException {
        try {
            Optional<EmailTemplate> emailTemplateOptional = emailTemplateDAO
                    .findById(emailTemplateCode);
            if (emailTemplateOptional.isPresent()) {
                EmailTemplate template = emailTemplateOptional.get();
                template.setName(emailTemplate.getName());
                template.setMessage(emailTemplate.getMessage());
                template.setStatus(emailTemplate.getStatus());
                template.setSubject(emailTemplate.getSubject());
                template.setUpdatedDt(Calendar.getInstance().getTime());
                emailTemplateDAO.save(template);
                return "Email Template updated successfully";
            }
            throw new ApplicationException(ERROR_EMAIL_TEMPLATE_0001,
                    "Template Not Found With " + emailTemplateCode);
        } catch (DataAccessException | PersistenceException e) {
            throw new ApplicationException(ERROR_EMAIL_TEMPLATE_0001,
                    e.getLocalizedMessage(), e);
        }
    }

    @Override
    public String testSendEmail(String toEmailId, String emailTemplateCode)
            throws ApplicationException {
        try {
            Optional<EmailTemplate> optionalEmailTemplate = emailTemplateDAO
                    .findById(emailTemplateCode);
            if (optionalEmailTemplate.isPresent()) {
                EmailTemplate template = optionalEmailTemplate.get();
                EmailContent emailContent = new EmailContent();
                emailContent.setToList(Arrays.asList(toEmailId));
                emailContent.setSubject(template.getSubject());
                emailContent.setBody(template.getMessage());
                emailContent.setFrom(envConfig.getNoreplyEmailAddress());
                emailHelper.sendEmail(emailContent);
            }
            throw new ApplicationException(ERROR_EMAIL_TEMPLATE_0001,
                    "Template Not Found With " + emailTemplateCode);
        } catch (Exception e) {
            throw new ApplicationException(ERROR_EMAIL_TEMPLATE_0001,
                    e.getLocalizedMessage(), e);
        }
    }

}
