package com.microservice.customer.controllers;

import com.microservice.customer.entities.Customer;
import com.microservice.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
        RequestMethod.DELETE })
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostMapping()
    public Customer create(@Validated @RequestBody Customer p) {
        return repository.insert(p);
    }

    @GetMapping()
    public List<Customer> readAll() {
        return repository.findAll();
    }

    @GetMapping("/prueba")
    public String prueba() {
        return "prueba";
    }

}
