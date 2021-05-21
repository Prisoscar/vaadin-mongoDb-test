package com.example.application.data.codec;

import com.example.application.data.document.CompanyDocument;
import org.bson.Document;

public class CompanyDocumentCodec extends AbstractDocumentCodec {

    public CompanyDocument toObject(Document doc) {
        CompanyDocument companyDocument = new CompanyDocument();
        companyDocument = (CompanyDocument) super.toObject(doc, companyDocument);
        companyDocument.setNome(doc.getString("nome"));
        companyDocument.setNumeroDipendenti(doc.getInteger("numeroDipendenti"));
        return companyDocument;
    }

    public Document toDocument(CompanyDocument companyDocument) {
        Document doc =  super.toDocument(companyDocument);
        doc.put("nome", companyDocument.getNome());
        doc.put("numeroDipendenti", companyDocument.getNumeroDipendenti());
        return doc;
    }
}
