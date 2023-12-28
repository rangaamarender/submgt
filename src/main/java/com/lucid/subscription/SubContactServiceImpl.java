/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.dao.SubContactDAO;
import com.lucid.subscription.data.SubContactVO;
import com.lucid.subscription.entity.SubContact;
import com.lucid.subscription.mapper.SubContactMapper;

import jakarta.persistence.PersistenceException;

/**
 * @author sgutti
 * @date Sep 24, 2022 4:57:57 PM
 */
@Component(SubContactServiceImpl.SERVICE_NAME)
public class SubContactServiceImpl extends BaseSubServiceImpl
        implements SubContactService {
    // --------------------------------------------------------------- Constants
    public static final Logger LOGGER = LoggerFactory
            .getLogger(SubContactServiceImpl.class);
    public static final String SERVICE_NAME = "subContactService";
    public static final String ERROR_SUB_CNTC_0000 = "ERROR_SUB_CNTC_0000";
    public static final String ERROR_SUB_CNTC_0001 = "ERROR_SUB_CNTC_0001";
    public static final String ERROR_SUB_CNTC_0002 = "ERROR_SUB_CNTC_0002";
    public static final String ERROR_SUB_CNTC_0003 = "ERROR_SUB_CNTC_0003";
    public static final String ERROR_SUB_CNTC_0004 = "ERROR_SUB_CNTC_0004";
    public static final String ERROR_SUB_CNTC_0005 = "ERROR_SUB_CNTC_0005";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private SubContactDAO subContactDAO;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>SubContactServiceImpl</code>
     */
    public SubContactServiceImpl() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @see com.lucid.subscription.SubContactService#createSubContact(long,
     *      java.lang.String, com.lucid.subscription.data.SubContactVO)
     */
    @Override
    public void createSubContact(long subscriptionID, String createdBy,
                                 SubContactVO subContactVO)
            throws ApplicationException {
        throwExceptionIfNoTenant(subscriptionID);
        try {
            LOGGER.debug("start of createSubContact");
            SubContactMapper mapper = Mappers.getMapper(SubContactMapper.class);
            SubContact subContact = mapper.toEntity(subContactVO);
            subContact.setSubcriptionID(subscriptionID);
            subContactDAO.save(subContact);
            LOGGER.debug("end of createSubContact");
        } catch (DataAccessException | PersistenceException e) {
            throw new ApplicationException(ERROR_SUB_CNTC_0001,
                    e.getLocalizedMessage(), e);
        }
    }

    /**
     * @see com.lucid.subscription.SubContactService#updateSubContact(long,
     *      java.lang.String, com.lucid.subscription.data.SubContactVO)
     */
    @Override
    public void updateSubContact(long subscriptionID, String modified,
                                 SubContactVO subContactVO)
            throws ApplicationException {
        throwExceptionIfNoTenant(subscriptionID);
        try {
            LOGGER.debug("start of updateSubContact");
            SubContactMapper mapper = Mappers.getMapper(SubContactMapper.class);
            SubContact subContact = mapper.toEntity(subContactVO);
            subContactDAO.save(subContact);
            LOGGER.debug("end of updateSubContact");
        } catch (DataAccessException | PersistenceException e) {
            throw new ApplicationException(ERROR_SUB_CNTC_0002,
                    e.getLocalizedMessage(), e);
        }
    }

    /**
     * @see com.lucid.subscription.SubContactService#retrieveAll(long,
     *      org.springframework.data.domain.Pageable)
     */
    @Override
    public List<SubContactVO> retrieveAll(long subscriptionID,
                                          Pageable pageable)
            throws ApplicationException {
        throwExceptionIfNoTenant(subscriptionID);
        List<SubContactVO> result = null;
        try {
            LOGGER.debug("start of retrieveAll");
            SubContactMapper mapper = Mappers.getMapper(SubContactMapper.class);
            List<SubContact> subContacts = subContactDAO
                    .findBySubscriptionID(subscriptionID, pageable);
            result = mapper.toVOList(subContacts);
            LOGGER.debug("end of retrieveAll");
        } catch (DataAccessException | PersistenceException e) {
            throw new ApplicationException(ERROR_SUB_CNTC_0003,
                    e.getLocalizedMessage(), e);
        }
        return result;
    }

    /**
     * @see com.lucid.subscription.SubContactService#retrieve(long, long)
     */
    @Override
    public SubContactVO retrieve(long subscriptionID, long subContactID)
            throws ApplicationException {
        throwExceptionIfNoTenant(subscriptionID);
        SubContactVO result = null;
        try {
            LOGGER.debug("start of retrieve");
            SubContactMapper mapper = Mappers.getMapper(SubContactMapper.class);
            SubContact subContact = subContactDAO
                    .findBySubscriptionID(subscriptionID, subContactID);
            result = mapper.toVO(subContact);
            LOGGER.debug("end of retrieve");
        } catch (DataAccessException | PersistenceException e) {
            throw new ApplicationException(ERROR_SUB_CNTC_0004,
                    e.getLocalizedMessage(), e);
        }
        return result;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
