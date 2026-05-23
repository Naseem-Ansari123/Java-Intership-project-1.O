package com.studentDemo.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDTO {
    String customerName;
    String customerFeedback;
    int customerProductCount;
    int totalPrice;
}
