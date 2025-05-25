package com.horizex.hireme.customer.controller;

import com.horizex.hireme.customer.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/horizex")
class CustomerController {
    private final CustomerService customerService;

    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    CustomerDTO createCustomer(@RequestBody CustomerService.CreateCustomerCommand command) {
        return customerService.createCustomer(command);
    }

    @GetMapping("/customers")
    // TODO paging - not doing as part of this exercise, but normally would
    List<CustomerDTO> getAll() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/customers/{id}")
    ResponseEntity<CustomerDTO> getCustomer(@PathVariable UUID id) {
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
