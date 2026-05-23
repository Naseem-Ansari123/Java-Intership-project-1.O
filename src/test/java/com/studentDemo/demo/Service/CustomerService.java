package com.studentDemo.demo.Service;

import java.util.UUID;

import com.studentDemo.demo.DTO.CustomerRequestDTO;
import com.studentDemo.demo.DTO.CustomerResponseDTO;


public interface CustomerService {
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);
    
    CustomerResponseDTO getCustomer(UUID customerId);

    String deleteCustomer(UUID customerId);

    CustomerResponseDTO updateCustomer(UUID customerId,CustomerRequestDTO customerRequestDTO);
}


