package com.microservice.customer.services.impl;

import com.microservice.customer.entities.Customer;
import com.microservice.customer.entities.CustomerType;
import com.microservice.customer.entities.dtos.CreateCustomerDto;
import com.microservice.customer.entities.dtos.ResponseCustomerDto;
import com.microservice.customer.repositories.CustomerRepository;
import com.microservice.customer.repositories.CustomerTypeRepository;
import com.microservice.customer.services.CustomerService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICustomerService implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerTypeRepository customerTypeRepository;

    public static final ModelMapper modelMapper=new ModelMapper();

    @Override
    public ResponseCustomerDto createCustomer(CreateCustomerDto dto) throws Exception {
        //Validate if customer type exists
        CustomerType customerType = customerTypeRepository.findByType(dto.getCustomerType())
                .orElseThrow(()->new NotFoundException(("CUSTOMER_TYPE_NOT_FOUND")));

        //Save customer
        Customer customer = Customer.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .dni(dto.getDni())
                .customerType(customerType.get_id())
                .build();

        customer = customerRepository.save(customer);

        //Map response
        ResponseCustomerDto customerResponse = new ResponseCustomerDto();
        customerResponse = modelMapper.map(customer,ResponseCustomerDto.class);

        return customerResponse;
    }


}
