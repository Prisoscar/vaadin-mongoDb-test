package com.example.application.service;

import java.util.List;

import com.example.application.data.document.UserDocument;

public interface UserService {
	
	UserDocument add(UserDocument user);
	
	List<UserDocument> getAll();
	
	void delete(UserDocument user);

}
