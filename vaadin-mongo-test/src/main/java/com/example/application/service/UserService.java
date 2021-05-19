package com.example.application.service;

import java.util.List;

import com.example.application.data.document.UserDocument;

public interface UserService {
	
	public UserDocument add (UserDocument user);
	
	public List<UserDocument> getAll();
	
	public void delete(UserDocument user);

}
