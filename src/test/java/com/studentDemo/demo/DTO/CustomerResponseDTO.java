package com.studentDemo.demo.DTO;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDTO {
    UUID customerId;
    String customerName;
    String customerFeedback;
    int customerProductCount;
    int totalPrice;
}
