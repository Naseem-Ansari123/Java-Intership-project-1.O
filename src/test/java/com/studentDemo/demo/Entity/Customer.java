package com.studentDemo.demo.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID customerId;
    
    @Column(name = "customer_name", nullable = true)
    String customerName;

    @Column(name = "customer_feedback", nullable = true)
    String customerFeedback;

    @Column(name = "customer_product_count", nullable = true)
    int customerProductCount;

    @Column(name = "total_price", nullable = true)
    int totalPrice;
}