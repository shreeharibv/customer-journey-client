package com.ivoyant.customerjourney.controller;

import com.ivoyant.customerjourney.entity.Customer;
import com.ivoyant.customerjourney.service.CustomerAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerAccessController {

    @Autowired
    CustomerAccessService customerAccessService;

    @GetMapping("/{id}")
    public Customer getCustomer(
            @PathVariable String id) throws IOException {
        return customerAccessService.getCustomerObject(id);
    }

    @GetMapping("/_search/{searchElement}")
    public List<Customer> getCustomerBySearch(
            @PathVariable String searchElement) throws IOException {
        return customerAccessService.getCustomerBySearch(searchElement);
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer payload) throws IOException {
        customerAccessService.createCustomer(payload);
        return ResponseEntity.ok("Successfully created");
    }
}