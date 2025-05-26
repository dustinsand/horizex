package com.horizex.hireme.customer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository repo;

    public CustomerService(CustomerMapper customerMapper, CustomerRepository repo) {
        this.customerMapper = customerMapper;
        this.repo = repo;
    }

    public CustomerDTO createCustomer(CreateCustomerCommand command) {
        Customer save = repo.save(new Customer(command.firstName, command.middleName,
                command.lastName, command.emailAddress, command.phoneNumber));
        return customerMapper.toDto(save);
    }

    public boolean delete(UUID id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    public Optional<CustomerDTO> findCustomerById(UUID id) {
        Optional<Customer> byId = repo.findById(id);
        return byId.map(customerMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<CustomerDTO> findAllCustomers() {
        return repo.findAll().stream().map(customerMapper::toDto).collect(Collectors.toList());
    }

    public record CreateCustomerCommand(String firstName, String middleName, String lastName, String emailAddress,
                                        String phoneNumber) {
        public CreateCustomerCommand {
            // Assume validation of fields would be done here
        }
    }

}
