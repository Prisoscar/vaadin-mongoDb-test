package com.example.application.dto;

import com.example.application.data.document.CompanyDocument;
import com.example.application.data.document.UserDocument;

public class UserCompanyDto {

	private UserDocument user;
	private CompanyDocument company;
	
	public UserCompanyDto() {
		super();
	}
	public UserCompanyDto(UserDocument user, CompanyDocument company) {
		super();
		this.user = user;
		this.company = company;
	}
	public UserDocument getUser() {
		return user;
	}
	public void setUser(UserDocument user) {
		this.user = user;
	}
	public CompanyDocument getCompany() {
		return company;
	}
	public void setCompany(CompanyDocument company) {
		this.company = company;
	}
	
}
