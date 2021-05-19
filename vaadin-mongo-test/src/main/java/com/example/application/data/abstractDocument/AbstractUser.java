package com.example.application.data.abstractDocument;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AbstractUser extends AbstractDocument {
	
	@Size(min = 3, max = 20, message = "Username should contain between 3 and 20 characters")
	private String username;
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}")
	private String password;

	public AbstractUser() {
		super();
	}

	public AbstractUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
