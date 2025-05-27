package com.horizex.customer;

import com.horizex.customer.domain.CustomerService;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerApi {
    private final CustomerService customerService;

    public CustomerApi(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Optional<CustomerDto> findCustomerById(UUID id) {
        return customerService.findCustomerById(id);
    }
}