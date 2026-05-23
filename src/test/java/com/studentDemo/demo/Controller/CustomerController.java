package com.studentDemo.demo.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentDemo.demo.DTO.CustomerRequestDTO;
import com.studentDemo.demo.DTO.CustomerResponseDTO;
import com.studentDemo.demo.Service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/createCustomer") // http://localhost:8080/api/createCustomer
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        return new ResponseEntity<>(customerService.createCustomer(customerRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getCustomer")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@RequestParam UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<String> deletCustomer(@RequestParam UUID customerId) {
        return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.OK);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@RequestParam UUID customerId, @RequestBody CustomerRequestDTO customerRequestDTO) {

        return new ResponseEntity<>(customerService.updateCustomer(customerId,customerRequestDTO),HttpStatus.OK);
    }
}
