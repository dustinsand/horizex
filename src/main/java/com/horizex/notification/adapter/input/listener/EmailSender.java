package com.horizex.notification.adapter.input.listener;

import com.horizex.customer.domain.event.CustomerCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailSender {
    @ApplicationModuleListener
    void on(CustomerCreatedEvent event) {
        sendEmailFor(event.customerId());
    }

    void sendEmailFor(UUID customerId) {
        log.info("Sending email for created customer {}.", customerId);

        // TODO

        log.info("Email sent for customer {}.", customerId);
    }
}
