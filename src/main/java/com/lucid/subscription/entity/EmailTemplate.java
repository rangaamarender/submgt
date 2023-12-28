/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.entity;

import com.lucid.core.entity.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author sgutti
 * @date 04-Feb-2023 9:51:02 pm
 */
@Entity
@Table(name = EmailTemplate.TABLE_NAME)
public class EmailTemplate extends AuditableEntity {

    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -6779218829188132502L;
    public static final String TABLE_NAME = "email_template";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "email_tempalte_code", nullable = false, length = 75)
    private String emailTemplateCode;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "subject", nullable = false, length = 400)
    private String subject;

    // TODOD Chandu Lob is commented for H2 need to revisit
    // @Lob
    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "status", nullable = false)
    private Integer status;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>EmailTemplate</code>
     */
    public EmailTemplate() {
        super();
    }
    // ---------------------------------------------------------- Public Methods

    /**
     * @return Returns the emailTemplateCode.
     */
    public String getEmailTemplateCode() {
        return emailTemplateCode;
    }

    /**
     * @param emailTemplateCode
     *            The emailTemplateCode to set.
     */
    public void setEmailTemplateCode(String emailTemplateCode) {
        this.emailTemplateCode = emailTemplateCode;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the subject.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject
     *            The subject to set.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return Returns the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            The message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return Returns the status.
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     *            The status to set.
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
