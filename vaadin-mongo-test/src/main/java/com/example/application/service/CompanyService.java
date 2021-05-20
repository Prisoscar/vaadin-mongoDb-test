package com.example.application.service;

import com.example.application.data.document.CompanyDocument;
import com.example.application.dto.UserCompanyDto;

public interface CompanyService {

		public CompanyDocument add(CompanyDocument company);
		
		public void delete(CompanyDocument company);
		
		public UserCompanyDto transational (UserCompanyDto obj);
}
