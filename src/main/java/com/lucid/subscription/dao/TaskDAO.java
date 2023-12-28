package com.lucid.subscription.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lucid.subscription.entity.Task;

public interface TaskDAO extends JpaRepository<Task, String> {

    @Modifying
    @Transactional
    @Query("UPDATE Task t SET t.status =:status WHERE t.taskID =:taskID")
    void updateStatus(@Param("taskID")
    String taskID, @Param("status")
    int status);

    Task findByTaskID(String taskID);

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
