package org.example.billingservice.web;

import lombok.AllArgsConstructor;
import org.example.billingservice.entities.Bill;
import org.example.billingservice.services.BillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BillController {

    private BillService billService;

    @GetMapping("/bills")
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

}
