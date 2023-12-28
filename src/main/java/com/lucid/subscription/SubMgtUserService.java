/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import org.springframework.data.domain.Page;

import com.lucid.core.base.BaseService;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.data.SubMgtUserVO;

/**
 * @author sgutti
 * @date 08-Apr-2023 5:03:19 pm
 */
public interface SubMgtUserService extends BaseService {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @param createdBy
     * @param subMgtUserVO
     * @return
     * @throws ApplicationException
     */
    SubMgtUserVO createUser(String createdBy, SubMgtUserVO subMgtUserVO) throws ApplicationException;

    /**
     * @param updatedBy
     * @param subMgtUserVO
     * @return
     * @throws ApplicationException
     */
    SubMgtUserVO updateUser(String updatedBy, SubMgtUserVO subMgtUserVO) throws ApplicationException;

    /**
     * @param page
     * @param pageSize
     * @return
     * @throws ApplicationException
     */
    Page<SubMgtUserVO> retrieveAllUsers(int page, int pageSize) throws ApplicationException;

    /**
     * @param page
     * @param pageSize
     * @return
     * @throws ApplicationException
     */
    Page<SubMgtUserVO> retrieveActiveUsers(int page, int pageSize) throws ApplicationException;

    /**
     * @param page
     * @param pageSize
     * @return
     * @throws ApplicationException
     */
    Page<SubMgtUserVO> retrieveInActiveUsers(int page, int pageSize) throws ApplicationException;

    /**
     * @param userID
     * @return
     * @throws ApplicationException
     */
    SubMgtUserVO retrieveUser(String userID) throws ApplicationException;

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
