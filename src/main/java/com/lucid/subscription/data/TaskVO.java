/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.data;

import java.util.Date;
import java.util.List;

import com.lucid.core.vo.BaseVO;

/**
 * @author sgutti
 * @date 01-May-2023 3:13:41 pm
 */
public class TaskVO extends BaseVO {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -4106530071322635287L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String taskID;
    private String taskName;
    private String taskDescription;
    private Integer priority;
    private Integer status;
    private Date dueDate;
    private Date closedDate;
    private Boolean assigned;

    private List<TaskAssignmentVO> assignments;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>TaskVO</code>
     */
    public TaskVO() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
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
     * @return Returns the taskName.
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @param taskName
     *            The taskName to set.
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * @return Returns the taskDescription.
     */
    public String getTaskDescription() {
        return taskDescription;
    }

    /**
     * @param taskDescription
     *            The taskDescription to set.
     */
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    /**
     * @return Returns the priority.
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * @param priority
     *            The priority to set.
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
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
     * @return Returns the dueDate.
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate
     *            The dueDate to set.
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return Returns the closedDate.
     */
    public Date getClosedDate() {
        return closedDate;
    }

    /**
     * @param closedDate
     *            The closedDate to set.
     */
    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    /**
     * @return Returns the assigned.
     */
    public Boolean getAssigned() {
        return assigned;
    }

    /**
     * @param assigned
     *            The assigned to set.
     */
    public void setAssigned(Boolean assigned) {
        this.assigned = assigned;
    }

    /**
     * @return Returns the assignments.
     */
    public List<TaskAssignmentVO> getAssignments() {
        return assignments;
    }

    /**
     * @param assignments
     *            The assignments to set.
     */
    public void setAssignments(List<TaskAssignmentVO> assignments) {
        this.assignments = assignments;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
