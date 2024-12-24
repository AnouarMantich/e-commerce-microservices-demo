package org.example.billingservice.feigns;

import org.example.billingservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "customer-service")
public interface CustomerServiceClient {

    @GetMapping("/customers/{id}?projection=all")
    Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/customers?projection=all")
    PagedModel<Customer> getCustomers();

}
