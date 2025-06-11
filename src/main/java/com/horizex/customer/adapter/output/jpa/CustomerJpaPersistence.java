package com.horizex.customer.adapter.output.jpa;

import com.horizex.customer.application.port.output.CustomerPersistence;
import com.horizex.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CustomerJpaPersistence implements CustomerPersistence {
    private final CustomerJpaMapper customerJpaMapper;
    private final CustomerJpaRepository customerJpaRepository;

    @Override
    public Customer createCustomer(String firstName, String middleName, String lastName, String emailAddress, String phoneNumber) {
        return customerJpaMapper.toCustomerDomainModel(
                customerJpaRepository.save(new CustomerJpaEntity(firstName, middleName, lastName, emailAddress, phoneNumber)));
    }

    @Override
    public boolean delete(UUID id) {
        if (customerJpaRepository.existsById(id)) {
            customerJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Customer> findCustomerById(UUID id) {
        return customerJpaRepository.findById(id)
                .map(customerJpaMapper::toCustomerDomainModel);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerJpaRepository.findAll().stream().map(
                customerJpaMapper::toCustomerDomainModel).collect(Collectors.toList());
    }
}
