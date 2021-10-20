package com.microservice.customer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;

@Data
@SuperBuilder
@NoArgsConstructor
public class Person {
    @Id()
    private String _id;

    @NotEmpty
    private String name;

    @Field("last_name")
    @NotEmpty
    private String lastName;

    @NotEmpty
    private String dni;
}
