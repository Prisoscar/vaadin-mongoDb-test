package com.example.application.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.data.document.UserDocument;
import com.example.application.repo.UserRepository;
import com.example.application.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repo;

	@Override
	public UserDocument add(UserDocument user) {
		return repo.save(user);
	}

	@Override
	public List<UserDocument> getAll() {
		return repo.findAll();
	}
}
