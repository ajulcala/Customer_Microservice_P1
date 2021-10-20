package com.microservice.customer.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Document(collection = "customer_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerType {
    @Id()
    private String _id;

    @NotEmpty
    private String type;

}
