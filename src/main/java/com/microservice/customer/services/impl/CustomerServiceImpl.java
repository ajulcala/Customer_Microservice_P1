package com.microservice.customer.services.impl;

import com.microservice.customer.config.AppConfig;
import com.microservice.customer.entities.Customer;
import com.microservice.customer.entities.CustomerType;
import com.microservice.customer.entities.dtos.CreateCustomerDto;
import com.microservice.customer.entities.dtos.ResponseCustomerDto;
import com.microservice.customer.repositories.ICustomerRepository;
import javassist.NotFoundException;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class CustomerServiceImpl implements com.microservice.customer.services.ICustomerService {

    @Autowired
    ICustomerRepository customerRepository;

    public static final ModelMapper modelMapper=new ModelMapper();

    public boolean validateCustomerType(String type){
        AppConfig appConfig = new AppConfig();
        AtomicBoolean found = new AtomicBoolean(false);
        appConfig.getCustomerTypes().forEach((x)->{
            if(x.equals(type)){
                found.set(true);
            }
        });

        return found.get();
    }

    @Override
    public ResponseCustomerDto createCustomer(CreateCustomerDto dto) throws Exception {
        //Validate if customer type exists
        boolean typeFound = validateCustomerType(dto.getType().getName());

        if(typeFound){
            //Save customer
            Customer customer = Customer.builder()
                    .name(dto.getName())
                    .lastName(dto.getLastName())
                    .dni(dto.getDni())
                    .type(dto.getType())
                    .build();
            customer = customerRepository.save(customer);

            //Map response
            ResponseCustomerDto customerResponse = new ResponseCustomerDto();
            customerResponse = modelMapper.map(customer,ResponseCustomerDto.class);

            return customerResponse;

        }else{
            throw  new NotFoundException(("CUSTOMER_TYPE_NOT_FOUND"));
        }

    }


}
