package com.horizex.customer;

import com.horizex.customer.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerDtoMapper {
    CustomerDto toCustomerDto(Customer customer);
}
