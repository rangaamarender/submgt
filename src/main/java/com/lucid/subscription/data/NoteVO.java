/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.data;

import java.util.Date;

import com.lucid.core.vo.BaseVO;

/**
 * @author sgutti
 * @date 13-May-2023 3:41:05 pm
 */
public class NoteVO extends BaseVO {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -2104509349214818973L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String noteID;

    // TENANT, PAYMENT
    private String source;

    // if source is TENANT, it would hold tenantID
    private String sourceID;

    private String categoryOrTag;

    private String comment;

    private Boolean taskInd;

    private String createdBy;

    private Date createdDate;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>NoteVO</code>
     */
    public NoteVO() {
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
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
