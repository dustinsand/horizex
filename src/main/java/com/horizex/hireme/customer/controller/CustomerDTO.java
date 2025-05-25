package com.horizex.hireme.customer.controller;

import org.springframework.modulith.NamedInterface;

import java.util.UUID;

@NamedInterface("CustomerDTO") // So other modules can consume
public record CustomerDTO(UUID id, String firstName, String middleName, String lastName, String emailAddress,
                          String phoneNumber) {
}
