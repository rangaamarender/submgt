/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.entity;

import java.util.Date;

import com.lucid.core.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author sgutti
 * @date 13-May-2023 3:01:08 pm
 */
@Entity(name = Note.TABLE_NAME)
@Table
public class Note extends BaseEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 3681126220140997080L;
    public static final String TABLE_NAME = "note";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "note_id", nullable = false, length = 75)
    private String noteID;

    // TENANT, PAYMENT
    @Column(name = "source", nullable = false, length = 15)
    private String source;

    // if source is TENANT, it would hold tenantID
    @Column(name = "source_id", nullable = false, length = 75)
    private String sourceID;

    @Column(name = "cateogory_or_tag", nullable = false, length = 15)
    private String categoryOrTag;

    @Column(name = "comment", nullable = false, length = 400)
    private String comment;

    // Scope can be PRIVATE,PUBLIC
    @Column(name = "note_scope", nullable = false)
    private Integer noteScope;

    @Column(name = "task_ind", nullable = true)
    private Boolean taskInd;

    @Column(name = "created_by", nullable = false, length = 100)
    private String createdBy;

    @Column(name = "created_dt", nullable = false, length = 75)
    private Date createdDate;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>Notes</code>
     */
    public Note() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the noteID.
     */
    public String getNoteID() {
        return noteID;
    }

    /**
     * @param noteID
     *            The noteID to set.
     */
    public void setNoteID(String noteID) {
        this.noteID = noteID;
    }

    /**
     * @return Returns the comment.
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment
     *            The comment to set.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return Returns the taskInd.
     */
    public Boolean getTaskInd() {
        return taskInd;
    }

    /**
     * @param taskInd
     *            The taskInd to set.
     */
    public void setTaskInd(Boolean taskInd) {
        this.taskInd = taskInd;
    }

    /**
     * @return Returns the createdBy.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     *            The createdBy to set.
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return Returns the createdDate.
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     *            The createdDate to set.
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return Returns the source.
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source
     *            The source to set.
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return Returns the sourceID.
     */
    public String getSourceID() {
        return sourceID;
    }

    /**
     * @param sourceID
     *            The sourceID to set.
     */
    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    /**
     * @return Returns the categoryOrTag.
     */
    public String getCategoryOrTag() {
        return categoryOrTag;
    }

    /**
     * @param categoryOrTag
     *            The categoryOrTag to set.
     */
    public void setCategoryOrTag(String categoryOrTag) {
        this.categoryOrTag = categoryOrTag;
    }

    /**
     * @return Returns the noteScope.
     */
    public Integer getNoteScope() {
        return noteScope;
    }

    /**
     * @param noteScope
     *            The noteScope to set.
     */
    public void setNoteScope(Integer noteScope) {
        this.noteScope = noteScope;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
