package org.example.fundflow.service.Impl;

import org.example.fundflow.dto.CustomerDTO;
import org.example.fundflow.entity.Customer;
import org.example.fundflow.repository.CustomerRepository;
import org.example.fundflow.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CustomerDTO dto) {
        Customer customer = new Customer();

        try {
            customer.setName(dto.getName());
            customer.setNic(dto.getNic());
            customer.setEmail(dto.getEmail());
            customer.setMonthlyIncome(dto.getMonthlyIncome());
            customer.setCreditScore((int) (300 + Math.random() * 550)); // 300–850
            return customerRepository.save(customer);
        } catch (Exception e){
            System.out.println(e);
        }
       return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        try{
            return customerRepository.findAll();
        } catch (Exception e){
            System.out.println(e);

        }
        return null;
    }

    @Override
    public Customer updateCustomer(Long id, CustomerDTO dto) {
        try {
            Customer customer = customerRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
            customer.setName(dto.getName());
            customer.setNic(dto.getNic());
            customer.setEmail(dto.getEmail());
            customer.setMonthlyIncome(dto.getMonthlyIncome());
            return customerRepository.save(customer);
        } catch (Exception e){
            System.out.println(e);

        }
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
            try {
                customerRepository.deleteById(id);
            } catch (Exception e){
                System.out.println(e);

            }
    }
    public Customer getCustomerByNic(String nic) {
        return customerRepository.findByNic(nic)
                .orElseThrow(() -> new RuntimeException("Customer not found with NIC: " + nic));
    }

}
