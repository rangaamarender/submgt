/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without permission.
 */
package com.lucid.subscription.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lucid.subscription.SubMgtUserService;
import com.lucid.subscription.data.SubMgtUserVO;

/**
 * @author sgutti
 * @date 09-Apr-2023 12:12:23 am
 */
@RestController
@RequestMapping
public class SubMgtUserCntrl {
  // --------------------------------------------------------------- Constants
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  @Autowired
  private SubMgtUserService subMgtUserService;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>SubMgtUserCntrl</code>
   */
  public SubMgtUserCntrl() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @param page
   * @param pageSize
   * @return
   */
  @GetMapping(path = "/v1/susers")
  public ResponseEntity<?> getAllUsers(int page, int pageSize) {
    try {
      return ResponseEntity.ok(subMgtUserService.retrieveAllUsers(page, pageSize));
    } catch (Exception e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * @param userID
   * @return
   */
  @GetMapping("/v1/suser/{userID}")
  public ResponseEntity<?> retrieveUser(@PathVariable String userID) {
    try {
      return ResponseEntity.ok(subMgtUserService.retrieveUser(userID));
    } catch (Exception e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * @param userID
   * @param subMgtUserVO
   * @return
   */
  @PatchMapping("/v1/suser/{userID}")
  public ResponseEntity<?> updateUser(@PathVariable String userID,
      @RequestBody SubMgtUserVO subMgtUserVO) {
    try {
      return ResponseEntity.ok(subMgtUserService.updateUser(userID, subMgtUserVO));
    } catch (Exception e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
