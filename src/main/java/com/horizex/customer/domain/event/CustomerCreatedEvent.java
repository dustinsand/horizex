package com.horizex.customer.domain.event;

import org.springframework.modulith.NamedInterface;

import java.util.UUID;

@NamedInterface("CustomerCreatedEvent")
public record CustomerCreatedEvent(UUID customerId) {
}
