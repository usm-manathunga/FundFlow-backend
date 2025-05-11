package org.example.fundflow.controller;

import org.example.fundflow.dto.CustomerDTO;
import org.example.fundflow.entity.Customer;
import org.example.fundflow.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/customer")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }


    @PostMapping("/createCustomer")
    public ResponseEntity<Customer> create(@RequestBody CustomerDTO dto) {
        return ResponseEntity.ok(service.createCustomer(dto));
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody CustomerDTO dto) {
        return ResponseEntity.ok(service.updateCustomer(id, dto));
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
