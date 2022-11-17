package com.multischema.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    public List<Document> listDocs() {
        try{
            return documentRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return documentRepository.findAll();
    }

    public Document getDocById(Long id) {
        return documentRepository.getDocumentById(id);
    }

    public void deleteDocById(Long id) {
        documentRepository.delete(id);
    }

    public Document updateDocById(Long id, Document document) {
        Document doc = this.getDocById(id);
        doc.setTitle(document.getTitle());
        doc.setDescription(document.getDescription());

        return documentRepository.save(doc);
    }
}
