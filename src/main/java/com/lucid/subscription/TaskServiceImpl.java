/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import com.lucid.core.base.BaseServiceImpl;
import com.lucid.core.constants.EnumStatus;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.dao.TaskAssignmentDAO;
import com.lucid.subscription.dao.TaskDAO;
import com.lucid.subscription.data.TaskData;
import com.lucid.subscription.data.TaskVO;
import com.lucid.subscription.entity.Task;
import com.lucid.subscription.entity.TaskAssignment;
import com.lucid.subscription.mapper.TaskMapper;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


/**
 * @author sgutti
 * @date 01-May-2023 3:36:27 pm
 */
@Component(TaskServiceImpl.SERVICE_NAME)
public class TaskServiceImpl extends BaseServiceImpl implements TaskService {

    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors

    public static final Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);

    public static final String SERVICE_NAME ="TaskService";
    public static final String ERROR_TASK_0000 ="ERROR_TASK_0000";
    public static final String ERROR_TASK_0001 ="ERROR_TASK_0001";
    public static final String ERROR_TASK_0002 ="ERROR_TASK_0002";
    public static final String ERROR_TASK_0003 ="ERROR_TASK_0003";
    public static final String ERROR_TASK_0004 ="ERROR_TASK_0004";
    public static final String ERROR_TASK_0005 ="ERROR_TASK_0005";

    @Autowired
    private TaskDAO taskDao;

    @Autowired
    private TaskAssignmentDAO taskAssignmentDAO;


    /**
     * Create a new <code>TaskServiceImpl</code>
     */
    public TaskServiceImpl() {
        super();
    }

    /**
     *
     * @return
     * @throws ApplicationException
     */

    @Override
    public List<TaskVO> retrieveAllTasks()throws ApplicationException {
        List<TaskVO> taskList=null;
        try {
            List<Task>TaskEntities=taskDao.findAll();
            if(TaskEntities.isEmpty()) {
                LOGGER.info("NO tasks Found");
                return Collections.emptyList();
            }
            TaskMapper mapper= Mappers.getMapper(TaskMapper.class);
            taskList=mapper.toVOList(TaskEntities);
        }catch (Exception e){
            LOGGER.error(ERROR_TASK_0000, e);
            throw  new ApplicationException(ERROR_TASK_0000,"Unable to retrieve task");
        }
        return taskList;
    }

    /**
     * @param taskID
     * @param activate
     * @return String
     * @throws ApplicationException
     */
    @Override
    public String activateOrDeactivateTask(String taskID, boolean activate) throws ApplicationException {
        try {
            Optional<Task> task = taskDao.findById(taskID);
            if (task.isPresent()) {
                if (activate) {
                    taskDao.updateStatus(taskID, EnumStatus.ACTIVE);
                    return "Task " + taskID + " Activated Successfully";
                } else {
                    taskDao.updateStatus(taskID, EnumStatus.INACTIVE);
                    return "Task " + taskID + " InActivated Successfully";
                }
            } else {
                throw new ApplicationException(ERROR_TASK_0000, "Task not found with " + taskID);
            }
        } catch (Exception e) {
            throw new ApplicationException(ERROR_TASK_0001, e.getLocalizedMessage());
        }

    }

    /**
     *
     * @param taskID
     * @return Long
     * @throws ApplicationException
     */

    @Override
    public TaskVO retrieveTask(String taskID) throws ApplicationException {
        try{
            Optional<Task> optionalTask = taskDao.findById(taskID);
            if(optionalTask.isPresent()){
                TaskMapper taskMapper = Mappers.getMapper(TaskMapper.class);
                return taskMapper.toVO(optionalTask.get());
            }
            else{
                throw new ApplicationException(ERROR_TASK_0000, "Task not found with " + taskID);
            }
        }
        catch (Exception e){
            throw new ApplicationException(ERROR_TASK_0003,e.getLocalizedMessage());
        }
    }

    @Override
    public TaskVO createTask(TaskData taskData)throws ApplicationException{
        TaskVO result=null;
        try {
            Task task = initialize(taskData);
            taskDao.save(task);
            if(task.getAssigned()){
                List<TaskAssignment> taskAssignments = initializeAssignments(task.getTaskID(),taskData);
                taskAssignmentDAO.saveAll(taskAssignments);
            }
            TaskMapper mapper = Mappers.getMapper(TaskMapper.class);
            return mapper.toVO(taskDao.findByTaskID(task.getTaskID()));
        }
        catch (Exception e){
            throw new ApplicationException(ERROR_TASK_0004,e.getLocalizedMessage());
        }
    }

    private Task initialize(TaskData taskData) {
        Task task=new Task();
        task.setTaskName(taskData.getTaskName());
        task.setTaskDescription(taskData.getDescription());
        task.setStatus(EnumStatus.INACTIVE);
        task.setPriority(taskData.getPriority());
        task.setDueDate(taskData.getDueDate());
        task.setCreatedDt(new Date());
        if(taskData.getAssignees() != null && taskData.getAssignees() .size() >0){
            task.setAssigned(false);
        }
        return task;
    }

    private List<TaskAssignment> initializeAssignments(String taskID,TaskData taskData) {
        List<TaskAssignment> taskAssignments = new ArrayList<>();
        taskData.getAssignees().forEach(assignee->{
             TaskAssignment assignment = new TaskAssignment();
             assignment.setAssignedTo(assignee);
             assignment.setAssignedDate(taskData.getStartDate());
             assignment.setTaskID(taskID);
             taskAssignments.add(assignment);
        });
        return taskAssignments;
    }

    @Override
    public String deleteTask(String taskID) throws ApplicationException {
        try {
            Optional<Task> task = taskDao.findById(taskID);
            if (task.isPresent()) {
                taskDao.updateStatus(taskID, 2);
                return "Task " + taskID + " deleted successfully";
            } else { 
                throw new ApplicationException(ERROR_TASK_0000, "Task not found with " + taskID);
            }
        } catch (Exception e) {
            throw new ApplicationException(ERROR_TASK_0001, e.getLocalizedMessage());
        }

    }
    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
