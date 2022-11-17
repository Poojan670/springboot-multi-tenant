package com.multischema.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Document saveDocument(@RequestBody Document document){
        return documentService.saveDocument(document);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Document> listDocs(){
        return documentService.listDocs();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Document getDocById(@PathVariable("id") Long id){
        return documentService.getDocById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDocById(@PathVariable("id") Long id){
        documentService.deleteDocById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Document updateDocById(@PathVariable("id") Long id, @RequestBody Document document){
        return documentService.updateDocById(id, document);
    }
}
