package org.example.inventoryservice.repositories;

import org.example.inventoryservice.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
