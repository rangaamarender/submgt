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
 * @date 09-Apr-2023 11:00:24 pm
 */
@Entity
@Table(name = DocumentDef.TABLE_NAME)
public class DocumentDef extends AuditableEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 2398403819851179062L;
    public static final String TABLE_NAME = "document_def";

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "doc_def_id", nullable = false, length = 75)
    private String documentDefID;

    // Signable,Uploaded,Monitor,Download
    @Column(name = "doc_type", nullable = false, length = 25)
    private String documentType;

    // Standard name given to the document name by system
    @Column(name = "doc_name", nullable = false, length = 50)
    private String documentName;

    // unique code for document referred in the system like W9-FORM etc
    @Column(name = "doc_internal_code", nullable = false, length = 25)
    private String documentInternalCode;

    // Document is active/inactive/discarded in the system
    @Column(name = "status", nullable = false)
    private Integer status;

    // Document is 1- Internal Only, 2 - Tenant Only, 3 - EndUser Only
    @Column(name = "doc_scope", nullable = false)
    private Integer documentScope;

    // Document can be access by WHOM
    @Column(name = "doc_accessablity", nullable = false)
    private Integer documentAccessability;

    // associated entity like EMPLOYEE,CONTRACT etc
    @Column(name = "related_type", nullable = false, length = 25)
    private String relatedType;

    // associated relatedSubType for an relatedType like W2C,C2C,1099
    @Column(name = "related_sub_type", nullable = true, length = 25)
    private String relatedSubType;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>DocumentDef</code>
     */
    public DocumentDef() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the documentDefID.
     */
    public String getDocumentDefID() {
        return documentDefID;
    }

    /**
     * @param documentDefID
     *            The documentDefID to set.
     */
    public void setDocumentDefID(String documentDefID) {
        this.documentDefID = documentDefID;
    }

    /**
     * @return Returns the documentType.
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * @param documentType
     *            The documentType to set.
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * @return Returns the documentName.
     */
    public String getDocumentName() {
        return documentName;
    }

    /**
     * @param documentName
     *            The documentName to set.
     */
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    /**
     * @return Returns the documentInternalCode.
     */
    public String getDocumentInternalCode() {
        return documentInternalCode;
    }

    /**
     * @param documentInternalCode
     *            The documentInternalCode to set.
     */
    public void setDocumentInternalCode(String documentInternalCode) {
        this.documentInternalCode = documentInternalCode;
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

    /**
     * @return Returns the documentScope.
     */
    public Integer getDocumentScope() {
        return documentScope;
    }

    /**
     * @param documentScope
     *            The documentScope to set.
     */
    public void setDocumentScope(Integer documentScope) {
        this.documentScope = documentScope;
    }

    /**
     * @return Returns the documentAccessability.
     */
    public Integer getDocumentAccessability() {
        return documentAccessability;
    }

    /**
     * @param documentAccessability
     *            The documentAccessability to set.
     */
    public void setDocumentAccessability(Integer documentAccessability) {
        this.documentAccessability = documentAccessability;
    }

    /**
     * @return Returns the relatedType.
     */
    public String getRelatedType() {
        return relatedType;
    }

    /**
     * @param relatedType
     *            The relatedType to set.
     */
    public void setRelatedType(String relatedType) {
        this.relatedType = relatedType;
    }

    /**
     * @return Returns the relatedSubType.
     */
    public String getRelatedSubType() {
        return relatedSubType;
    }

    /**
     * @param relatedSubType
     *            The relatedSubType to set.
     */
    public void setRelatedSubType(String relatedSubType) {
        this.relatedSubType = relatedSubType;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
