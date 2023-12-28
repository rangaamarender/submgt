/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;

import com.lucid.core.base.BaseMapper;
import com.lucid.subscription.data.TaskAssignmentVO;
import com.lucid.subscription.entity.TaskAssignment;

/**
 * @author sgutti
 * @date 01-May-2023 3:24:31 pm
 */
public interface TaskAssignmentMapper extends BaseMapper {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @param data
     * @return
     */
    TaskAssignment toEntity(TaskAssignmentVO data);

    /**
     * @param dataList
     * @return
     */
    List<TaskAssignment> toEntityList(List<TaskAssignmentVO> dataList);

    /**
     * @param data
     * @return
     */
    TaskAssignmentVO toVO(TaskAssignment data);

    /**
     * @param entityList
     * @return
     */
    List<TaskAssignmentVO> toVOList(List<TaskAssignment> entityList);
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
