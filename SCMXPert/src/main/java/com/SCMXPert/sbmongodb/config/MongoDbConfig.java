package com.SCMXPert.sbmongodb.config;

import com.mongodb.MongoClient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = { "com.SCMXPert.sbmongodb.repository" }, mongoTemplateRef = "mongoTemplate1")
public class MongoDbConfig {

	
	@Autowired
	private Environment env;

	@SuppressWarnings("deprecation")
	@Primary
	@Bean(name = "mongoTemplate1")
	public MongoTemplate mongoTemplate(@Qualifier("mongoFactory1") MongoDbFactory mongoFactory) throws Exception {
	
		MappingMongoConverter convertor = new MappingMongoConverter(mongodbFactory(), new MongoMappingContext());
		convertor.setTypeMapper(new DefaultMongoTypeMapper(null));
		MongoTemplate mongoTemplate = new MongoTemplate(mongodbFactory(), convertor);
		return mongoTemplate;
	}

	@Primary
	@Bean(name = "mongoFactory1")
	public MongoDbFactory mongodbFactory() {
		return new SimpleMongoDbFactory(getMongoClient(), env.getRequiredProperty("m.mongo.database"));

	}

	private MongoClient getMongoClient() {
	
		return new MongoClient(env.getRequiredProperty("m.mongo.host"),Integer.parseInt(env.getRequiredProperty("m.mongo.port")));

	}

}
