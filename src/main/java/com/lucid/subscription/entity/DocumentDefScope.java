/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.entity;

import com.lucid.core.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author sgutti
 * @date 29-Apr-2023 6:02:35 pm
 */
@Entity
@Table(name = DocumentDefScope.TABLE_NAME)
public class DocumentDefScope extends BaseEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 7941372586739634507L;
    public static final String TABLE_NAME = "document_def_scope";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Id
    @Column(name = "doc_def_id", nullable = false, length = 75)
    private String documentDefID;

    @Column(name = "time_sensitivie", nullable = true)
    private Boolean timeSensitive;

    @Column(name = "validity_days", nullable = true)
    private Integer validityDays;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>DocumentDefScope</code>
     */
    public DocumentDefScope() {
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
     * @return Returns the timeSensitive.
     */
    public Boolean getTimeSensitive() {
        return timeSensitive;
    }

    /**
     * @param timeSensitive
     *            The timeSensitive to set.
     */
    public void setTimeSensitive(Boolean timeSensitive) {
        this.timeSensitive = timeSensitive;
    }

    /**
     * @return Returns the validityDays.
     */
    public Integer getValidityDays() {
        return validityDays;
    }

    /**
     * @param validityDays
     *            The validityDays to set.
     */
    public void setValidityDays(Integer validityDays) {
        this.validityDays = validityDays;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
