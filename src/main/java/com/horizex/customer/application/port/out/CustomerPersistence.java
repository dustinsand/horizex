package com.horizex.customer.application.port.out;

import com.horizex.customer.domain.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerPersistence {
    Customer createCustomer(String firstName, String middleName, String lastName, String emailAddress,
                            String phoneNumber);

    boolean delete(UUID id);

    Optional<Customer> findCustomerById(UUID id);

    List<Customer> findAllCustomers();
}
