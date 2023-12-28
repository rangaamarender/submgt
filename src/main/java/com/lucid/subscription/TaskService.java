/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import com.lucid.core.base.BaseService;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.data.TaskData;
import com.lucid.subscription.data.TaskVO;
import com.lucid.subscription.entity.TaskAssignment;

import java.util.List;

/**
 * @author sgutti
 * @date 01-May-2023 3:34:59 pm
 */
public interface TaskService extends BaseService {

    List<TaskVO> retrieveAllTasks()throws ApplicationException;

    String activateOrDeactivateTask(String taskID, boolean activate)throws ApplicationException;

    TaskVO retrieveTask(String taskId) throws ApplicationException;

    TaskVO createTask(TaskData taskData)throws ApplicationException;

    String deleteTask(String taskID) throws ApplicationException;


    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
