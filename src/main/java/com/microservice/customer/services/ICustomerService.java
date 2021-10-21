package com.microservice.customer.services;

import com.microservice.customer.entities.dtos.CreateCustomerDto;
import com.microservice.customer.entities.dtos.ResponseCustomerDto;

import java.util.List;

public interface ICustomerService {
    ResponseCustomerDto createCustomer(CreateCustomerDto dto) throws Exception;
    List<ResponseCustomerDto> findCustomersByDni(List<String> dnis) throws  Exception;
}
