package com.microservice.customer.controllers;

import com.microservice.customer.entities.Signer;
import com.microservice.customer.entities.dtos.CreateCustomerDto;
import com.microservice.customer.entities.dtos.CreateSignerDto;
import com.microservice.customer.entities.dtos.ResponseCustomerDto;
import com.microservice.customer.services.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @PostMapping("/createCustomers")
    public List<ResponseCustomerDto> createCustomers(@Validated @RequestBody List<CreateCustomerDto> dtos) throws  Exception{
        return customerService.createCustomers(dtos);
    }

    @PostMapping("/createSigners")
    public List<Signer> createSigners(@Validated @RequestBody List<CreateSignerDto> dtos) throws  Exception{
        return customerService.createSigners(dtos);
    }

    @PostMapping("/findCustomers")
    public List<ResponseCustomerDto> getCustomerByDni(@Validated @RequestBody List<String> dnis) throws Exception{
        try{
            return customerService.findCustomersByDni(dnis);
        } catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "CUSTOMER_NOT_FOUND"
            );
        }

    }


}
