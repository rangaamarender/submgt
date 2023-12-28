/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.core.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lucid.base.test.BaseTest;

/**
 * @author sgutti
 * @date 12-May-2023 10:05:55 pm
 */
public class TestPdfGeneration extends BaseTest {

    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private HtmlToPdf htmlToPdf;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>TestPdfGeneration</code>
     */
    public TestPdfGeneration() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    @Test
    public void testPdfGen() throws IOException {
        String templatesPath = "./src/test/resources/pdftemplates";
        Map<String, Object> values = new HashMap<>();
        // String outputFileName = htmlToPdf.preparePdf("studentapp", "",
        // "template.html", templatesPath, values);
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
