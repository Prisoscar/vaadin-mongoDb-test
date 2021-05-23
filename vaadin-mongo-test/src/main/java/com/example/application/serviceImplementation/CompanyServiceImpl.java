package com.example.application.serviceImplementation;

import com.example.application.data.codec.CompanyDocumentCodec;
import com.example.application.data.codec.UserDocumentCodec;
import com.mongodb.*;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.data.document.CompanyDocument;
import com.example.application.data.document.UserDocument;
import com.example.application.dto.UserCompanyDto;
import com.example.application.repo.CompanyRepository;
import com.example.application.repo.UserRepository;
import com.example.application.service.CompanyService;
import org.springframework.transaction.annotation.Transactional;

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

		UserCompanyDto resultPair = new UserCompanyDto();
		resultPair.setUser(userRepository.save(pair.getUser()));
		resultPair.setCompany(companyRepository.save(pair.getCompany()));









//		UserDocument user = pair.getUser();
//		CompanyDocument company = pair.getCompany();
//
//		user.isNew();
//		company.isNew();
//
//		MongoClientURI uri = new MongoClientURI("mongodb://localhost,localhost:27017");
//		MongoClient client = new MongoClient(uri);
//		MongoDatabase database = client.getDatabase("vaadin-mongo-test");
//		MongoCollection<Document> userCollection = database.getCollection("user_document");
//		MongoCollection<Document> companyCollection = database.getCollection("company_document");
//
//		UserDocumentCodec userDocumentCodec = new UserDocumentCodec();
//		CompanyDocumentCodec companyDocumentCodec = new CompanyDocumentCodec();

		/*UserDocument gotUser = userDocumentCodec.toObject(userCollection.find().first());
		Document doc = userDocumentCodec.toDocument(gotUser);
		System.out.println(doc.toJson());
		System.out.println(UserDocument.class);*/
		/*try {
			var a = UserDocument.class.getDeclaredConstructor().newInstance();
			System.out.println("Qui il mio oggetto");
			System.out.println(a.toString());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}*/
		/*
		System.out.println("jyhfgufyyuf");
		System.out.println(userCollection.countDocuments());
		//System.out.println(userCollection.find().first());
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(defaultCodecRegistry, fromProviders(pojoCodecProvider));
		//CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
		//		fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		CodecRegistry comExampleCustomCodecRegistry = CodecRegistries.fromCodecs(new CompanyDocumentCodec(pojoCodecRegistry), new UserDocumentCodec(pojoCodecRegistry));
		companyCollection.withCodecRegistry(comExampleCustomCodecRegistry);
		userCollection.withCodecRegistry(comExampleCustomCodecRegistry);


		/*Block<UserDocument> printUser = System.out::println;
		userCollection.find().forEach(printUser);*/

		//System.out.println("first user found: " + userCollection.find(UserDocument.class).first());

//		try (ClientSession clientSession = client.startSession()){
//			clientSession.startTransaction();
//			userCollection.insertOne(clientSession, userDocumentCodec.toDocument(user));
//			companyCollection.insertOne(clientSession, companyDocumentCodec.toDocument(company));
//			clientSession.commitTransaction();
//		}
		return resultPair;
	}

	
}
