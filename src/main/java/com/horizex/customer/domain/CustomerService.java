package com.horizex.customer.domain;

import com.horizex.customer.application.port.input.CustomerUseCase;
import com.horizex.customer.application.port.output.CustomerPersistence;
import com.horizex.customer.domain.event.CustomerCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService implements CustomerUseCase {
    private final CustomerPersistence repo;
    private final ApplicationEventPublisher events;

    @Override
    public Customer createCustomer(String firstName, String middleName, String lastName, String emailAddress,
                                   String phoneNumber) {
        Customer customerJpaEntity = repo.createCustomer(firstName, middleName, lastName, emailAddress, phoneNumber);
        events.publishEvent(new CustomerCreatedEvent(customerJpaEntity.id()));
        return customerJpaEntity;
    }

    @Override
    public boolean delete(UUID id) {
        return repo.findCustomerById(id)
                .map(customer -> {
                    repo.delete(id);
                    return true;
                })
                .orElse(false);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Customer> findCustomerById(UUID id) {
        return repo.findCustomerById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Customer> findAllCustomers() {
        return repo.findAllCustomers();
    }

}
