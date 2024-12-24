package org.example.billingservice.feigns;

import org.example.billingservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductServiceClient {

    @GetMapping("/inventories/{id}?projection=all")
    Product getProductById(@PathVariable Long id);

    @GetMapping("/inventories?projection=all")
    PagedModel<Product> getProducts();
}
