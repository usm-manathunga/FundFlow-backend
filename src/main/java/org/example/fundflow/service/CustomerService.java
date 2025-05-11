package org.example.fundflow.service;

import org.example.fundflow.dto.CustomerDTO;
import org.example.fundflow.entity.Customer;

import java.util.List;

public interface CustomerService {
    public Customer createCustomer(CustomerDTO customerDTO);
    public List<Customer> getAllCustomers();

    public Customer updateCustomer(Long id, CustomerDTO dto);

    public void deleteCustomer(Long id);

    public Customer getCustomerByNic(String nic);
}
