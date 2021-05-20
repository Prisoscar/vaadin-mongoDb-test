package com.example.application.data.document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.application.data.abstractDocument.AbstractUser;

@Document(collection = "user_document")
public class UserDocument extends AbstractUser{
	
	@Size(min = 3, max = 20, message = "Name should contain between 3 and 20 characters")
	private String nome;
	@Min(value = 18, message = "age should be at least 18")
	@Max(value = 100, message = "age should be at most 100")
	private int eta;
	
	public UserDocument() {
		super();
	}
	
	public UserDocument(
			@Size(min = 3, max = 20, message = "Name should contain between 3 and 20 characters") String nome,
			@Min(value = 18, message = "age should be at least 18") @Max(value = 100, message = "age should be at most 100") int eta) {
		super();
		this.nome = nome;
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getEta() {
		return eta;
	}
	
	public void setEta(int eta) {
		this.eta = eta;
	}	
}
