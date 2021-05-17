package com.example.application.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.application.data.document.UserDocument;

public interface UserRepository extends MongoRepository<UserDocument, String>{

}
