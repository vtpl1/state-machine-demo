package com.videonetics.statemachinedemo.config;

import java.util.UUID;

import com.videonetics.statemachinedemo.domain.PaymentEvent;
import com.videonetics.statemachinedemo.domain.PaymentState;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import reactor.core.publisher.Mono;

@SpringBootTest
public class StateMachineConfigTest {
    @Autowired
    StateMachineFactory<PaymentState, PaymentEvent> factory;

    @Test
    void testNewStateMachine() {
        int count = 0;
        StateMachine<PaymentState, PaymentEvent> sm = factory.getStateMachine(UUID.randomUUID());
        sm.start();
        System.out.println(count++ + " " + sm.getState().toString());

        sm.sendEvent(PaymentEvent.PRE_AUTHORIZE);

        System.out.println(count++ + " " + sm.getState().toString());

        sm.sendEvent(PaymentEvent.PRE_AUTH_APPROVED);

        System.out.println(count++ + " " + sm.getState().toString());

        sm.sendEvent(PaymentEvent.PRE_AUTH_DECLINED);

        System.out.println(count++ + " " + sm.getState().toString());
    }
}
