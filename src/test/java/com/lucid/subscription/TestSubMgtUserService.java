/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.github.javafaker.Name;
import com.lucid.base.test.BaseTransactionTest;
import com.lucid.core.constants.EnumStatus;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.data.SubMgtUserVO;

/**
 * @author sgutti
 * @date 09-Apr-2023 12:08:24 am
 */
public class TestSubMgtUserService extends BaseTransactionTest {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private SubMgtUserService subMgtUserService;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>TestSubMgtUserService</code>
     */
    public TestSubMgtUserService() {
        // TODO Auto-generated constructor stub
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @throws ApplicationException
     */
    @Test
    public void testCreateSubMgUser() throws ApplicationException {
        SubMgtUserVO subMgtUserVO = new SubMgtUserVO();
        Name name = FAKER.name();
        subMgtUserVO.setUserID(name.username());
        subMgtUserVO.setUsername(name.fullName());
        subMgtUserVO.setEmailID(name.username() + "@lucidraves.com");
        subMgtUserVO.setExternalCode(FAKER.letterify("U1?????"));
        subMgtUserVO.setPassword(FAKER.random().hex());
        subMgtUserVO.setRoleID(1l);
        subMgtUserVO.setSalt(FAKER.numerify("AZD###SEE"));
        subMgtUserVO.setStatus(EnumStatus.ACTIVE);
        subMgtUserVO.setUserType("INTERNAL");
        SubMgtUserVO result = subMgtUserService.createUser("UNIT-TEST", subMgtUserVO);
        Assertions.assertNotNull(result, "Got the result");
    }

    @Test
    public void testRetrieveAllUsers() throws ApplicationException {
        Page<SubMgtUserVO> users = subMgtUserService.retrieveAllUsers(0, 5);
        Assertions.assertNotNull(users, "Got the result");
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
