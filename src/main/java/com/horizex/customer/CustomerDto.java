package com.horizex.customer;

import org.springframework.modulith.NamedInterface;

import java.util.UUID;

@NamedInterface("CustomerDTO") // So other modules can consume
public record CustomerDto(UUID id, String firstName, String middleName, String lastName, String emailAddress,
                          String phoneNumber) {
}