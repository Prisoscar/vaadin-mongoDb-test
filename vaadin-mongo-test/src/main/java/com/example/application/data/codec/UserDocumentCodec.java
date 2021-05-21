package com.example.application.data.codec;

import com.example.application.data.document.UserDocument;
import org.bson.Document;
import org.springframework.lang.Nullable;


public class UserDocumentCodec<T extends UserDocument> extends AbstractUserCodec {

    public UserDocument toObject(Document doc) {
        UserDocument userDocument = (UserDocument) super.toObject(doc, new UserDocument());
        userDocument.setNome(doc.getString("nome"));
        userDocument.setEta(doc.getInteger("eta"));
        return userDocument;
    }

    public Document toDocument(UserDocument userDocument) {
        Document doc = super.toDocument(userDocument);
        doc.put("nome", userDocument.getNome());
        doc.put("eta", userDocument.getEta());
        return doc;
    }
}
