package com.example.application.data.abstractDocument;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AbstractUserDocument extends AbstractDocument {
	
	@Size(min = 3, max = 20, message = "Username should contain between 3 and 20 characters")
	private String username;
	@Size(min = 8, max = 20, message = "Password should contain between 8 and 20 characters")
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!?()£])", message = "Password must contain at least a digit, a lower case character, an upper case character")
	private String password;

	public AbstractUserDocument() {
		super();
	}

	public AbstractUserDocument(String username, String password) {
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
