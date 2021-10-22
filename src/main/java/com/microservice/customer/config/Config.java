package com.microservice.customer.config;

import com.mongodb.ReadConcern;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;

//@Configuration
public class Config {

//    @Bean(name = "mongoTransactionManager")
//    MongoTransactionManager mongoTransactionManager(MongoTemplate dbFactory) {
//        TransactionOptions transactionOptions = TransactionOptions.builder().readConcern(ReadConcern.LOCAL).writeConcern(WriteConcern.W1).build();
//        return new MongoTransactionManager(dbFactory.getMongoDatabaseFactory(), transactionOptions);
//
//    }
}
