package org.example.billingservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.billingservice.models.Customer;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Bill {
    @Id @GeneratedValue
    private Long id;
    private LocalDate billingDate;
    private Long customerId;
    @OneToMany
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
}
