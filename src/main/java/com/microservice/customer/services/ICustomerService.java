package com.microservice.customer.services;

import com.microservice.customer.entities.dtos.CreateCustomerDto;
import com.microservice.customer.entities.dtos.ResponseCustomerDto;

public interface ICustomerService {
    ResponseCustomerDto createCustomer(CreateCustomerDto dto) throws Exception;
}
