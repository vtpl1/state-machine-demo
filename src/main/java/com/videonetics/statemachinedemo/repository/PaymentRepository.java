package com.videonetics.statemachinedemo.repository;

import com.videonetics.statemachinedemo.domain.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}
