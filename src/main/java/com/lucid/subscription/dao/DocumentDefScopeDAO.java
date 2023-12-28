/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.subscription.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucid.subscription.entity.DocumentDefScope;

/**
 * @author sgutti
 * @date 13-May-2023 2:50:39 pm
 */
public interface DocumentDefScopeDAO
        extends JpaRepository<DocumentDefScope, String> {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
