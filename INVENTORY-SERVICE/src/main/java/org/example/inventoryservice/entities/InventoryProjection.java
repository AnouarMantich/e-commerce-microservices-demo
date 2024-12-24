package org.example.inventoryservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "all", types = Inventory.class)
public interface InventoryProjection {
    Long getId();
    String getName();
    Double getPrice();
}
