package com.lucid.subscription.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.EmailTemplateService;
import com.lucid.subscription.entity.EmailTemplate;

@RestController
@RequestMapping
public class EmailTemplateCntrl {

  @Autowired
  private EmailTemplateService emailTemplateService;

  @PutMapping("updateEmailTemplate")
  public ResponseEntity<Object> updateEmailTemplate(@PathVariable String emailTemplateCode,
      @RequestBody EmailTemplate emailTemplate) {
    try {
      return ResponseEntity
          .ok(emailTemplateService.updateEmailTemplate(emailTemplateCode, emailTemplate));
    } catch (ApplicationException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("sendEmail")
  public ResponseEntity<Object> sendEmail(@RequestParam String toEmail,
      @RequestParam String emailTemplateCode) {
    try {
      return ResponseEntity.ok(emailTemplateService.testSendEmail(toEmail, emailTemplateCode));
    } catch (ApplicationException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
