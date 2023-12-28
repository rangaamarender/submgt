package com.lucid.subscription;

import com.lucid.base.test.BaseTransactionTest;
import com.lucid.core.constants.EnumStatus;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.TaskService;
import com.lucid.subscription.TaskServiceImpl;
import com.lucid.subscription.dao.TaskDAO;
import com.lucid.subscription.data.TaskData;
import com.lucid.subscription.data.TaskVO;
import com.lucid.subscription.entity.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class TestTaskService extends BaseTransactionTest {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskDAO taskDAO;

    @Test
    public void testCreateTask() {
        TaskData data = new TaskData();
        data.setTaskName(FAKER.name().name());
        data.setPriority(1);
        data.setStartDate(new Date());
        data.setDescription("Task Description");
        data.setDueDate(Date.from(LocalDate.now().plusDays(10).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        try {
            TaskVO taskVO = taskService.createTask(data);
            Assertions.assertNotNull(taskVO.getTaskID());
        } catch (ApplicationException e){
            Assertions.assertEquals(TaskServiceImpl.ERROR_TASK_0004,e.getErrorCode());
        }
    }

    @Test
    public void testActivateOrInActivateTask() {
        Task data = new Task();
        data.setTaskName(FAKER.name().name());
        data.setPriority(1);
        data.setTaskDescription("Task Description");
        data.setDueDate(Date.from(LocalDate.now().plusDays(10).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        data.setStatus(EnumStatus.INACTIVE);
        data.setClosedDate(Date.from(LocalDate.now().plusDays(20).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        data.setCreatedBy(FAKER.internet().emailAddress());
        data.setCreatedDt(new Date());
        taskDAO.save(data);
        try {
            Assertions.assertEquals("Task " + data.getTaskID() +" Activated Successfully",taskService.activateOrDeactivateTask(data.getTaskID(), true));
        }
        catch (ApplicationException e){
            e.printStackTrace();
        }

        try {
            Assertions.assertEquals("Task " + data.getTaskID() +" InActivated Successfully",taskService.activateOrDeactivateTask(data.getTaskID(), false));
        }
        catch (ApplicationException e){
            e.printStackTrace();
        }
    }



    @Test
    public void deleteTask(){
        Task data =new Task();
        data.setTaskID("taskID");
        data.setTaskName(FAKER.name().name());
        data.setPriority(1);
        data.setTaskDescription("Task details");
        data.setStatus(2);
    }

}
