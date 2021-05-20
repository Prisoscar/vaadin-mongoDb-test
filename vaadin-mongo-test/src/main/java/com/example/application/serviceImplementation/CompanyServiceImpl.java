package com.example.application.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.application.data.document.CompanyDocument;
import com.example.application.data.document.UserDocument;
import com.example.application.dto.UserCompanyDto;
import com.example.application.repo.CompanyRepository;
import com.example.application.repo.UserRepository;
import com.example.application.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public CompanyDocument add(CompanyDocument company) {
		return companyRepository.save(company);
	}

	@Override
	public void delete(CompanyDocument company) {
		companyRepository.delete(company);
	}

	@Transactional
	@Override
	public UserCompanyDto transational(UserCompanyDto pair) {
		UserDocument user = userRepository.save(pair.getUser());
		user.setNome("a");
		userRepository.save(user);
		//CompanyDocument company = companyRepository.save(pair.getCompany());
		return new UserCompanyDto(user, new CompanyDocument());
	}

	
}
