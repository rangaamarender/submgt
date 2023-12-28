/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.lucid.base.test.BaseTransactionTest;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.data.SubContactVO;

/**
 * @author sgutti
 * @date Sep 28, 2022 6:35:40 PM
 */
public class TestSubContactService extends BaseTransactionTest {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private SubContactService subContactService;
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>TestSubContactService</code>
     */
    public TestSubContactService() {
        super();
    }

    // ---------------------------------------------------------- Public Methods

    public void testRetrieveAll() throws ApplicationException {
        List<SubContactVO> result = subContactService.retrieveAll(4l, null);
        Assertions.assertEquals(1, result.size(), "Got the result");
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
