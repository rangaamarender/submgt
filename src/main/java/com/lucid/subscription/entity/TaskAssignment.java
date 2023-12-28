/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.entity;

import java.util.Date;

import com.lucid.core.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author sgutti
 * @date 01-May-2023 3:03:59 pm
 */
@Entity
@Table(name = TaskAssignment.TABLE_NAME)
public class TaskAssignment extends BaseEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -4592249059416025031L;
    public static final String TABLE_NAME = "l_task_assignment";

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "task_assignment_id", nullable = false, length = 75)
    private String taskAssignmentID;

    @Column(name = "task_id", nullable = false, length = 75)
    private String taskID;

    @Column(name = "assigned_to", nullable = false, length = 100)
    private String assignedTo;

    @Column(name = "assigned_date", nullable = false)
    private Date assignedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false, insertable = false,
            updatable = false)
    private Task task;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>TaskAssignment</code>
     */
    public TaskAssignment() {
        super();
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

    /**
     * @return Returns the task.
     */
    public Task getTask() {
        return task;
    }

    /**
     * @param task
     *            The task to set.
     */
    public void setTask(Task task) {
        this.task = task;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
