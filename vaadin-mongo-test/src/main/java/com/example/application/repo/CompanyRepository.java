package com.example.application.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.application.data.document.CompanyDocument;

public interface CompanyRepository extends MongoRepository<CompanyDocument, String>{

}
