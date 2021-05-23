package com.example.application.service;

import com.example.application.data.document.CompanyDocument;
import com.example.application.dto.UserCompanyDto;

public interface CompanyService {

		CompanyDocument add(CompanyDocument company);
		
		void delete(CompanyDocument company);
		
		UserCompanyDto transactional(UserCompanyDto obj);
}
