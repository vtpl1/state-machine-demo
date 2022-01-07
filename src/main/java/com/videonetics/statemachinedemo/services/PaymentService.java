package com.videonetics.statemachinedemo.services;

import com.videonetics.statemachinedemo.domain.Payment;
import com.videonetics.statemachinedemo.domain.PaymentEvent;
import com.videonetics.statemachinedemo.domain.PaymentState;

import org.springframework.statemachine.StateMachine;

public interface PaymentService {
   Payment newPayment(Payment payment) ;
   StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);
   StateMachine<PaymentState, PaymentEvent> authorize(Long paymentId);
   StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);
}
