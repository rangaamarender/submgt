/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucid.core.base.BaseServiceImpl;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.dao.SubscriptionDAO;
import com.lucid.subscription.entity.Subscription;

/**
 * @author sgutti
 * @date Sep 24, 2022 5:01:59 PM
 */
public abstract class BaseSubServiceImpl extends BaseServiceImpl {
    // --------------------------------------------------------------- Constants
    public static final String ERROR_SUB_0000 = "ERROR_SUB_0000";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private SubscriptionDAO subscriptionDAO;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>BaseSubServiceImpl</code>
     */
    public BaseSubServiceImpl() {
        super();
    }
    // ---------------------------------------------------------- Public Methods

    /**
     * @see com.ecurve.core.base.BaseServiceImpl#throwExceptionIfNoTenant(long)
     */
    @Override
    public void throwExceptionIfNoTenant(long tenantID)
            throws ApplicationException {
        Optional<Subscription> tmp = subscriptionDAO.findById(tenantID);
        if (tmp.isEmpty()) {
            throw new ApplicationException(ERROR_SUB_0000,
                    "unable to find the subscripiton");
        }
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
