/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.submgt;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author sgutti
 * @date 07-Apr-2023 4:55:27 pm
 */
@Component
public class CorsFilter implements Filter {
    /**
     * Create a new <code>CorsFilter</code>
     */
    public CorsFilter() {
        super();
    }

    /**
     * @see jakarta.servlet.Filter#doFilter(jakarta.servlet.ServletRequest,
     *      jakarta.servlet.ServletResponse, jakarta.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
        chain.doFilter(req, res);
    }
}

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
