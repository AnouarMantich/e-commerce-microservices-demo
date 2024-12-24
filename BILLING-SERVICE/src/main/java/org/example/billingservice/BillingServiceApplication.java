package org.example.billingservice;

import org.example.billingservice.entities.Bill;
import org.example.billingservice.entities.ProductItem;
import org.example.billingservice.feigns.CustomerServiceClient;
import org.example.billingservice.feigns.ProductServiceClient;
import org.example.billingservice.models.Customer;
import org.example.billingservice.models.Product;
import org.example.billingservice.respositories.BillRepository;
import org.example.billingservice.respositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Collection;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(
            BillRepository billRepository, ProductItemRepository productItemRepository
            , CustomerServiceClient customerServiceClient, ProductServiceClient productServiceClient
            ){
        return args -> {

            Collection<Customer> customers = customerServiceClient.getCustomers().getContent();
            Collection<Product> products = productServiceClient.getProducts().getContent();

            System.out.println("======================== Customers ================================");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
            System.out.println("======================== Products ================================");
            for (Product product : products) {
                System.out.println(product);
            }

            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .customer(customer)
                        .billingDate(LocalDate.now())
                        .customerId(customer.getId())
                        .build();
                billRepository.save(bill);
                for (Product product : products) {
                    ProductItem productItem = ProductItem.builder()
                            .productId(product.getId())
                            .price(product.getPrice())
                            .quantity((int)(Math.random()*10)+1)
                            .bill(bill)
                            .product(product)
                            .build();
                    productItemRepository.save(productItem);
                }
            });












        };
    }

}
