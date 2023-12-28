/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import static com.lucid.subscription.SubInvoiceServiceImpl.LOGGER;
import static com.lucid.tenant.TenantServiceImpl.TNT_SVC_002;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.lucid.core.base.BaseServiceImpl;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.dao.SubMgtUserDAO;
import com.lucid.subscription.data.SubMgtUserVO;
import com.lucid.subscription.entity.SubMgtUser;
import com.lucid.subscription.mapper.SubMgtUserMapper;

import jakarta.persistence.PersistenceException;

/**
 * @author sgutti
 * @date 08-Apr-2023 5:11:27 pm
 */
@Component(SubMgtUserServiceImpl.SERVICE_NAME)
public class SubMgtUserServiceImpl extends BaseServiceImpl implements SubMgtUserService {
    // --------------------------------------------------------------- Constants
    public static final String SERVICE_NAME = "subMgtUserService";
    public static final String ERROR_SUSER_0001 = "ERROR_SUSER_0001";
    public static final String ERROR_SUSER_0002 = "ERROR_SUSER_0002";
    public static final String ERROR_SUSER_0003 = "ERROR_SUSER_0003";
    public static final String ERROR_SUSER_0004 = "ERROR_SUSER_0004";
    public static final String ERROR_SUSER_0005 = "ERROR_SUSER_0005";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private SubMgtUserDAO subMgtUserDAO;
    // ------------------------------------------------------------ Constructors

    /**
     * Create a new <code>SubMgtUserServiceImpl</code>
     */
    public SubMgtUserServiceImpl() {
        super();
    }

    /**
     * @see com.lucid.subscription.SubMgtUserService#createUser(java.lang.String,
     *      com.lucid.subscription.data.SubMgtUserVO)
     */
    @Override
    public SubMgtUserVO createUser(String createdBy, SubMgtUserVO subMgtUserVO) throws ApplicationException {
        SubMgtUserVO result = null;
        Assert.notNull(subMgtUserVO, "subMgtUserVO is null");
        try {
            SubMgtUserMapper mapper = Mappers.getMapper(SubMgtUserMapper.class);
            SubMgtUser subMgtUser = mapper.toEntity(subMgtUserVO);
            subMgtUser.setCreatedBy(createdBy);
            subMgtUser.setCreatedDt(Calendar.getInstance().getTime());
            subMgtUserDAO.save(subMgtUser);
            result = mapper.toVO(subMgtUser);
        } catch (DataAccessException | PersistenceException e) {
            e.printStackTrace();
            throw new ApplicationException(ERROR_SUSER_0001, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubMgtUserService#updateUser(java.lang.String,
     *      com.lucid.subscription.data.SubMgtUserVO)
     */
    @Override
    public SubMgtUserVO updateUser(String updatedBy, SubMgtUserVO subMgtUserVO) throws ApplicationException {
        SubMgtUserVO result = null;
        Assert.notNull(subMgtUserVO, "subMgtUserVO is null");
        try {
            SubMgtUserMapper mapper = Mappers.getMapper(SubMgtUserMapper.class);
            SubMgtUser subMgtUser = mapper.toEntity(subMgtUserVO);
            subMgtUser.setUpdatedBy(updatedBy);
            subMgtUser.setUpdatedDt(Calendar.getInstance().getTime());
            subMgtUserDAO.save(subMgtUser);
            result = mapper.toVO(subMgtUser);
        } catch (DataAccessException | PersistenceException e) {
            e.printStackTrace();
            throw new ApplicationException(ERROR_SUSER_0002, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubMgtUserService#retrieveAllUsers(int, int)
     */
    @Override
    public Page<SubMgtUserVO> retrieveAllUsers(int page, int pageSize) throws ApplicationException {
        Page<SubMgtUserVO> result = null;
        try {
            List<Order> orders = new ArrayList<Order>();
            Order order1 = new Order(Sort.Direction.ASC, "updatedDt");
            orders.add(order1);
            Pageable pageable = PageRequest.of(page, pageSize, Sort.by(orders));
            Page<SubMgtUser> usersPage = subMgtUserDAO.findAll(pageable);
            SubMgtUserMapper mapper = Mappers.getMapper(SubMgtUserMapper.class);
            List<SubMgtUserVO> users = mapper.toVOList(usersPage.toList());
            result = new PageImpl<SubMgtUserVO>(users, pageable, usersPage.getTotalElements());
        } catch (DataAccessException | PersistenceException e) {
            e.printStackTrace();
            throw new ApplicationException(ERROR_SUSER_0001, e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubMgtUserService#retrieveActiveUsers(int,
     *      int)
     */
    @Override
    public Page<SubMgtUserVO> retrieveActiveUsers(int page, int pageSize) throws ApplicationException {
        Page<SubMgtUserVO> result = null;
        // try {
        // List<SubMgtUser> users =
        // subMgtUserDAO.findAllByStatus(EnumStatus.ACTIVE);
        // SubMgtUserMapper mapper = Mappers.getMapper(SubMgtUserMapper.class);
        // result = mapper.toVOList(users);
        // } catch (DataAccessException | PersistenceException e) {
        // e.printStackTrace();
        // throw new ApplicationException(ERROR_SUSER_0001,
        // e.getLocalizedMessage(), e);
        // }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubMgtUserService#retrieveInActiveUsers(int,
     *      int)
     */
    @Override
    public Page<SubMgtUserVO> retrieveInActiveUsers(int page, int pageSize) throws ApplicationException {
        Page<SubMgtUserVO> result = null;
        // try {
        // List<SubMgtUser> users =
        // subMgtUserDAO.findAllByStatus(EnumStatus.INACTIVE);
        // SubMgtUserMapper mapper = Mappers.getMapper(SubMgtUserMapper.class);
        // result = mapper.toVOList(users);
        // } catch (DataAccessException | PersistenceException e) {
        // e.printStackTrace();
        // throw new ApplicationException(ERROR_SUSER_0001,
        // e.getLocalizedMessage(), e);
        // }
        return result;
    }

    // get user by id
    @Override
    public SubMgtUserVO retrieveUser(String userID) throws ApplicationException {
        try {
            // find the existing user by id
            SubMgtUser subMgtUser = subMgtUserDAO.findByUserID(userID);
            if (subMgtUser == null) {
                LOGGER.info("User not found with " + userID);
                throw new ApplicationException(TNT_SVC_002, "User not found with " + userID);
            }
            SubMgtUserMapper mapper = Mappers.getMapper(SubMgtUserMapper.class);
            return mapper.toVO(subMgtUser);
        } catch (DataAccessException | PersistenceException e) {
            e.printStackTrace();
            throw new ApplicationException(ERROR_SUSER_0003, e.getLocalizedMessage(), e);
        }
    }

    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
