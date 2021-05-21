package com.example.application.data.codec;

import com.example.application.data.abstractDocument.AbstractDocument;
import org.bson.Document;

public class AbstractDocumentCodec<T extends AbstractDocument>{

    protected T toObject(Document doc, T abstractDocument){
        abstractDocument.setUuid(doc.getString("_id"));
        abstractDocument.setVersion(doc.getLong("version"));
        if(doc.getDate("lastModifiedDate") != null) abstractDocument.setLastModifiedDate(doc.getDate("lastModifiedDate"));
        abstractDocument.setRecordStatus(AbstractDocument.STATUS.valueOf(doc.getString("recordStatus")));
        abstractDocument.setCreatedDate(doc.getDate("createdDate"));
        return abstractDocument;
    }

    protected Document toDocument(T abstractDocument){
        Document doc = new Document();
        doc.put("_id", abstractDocument.getUuid());
        doc.put("version", abstractDocument.getVersion());
        if(abstractDocument.getLastModifiedDate() != null) doc.put("lastModifiedDate", abstractDocument.getLastModifiedDate());
        doc.put("recordStatus", abstractDocument.getRecordStatus().toString());
        doc.put("createdDate", abstractDocument.getCreatedDate());
        doc.put("_class", abstractDocument.getClass().toString());
        return doc;
    }
}
