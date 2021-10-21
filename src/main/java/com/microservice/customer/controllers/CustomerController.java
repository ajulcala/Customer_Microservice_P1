package com.microservice.customer.controllers;

import com.microservice.customer.entities.dtos.CreateCustomerDto;
import com.microservice.customer.entities.dtos.ResponseCustomerDto;
import com.microservice.customer.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
        RequestMethod.DELETE })
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @PostMapping()
    public ResponseCustomerDto createCustomer(@Validated @RequestBody CreateCustomerDto dto) throws  Exception{
        return customerService.createCustomer(dto);
    }


}
