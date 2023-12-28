package com.lucid.base.test;

/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.github.javafaker.Faker;
import com.lucid.submgt.LucidSubMgtApp;

/**
 * @author sgutti
 * @date May 20, 2017 10:32:59 PM
 */
@SpringBootTest(classes = LucidSubMgtApp.class)
public abstract class BaseTransactionTest
        extends AbstractTransactionalJUnit4SpringContextTests {
    // --------------------------------------------------------------- Constants
    public static Faker FAKER = new Faker();
    // --------------------------------------------------------- Class Variables
    protected long supplierID = 1;
    protected long groupID = 1;
    protected String tenantExternalCode = "SC0001";

    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>BaseTransactionTest</code>
     */
    public BaseTransactionTest() {
        super();
    }
    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
