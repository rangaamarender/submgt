/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.mapper;

import org.mapstruct.Mapper;

import com.lucid.core.base.BaseMapper;
import com.lucid.subscription.data.SignupTrackerVO;
import com.lucid.subscription.entity.SignupTracker;

/**
 * @author sgutti
 * @date 18-Nov-2023 12:29:30 pm
 */
@Mapper
public interface SignupTrackerMapper extends BaseMapper {

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
    SignupTracker toEntity(SignupTrackerVO data);

    /**
     * @param data
     * @return
     */
    SignupTrackerVO toVO(SignupTracker data);
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
