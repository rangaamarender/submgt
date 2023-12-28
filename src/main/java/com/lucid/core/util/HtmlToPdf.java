/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.lucid.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.InputSource;

import com.itextpdf.text.pdf.BaseFont;

/**
 * @author sgutti
 * @date 12-May-2023 9:59:12 pm
 */
@Component(HtmlToPdf.NAME)
public class HtmlToPdf {
    // --------------------------------------------------------------- Constants
    public static final String NAME = "htmlToPdf";
    private static final String UTF_8 = "UTF-8";
    private static Logger LOGGER = LoggerFactory.getLogger(HtmlToPdf.class);
    public static final String PDF_TEMPLATES_DIR = "pdftemplates";
    public static final String DATE_FORMATTER = "dateFormatter";
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>HtmlToPdf</code>
     */
    public HtmlToPdf() {
        super();
    }

    // ---------------------------------------------------------- Public Methods

    /**
     * @param templateName
     * @throws Exception
     */

    /**
     * @param templateFileName
     * @param templatesPath
     * @param values
     * @return
     * @throws IOException
     */
    public String preparePdf(final String prefixOutFileName,
                             String fontFilePath, final String templateFileName,
                             String templatesPath,
                             final Map<String, Object> values)
            throws IOException {
        String outputFileName = null;
        String cleanHtml = null;
        // String filePath= "/WEB-INF/fonts/ARIALUNI.TTF";
        // String filePath = + "/WEB-INF/fonts/NotoSansCJKsc-Regular.otf";
        try {
            values.put(DATE_FORMATTER, new DateFormatter());
            String templateName = templatesPath + File.separatorChar
                    + templateFileName;
            File templatesPathFolder = new File(templatesPath);
            String url = new File(templateName).toURI().toURL().toString();
            DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            String fileName = prefixOutFileName.toUpperCase()
                    + Calendar.getInstance().getTimeInMillis() + ".pdf";
            outputFileName = "/" + PDF_TEMPLATES_DIR + "/" + fileName;
            File outputFile = new File(templatesPathFolder, fileName);
            cleanHtml = substituteTemplateFile(templateFileName, templatesPath,
                    values);
            OutputStream os = new FileOutputStream(outputFile);
            Document doc = builder
                    .parse(new InputSource(new StringReader(cleanHtml)));
            ITextRenderer renderer = new ITextRenderer();
            if (StringUtils.isNotBlank(fontFilePath)) {
                renderer.getFontResolver().addFont(fontFilePath,
                        BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            }
            renderer.setDocument(doc, url);
            renderer.layout();
            renderer.createPDF(os);
            os.close();
        } catch (Exception e) {
            LOGGER.error("unable to generate pdf", e);
        }
        return outputFileName;
    }

    /**
     * @param templateFileName
     * @param templatesPath
     * @param values
     * @return
     * @throws IOException
     */
    private String substituteTemplateFile(final String templateFileName,
                                          final String templatesPath,
                                          final Map<String, Object> values)
            throws IOException {
        Properties props = new Properties();
        props.setProperty("file.resource.loader.path", templatesPath + "//");
        /* first, get and initialize an engine */
        VelocityEngine ve = new VelocityEngine(props);
        ve.init();
        /* next, get the Template */
        Template template = ve.getTemplate(templateFileName, "UTF-8");
        VelocityContext context = new VelocityContext();
        Set<Entry<String, Object>> entries = values.entrySet();
        for (Entry<String, Object> entry : entries) {
            context.put(entry.getKey(), entry.getValue());
        }
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        /* show the World */
        String html = writer.toString();
        return convertToXhtml(html);
    }

    /**
     * @param html
     * @return
     * @throws IOException
     */
    public String convertToXhtml(String html) throws IOException {
        Tidy tidy = new Tidy();
        tidy.setInputEncoding(UTF_8);
        tidy.setOutputEncoding(UTF_8);
        tidy.setShowWarnings(false);
        tidy.setXHTML(true);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(
                html.getBytes(UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        tidy.parseDOM(inputStream, outputStream);
        return outputStream.toString(UTF_8);
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
