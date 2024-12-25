package org.example.billingservice.models;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Customer {
    private Long id;
    private String name;
    private String email;
}
