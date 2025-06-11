package com.horizex.customer.adapter.input.rest;

import com.horizex.customer.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerResponseMapper {
    CustomerResponseDto toDto(Customer customer);
}
