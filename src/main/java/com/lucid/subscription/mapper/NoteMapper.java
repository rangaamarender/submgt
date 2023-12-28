/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import java.util.List;
import java.util.Set;

import com.lucid.core.base.BaseMapper;
import com.lucid.subscription.data.NoteVO;
import com.lucid.subscription.entity.Note;

/**
 * @author sgutti
 * @date 13-May-2023 3:40:17 pm
 */
public interface NoteMapper extends BaseMapper {
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
    Note toEntity(NoteVO data);

    /**
     * @param dataList
     * @return
     */
    List<Note> toEntityList(List<NoteVO> dataList);

    /**
     * @param data
     * @return
     */
    NoteVO toVO(Note data);

    /**
     * @param entityList
     * @return
     */
    List<NoteVO> toVOList(Set<Note> entityList);
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
