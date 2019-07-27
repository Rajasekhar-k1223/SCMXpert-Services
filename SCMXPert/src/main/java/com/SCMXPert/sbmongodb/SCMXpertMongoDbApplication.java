package com.SCMXPert.sbmongodb;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


//@PropertySource({ "file:config/application.properties" }) 
@EnableResourceServer
@SpringBootApplication
public class SCMXpertMongoDbApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(SCMXpertMongoDbApplication.class, args);
    }
/* 
    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoMappingContext context) {
 
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
 
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);
 
        return mongoTemplate;
 
    }
     */
}