/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.data;

import java.util.Date;

import com.lucid.core.vo.BaseVO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author sgutti
 * @date 01-May-2023 3:14:52 pm
 */
public class TaskAssignmentVO extends BaseVO {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -4796406091563939268L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String taskAssignmentID;
    private String taskID;
    private String assignedTo;
    private Date assignedDate;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>TaskAssignmentVO</code>
     */
    public TaskAssignmentVO() {
        super();
    }

    @Modifying
    @Transactional
    @Query("UPDATE TaskAssignment su SET su.status = :status WHERE su.taskID = :taskID")
    int updateStatus(@Param("taskID") Long tenantID, @Param("status") Integer status) {
        return 0;
    }

    {
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the taskAssignmentID.
     */
    public String getTaskAssignmentID() {
        return taskAssignmentID;
    }

    /**
     * @param taskAssignmentID
     *            The taskAssignmentID to set.
     */
    public void setTaskAssignmentID(String taskAssignmentID) {
        this.taskAssignmentID = taskAssignmentID;
    }

    /**
     * @return Returns the taskID.
     */
    public String getTaskID() {
        return taskID;
    }

    /**
     * @param taskID
     *            The taskID to set.
     */
    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    /**
     * @return Returns the assignedTo.
     */
    public String getAssignedTo() {
        return assignedTo;
    }

    /**
     * @param assignedTo
     *            The assignedTo to set.
     */
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    /**
     * @return Returns the assignedDate.
     */
    public Date getAssignedDate() {
        return assignedDate;
    }

    /**
     * @param assignedDate
     *            The assignedDate to set.
     */
    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
