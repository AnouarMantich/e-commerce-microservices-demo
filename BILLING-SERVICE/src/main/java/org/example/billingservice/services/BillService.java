package org.example.billingservice.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.billingservice.entities.Bill;
import org.example.billingservice.feigns.CustomerServiceClient;
import org.example.billingservice.feigns.ProductServiceClient;
import org.example.billingservice.respositories.BillRepository;
import org.example.billingservice.respositories.ProductItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BillService {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerServiceClient customerServiceClient;
    private ProductServiceClient productServiceClient;


    public List<Bill> getAllBills() {
        List<Bill> bills = billRepository.findAll();
        bills.forEach(bill -> {
            bill.setCustomer(customerServiceClient.getCustomerById(bill.getCustomerId()));
            bill.setProductItems(productItemRepository.findByBillId(bill.getId()));
            bill.getProductItems().forEach(productItem -> {
                productItem.setProduct(productServiceClient.getProductById(productItem.getProductId()));
            });
        });

        return bills;
    }

}
