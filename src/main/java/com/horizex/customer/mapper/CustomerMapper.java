package com.horizex.customer.mapper;

import com.horizex.customer.CustomerDto;
import com.horizex.customer.domain.models.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer entity);
}