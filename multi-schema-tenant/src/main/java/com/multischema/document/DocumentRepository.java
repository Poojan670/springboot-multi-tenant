package com.multischema.document;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    Document getDocumentById(Long id);
}
