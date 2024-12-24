package org.example.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "all", types = {Customer.class})
public interface CustomerProjection extends Projection{
    Long getId();
    String getName();
    String getEmail();
}
