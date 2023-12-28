/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;

import com.lucid.core.base.BaseMapper;
import com.lucid.subscription.data.TaskVO;
import com.lucid.subscription.entity.Task;

/**
 * @author sgutti
 * @date 01-May-2023 3:22:33 pm
 */
public interface TaskMapper extends BaseMapper {
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
    Task toEntity(TaskVO data);

    /**
     * @param dataList
     * @return
     */
    List<Task> toEntityList(List<TaskVO> dataList);

    /**
     * @param data
     * @return
     */
    TaskVO toVO(Task data);

    /**
     * @param entityList
     * @return
     */
    List<TaskVO> toVOList(List<Task> entityList);
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
