package org.example.billingservice.feigns;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.billingservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "customer-service")
public interface CustomerServiceClient {

    @GetMapping("/customers/{id}?projection=all")
    @CircuitBreaker(name = "customerService" , fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/customers?projection=all")
    @CircuitBreaker(name = "customerService" , fallbackMethod = "getDefaultCustomers")
    PagedModel<Customer> getCustomers();

    default Customer  getDefaultCustomer(Long id,Exception exception) {
        return Customer.builder()
                .id(1L)
                .name("Default Customer")
                .email("default@email.com")
                .build();
    }

    default List<Customer> getDefaultCustomers(Exception exception) {
        return List.of();
    }

}
