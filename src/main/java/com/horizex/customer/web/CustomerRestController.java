package com.horizex.customer.web;

import com.horizex.customer.CustomerDto;
import com.horizex.customer.domain.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/horizex")
class CustomerRestController {
    private final CustomerService customerService;

    CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerService.CreateCustomerCommand command) {
        CustomerDto createdCustomer = customerService.createCustomer(command);

        URI location = URI.create("/customers/" + createdCustomer.id());

        return ResponseEntity
                .created(location)
                .body(createdCustomer);
    }

    @GetMapping("/customers")
    // TODO paging - not doing as part of this exercise, but normally would.
    List<CustomerDto> getAll() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/customers/{id}")
    ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID id) {
        return customerService.findCustomerById(id)
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

}