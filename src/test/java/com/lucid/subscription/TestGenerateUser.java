/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import java.util.Calendar;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.lucid.base.test.BaseTest;
import com.lucid.core.constants.EnumStatus;
import com.lucid.subscription.dao.SubMgtUserDAO;
import com.lucid.subscription.entity.SubMgtUser;
import com.lucid.util.GenerateKeys;

/**
 * @author sgutti
 * @date May 15, 2021 11:26:56 PM
 */
public class TestGenerateUser extends BaseTest {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Autowired
  private SubMgtUserDAO subMgtUserDAO;
//  @Autowired
//  private PasswordService passwordService;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>TestGenerateUser</code>
   */
  public TestGenerateUser() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  @Test
  public void testCreateUser() {
    Assertions.assertTrue(true);
  }

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  /**
   * initialize the admin user in the system
   */
  protected void initateAdminUser() {
    SubMgtUser user = new SubMgtUser();
    user.setUserID("admin");
    String encryptedPassword = GenerateKeys.generateUserPassword();
    user.setCreatedBy("system");
    user.setCreatedDt(Calendar.getInstance().getTime());
    user.setEmailID("admin@eadmin.com");
    user.setExternalCode("ADMIN");
    user.setPassword(encryptedPassword);
    user.setRoleID(1l);
    user.setSalt(RandomStringUtils.randomAlphabetic(7));
    user.setStatus(EnumStatus.ACTIVE);
    user.setUsername("Administrator");
    user.setUserType("EADMIN");
    subMgtUserDAO.save(user);
  }
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
