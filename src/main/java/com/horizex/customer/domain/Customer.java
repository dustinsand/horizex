package com.horizex.customer.domain;

import java.util.UUID;

public record Customer(UUID id, String firstName, String middleName, String lastName, String emailAddress,
                       String phoneNumber) {
}
