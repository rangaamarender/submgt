/**
 *  All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.lucid.core.base.BaseService;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.data.SubContactVO;

/**
 * @author sgutti
 * @date Sep 24, 2022 4:56:05 PM
 *
 */
public interface SubContactService extends BaseService {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  // ---------------------------------------------------------- Public Methods
  /**
   * @param subscriptionID
   * @param createdBy
   * @param subContactVO
   * @throws ApplicationException
   */
  public void createSubContact(long subscriptionID, String createdBy, SubContactVO subContactVO)
      throws ApplicationException;

  /**
   * @param subscriptionID
   * @param modified
   * @param subContactVO
   * @throws ApplicationException
   */
  public void updateSubContact(long subscriptionID, String modified, SubContactVO subContactVO)
      throws ApplicationException;

  /**
   * @param subscriptionID
   * @param pageable
   * @return
   * @throws ApplicationException
   */
  public List<SubContactVO> retrieveAll(long subscriptionID, Pageable pageable)
      throws ApplicationException;

  /**
   * @param subscriptoinID
   * @param subContactID
   * @return
   * @throws ApplicationException
   */
  public SubContactVO retrieve(long subscriptionID, long subContactID) throws ApplicationException;
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
