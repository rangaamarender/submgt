package com.lucid.subscription;


import com.lucid.subscription.entity.DocumentDef;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 */
@Component(DocumentServiceImpl.SERVICE_NAME)
public class DocumentServiceImpl extends BaseSubServiceImpl implements DocumentService {

    public static final String SERVICE_NAME = "DocumentService";
    private static final String ERROR_DOC_0001 = "ERROR_DOC_0001";
    private static final String ERROR_DOC_0002 = "ERROR_DOC_0002";
    private static final String ERROR_DOC_0003 = "ERROR_DOC_0003";
    private static final String ERROR_DOC_0004 = "ERROR_DOC_0004";
    private static final String ERROR_DOC_0005 = "ERROR_DOC_0005";
    private static final String ERROR_DOC_0006 = "ERROR_DOC_0006";
    private static final String ERROR_DOC_0007 = "ERROR_DOC_0007";
    private static final String ERROR_DOC_0008 = "ERROR_DOC_0008";
    private static final String ERROR_DOC_0009 = "ERROR_DOC_0009";
    private static final String ERROR_DOC_00010 = "ERROR_DOC_00010";


    public DocumentServiceImpl() {
        super();
    }


    public void saveDocument(MultipartFile file, String documentName, String documentType, String relatedType, String relatedSubType) throws ApplicationContextException {

        DocumentDef documentDef = new DocumentDef();
        documentDef.setDocumentName(documentName);
        documentDef.setDocumentType(documentType);
        documentDef.setRelatedType(relatedType);
        documentDef.setRelatedSubType(relatedSubType);


    }
}