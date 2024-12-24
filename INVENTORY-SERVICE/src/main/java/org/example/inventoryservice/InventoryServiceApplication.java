package org.example.inventoryservice;

import org.example.inventoryservice.entities.Inventory;
import org.example.inventoryservice.repositories.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(InventoryRepository productRepository){

        return args -> {

            productRepository.save(new Inventory(null,"Computer Desk Top HP",900.0));
            productRepository.save(new Inventory(null,"Printer Epson",80.0));
            productRepository.save(new Inventory(null,"MacBook Pro Lap Top",1800.0));
            productRepository.findAll().forEach(System.out::println);

        };

    }
}
