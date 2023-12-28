/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.core.email;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

/**
 * @author sgutti
 * @date Nov 6, 2018 11:59:17 PM
 */
@Component(value = EmailHelper.NAME)
public class EmailHelper {
  // --------------------------------------------------------------- Constants
  public static final String NAME = "emailHelper";
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Autowired
  private JavaMailSender mailSender;

  // private SendGrid sendGrid;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>EmailHelper</code>
   */
  private EmailHelper() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @param emailContent
   * @throws MessagingException
   */
  public void sendEmail(EmailContent emailContent) throws MessagingException {
    final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
    final MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, "UTF-8");
    msg.setTo(emailContent.getTo());
    msg.setFrom(emailContent.getFrom());
    msg.setSubject(emailContent.getSubject());
    msg.setText(emailContent.getBody(), true);
    if (emailContent.getCc() != null && emailContent.getCc().length > 0) {
      msg.setCc(emailContent.getCc());
    }
    mailSender.send(mimeMessage);
  }

  public void sendEmailWithAttachment(EmailContent emailContent, MultipartFile attachment)
      throws MessagingException, IOException {
    final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
    final MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true, "UTF-8");
    msg.setTo(emailContent.getTo());
    msg.setFrom(emailContent.getFrom());
    msg.setSubject(emailContent.getSubject());
    msg.setText(emailContent.getBody(), true);
    if (emailContent.getCc() != null && emailContent.getCc().length > 0) {
      msg.setCc(emailContent.getCc());
    }
    byte[] attachmentData = attachment.getBytes();
    ByteArrayResource mailAttachment = new ByteArrayResource(attachmentData);
    msg.addAttachment(attachment.getOriginalFilename(), mailAttachment);
    mailSender.send(mimeMessage);
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
