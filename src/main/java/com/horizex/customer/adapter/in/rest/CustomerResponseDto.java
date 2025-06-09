package com.horizex.customer.adapter.in.rest;

import java.util.UUID;

public record CustomerResponseDto(UUID id, String firstName, String middleName, String lastName, String emailAddress,
                                  String phoneNumber) {
    public CustomerResponseDto {
        // TODO add validations
//        if (firstName == null || firstName.isEmpty()) {
//            throw new IllegalArgumentException("firstName is required");
//        }
    }
}