package com.microservice.customer.services;

import com.microservice.customer.entities.dtos.CreateCustomerDto;
import com.microservice.customer.entities.dtos.ResponseCustomerDto;

public interface CustomerService {
    ResponseCustomerDto createCustomer(CreateCustomerDto dto) throws Exception;
}
