package com.microservice.customer.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCustomerDto {
    private String _id;

    private String name;

    private String lastName;

    private String dni;

    private String customerType;
}
