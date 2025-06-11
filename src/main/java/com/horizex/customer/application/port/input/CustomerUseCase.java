package com.horizex.customer.application.port.input;

import com.horizex.customer.domain.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerUseCase {
    Customer createCustomer(String firstName, String middleName, String lastName, String emailAddress,
                                     String phoneNumber);

    boolean delete(UUID id);

    @Transactional(readOnly = true)
    List<Customer> findAllCustomers();

    @Transactional(readOnly = true)
    Optional<Customer> findCustomerById(UUID id);

}
