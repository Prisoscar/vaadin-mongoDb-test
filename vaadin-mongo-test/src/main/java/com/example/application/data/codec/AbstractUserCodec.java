package com.example.application.data.codec;

import com.example.application.data.abstractDocument.AbstractUserDocument;
import org.bson.Document;

public class AbstractUserCodec<T extends AbstractUserDocument> extends AbstractDocumentCodec{

    protected T toObject(Document doc, T abstractUserDocument) {

        abstractUserDocument = (T) super.toObject(doc, abstractUserDocument);
        abstractUserDocument.setUsername(doc.getString("username"));
        abstractUserDocument.setPassword(doc.getString("password"));
        return abstractUserDocument;
    }

    protected Document toDocument(T abstractUserDocument) {
        Document doc = super.toDocument(abstractUserDocument);
        doc.put("username", abstractUserDocument.getUsername());
        doc.put("password", abstractUserDocument.getPassword());
        return doc;
    }
}
