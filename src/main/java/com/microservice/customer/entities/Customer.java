package com.microservice.customer.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
@Getter()
@Setter()
public class Customer {

    @Id
    private String id;

    private String name;

    private String lastName;

    private String DNI;
}
