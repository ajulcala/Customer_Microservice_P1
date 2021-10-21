package com.microservice.customer.repositories;

import com.microservice.customer.entities.CustomerType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerTypeRepository extends MongoRepository<CustomerType,String> {

    Optional<CustomerType> findByType(String type);
}
