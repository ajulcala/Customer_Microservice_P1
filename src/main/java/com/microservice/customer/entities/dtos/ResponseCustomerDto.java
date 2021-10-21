package com.microservice.customer.entities.dtos;

import com.microservice.customer.entities.CustomerType;
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

    private CustomerType type;
}
