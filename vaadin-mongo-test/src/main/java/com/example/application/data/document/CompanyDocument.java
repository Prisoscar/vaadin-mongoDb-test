package com.example.application.data.document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.application.data.abstractDocument.AbstractDocument;

@Document(collection = "company_document")
public class CompanyDocument extends AbstractDocument{
	
	@Size(min = 3, max = 400)
	private String nome;
	@Min(value = 0)
	@Max(value = 100_000)
	private int numeroDipendenti;
	
	public CompanyDocument() {
		super();
	}
	
	public CompanyDocument(@Size(min = 3, max = 400) String nome, @Min(0) @Max(100000) int numeroDipendenti) {
		super();
		this.nome = nome;
		this.numeroDipendenti = numeroDipendenti;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNumeroDipendenti() {
		return numeroDipendenti;
	}
	
	public void setNumeroDipendenti(int numeroDipendenti) {
		this.numeroDipendenti = numeroDipendenti;
	}		
}
