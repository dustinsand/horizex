package com.horizex.customer.adapter.input.rest;

import com.horizex.customer.domain.CustomerService;
import com.horizex.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/horizex")
@RequiredArgsConstructor
class CustomerRestController {
    private final CustomerResponseMapper customerResponseMapper;
    private final CustomerService customerService;

    @PostMapping("/customers")
    ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CreateCustomerCommand command) {
        Customer createdCustomer = customerService.createCustomer(command.firstName(), command.middleName(),
                command.lastName(), command.emailAddress, command.phoneNumber());

        URI location = URI.create("/customers/" + createdCustomer.id());

        return ResponseEntity
                .created(location)
                .body(customerResponseMapper.toDto(createdCustomer));
    }

    @GetMapping("/customers")
        // TODO paging - not doing as part of this exercise, but normally would.
    List<CustomerResponseDto> getAll() {
        return customerService.findAllCustomers().stream().map(customerResponseMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/customers/{id}")
    ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable UUID id) {
        return customerService.findCustomerById(id)
                .map(customerResponseMapper::toDto)
                .map(ResponseEntity::ok)               // 200 OK with User
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    @DeleteMapping("/customers/{id}")
    ResponseEntity<Void> deleteCustomer(@PathVariable UUID id) {
        boolean deleted = customerService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    record CreateCustomerCommand(String firstName, String middleName, String lastName, String emailAddress,
                                 String phoneNumber) {
        public CreateCustomerCommand {
            // Assume validation of fields would be done here
        }
    }
}
