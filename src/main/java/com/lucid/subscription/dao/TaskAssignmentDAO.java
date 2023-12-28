package com.lucid.subscription.dao;

import com.lucid.subscription.entity.TaskAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskAssignmentDAO extends JpaRepository<TaskAssignment,String> {

}
