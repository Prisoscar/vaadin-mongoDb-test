package com.example.application.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.ReactiveMongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig /*extends AbstractMongoClientConfiguration*/ {

	/*@Bean
    public ReactiveMongoTransactionManager reactiveMongoTransactionManager() {
        return new ReactiveMongoTransactionManager(reactiveMongoDbFactory());
    }*/
	/*@Bean
	MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
		return new MongoTransactionManager(dbFactory);
	}

	@Override
	protected String getDatabaseName() {
		return "vaadin-mongo-test";
	}

	@Override
	public MongoClient mongoClient() {
		final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/vaadin-mongo-test?retryWrites=false");
		final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString).retryWrites(false).build();
		return MongoClients.create(mongoClientSettings);
	}*/
}