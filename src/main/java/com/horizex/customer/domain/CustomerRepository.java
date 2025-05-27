package com.horizex.customer.domain;

import com.horizex.customer.domain.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {}