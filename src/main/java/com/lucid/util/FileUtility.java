/**
 * eCurve Inc. All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

/**
 * @author sgutti
 * @date Dec 8, 2021 8:34:22 AM
 *
 */
@Component(FileUtility.NAME)
public class FileUtility {
  // --------------------------------------------------------------- Constants
  public static final String NAME = "fileUtility";

  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>FileUtility</code>
   */
  public FileUtility() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @param fileName
   * @param folderName
   * @return
   * @throws IOException
   */
  public byte[] getFileContent(String fileName, String folderName) throws IOException {
    InputStream inputStream =
        this.getClass().getResourceAsStream("/" + folderName + File.separatorChar + fileName);
    String value = IOUtils.toString(inputStream, "UTF-8");
    return value.getBytes();
  }

  /**
   * @param fileName
   * @param folderName
   * @return
   * @throws IOException
   */
  public String getString(String fileName, String folderName) throws IOException {
    InputStream inputStream =
        getClass().getResourceAsStream("/" + folderName + File.separatorChar + fileName);
    return IOUtils.toString(inputStream, Charset.defaultCharset());
  }

  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
