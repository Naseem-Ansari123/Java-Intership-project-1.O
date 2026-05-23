package com.studentDemo.demo.ServiceImpi;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentDemo.demo.DTO.CustomerRequestDTO;
import com.studentDemo.demo.DTO.CustomerResponseDTO;
import com.studentDemo.demo.Entity.Customer;
import com.studentDemo.demo.Repository.CustomerRepository;
import com.studentDemo.demo.Service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService  {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        // // Employee
        Customer Customer1 = new Customer();
        Customer1.setCustomerName(customerRequestDTO.getCustomerName());
        Customer1.setCustomerFeedback(customerRequestDTO.getCustomerFeedback());
        Customer1.setCustomerProductCount(customerRequestDTO.getCustomerProductCount());
        Customer1.setTotalPrice(customerRequestDTO.getTotalPrice());

        Customer newCustomer = customerRepository.save(Customer1);

        CustomerResponseDTO CustomerResponseDTO = new CustomerResponseDTO();
        CustomerResponseDTO.setCustomerId(newCustomer.getCustomerId());
        CustomerResponseDTO.setCustomerName(newCustomer.getCustomerName());
        CustomerResponseDTO.setCustomerFeedback(newCustomer.getCustomerFeedback());
        CustomerResponseDTO.setCustomerProductCount(newCustomer.getCustomerProductCount());
        CustomerResponseDTO.setTotalPrice(newCustomer.getTotalPrice());

        return CustomerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(UUID customerId) {
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        Customer customer = customerRepository.getReferenceById(customerId);

        customerResponseDTO.setCustomerId(customer.getCustomerId());
        customerResponseDTO.setCustomerName(customer.getCustomerName());
        customerResponseDTO.setCustomerFeedback(customer.getCustomerFeedback());
        customerResponseDTO.setCustomerProductCount(customer.getCustomerProductCount());
        customerResponseDTO.setTotalPrice(customer.getTotalPrice());

        return customerResponseDTO;
    }

    @Override
    public String deleteCustomer(UUID customerId){
        customerRepository.deleteById(customerId);
        return "Customer Deleted Successfully";
    }
    



    @Override
    public CustomerResponseDTO updateCustomer(UUID customerId,CustomerRequestDTO customerRequestDTO){
        Customer customer1 = customerRepository.getReferenceById(customerId);
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        
        customer1.setCustomerName(customerRequestDTO.getCustomerName());
        customer1.setCustomerFeedback(customerRequestDTO.getCustomerFeedback());
        customer1.setCustomerProductCount(customerRequestDTO.getCustomerProductCount());
        customer1.setTotalPrice(customerRequestDTO.getTotalPrice());
        
        Customer newCustomer = customerRepository.save(customer1);

        customerResponseDTO.setCustomerId(newCustomer.getCustomerId());
        customerResponseDTO.setCustomerName(newCustomer.getCustomerName());
        customerResponseDTO.setCustomerFeedback(newCustomer.getCustomerFeedback());
        customerResponseDTO.setCustomerProductCount(newCustomer.getCustomerProductCount());
        customerResponseDTO.setTotalPrice(newCustomer.getTotalPrice());

        return customerResponseDTO;
    }
}
