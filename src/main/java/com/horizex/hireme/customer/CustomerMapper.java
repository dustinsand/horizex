package com.horizex.hireme.customer;

import com.horizex.hireme.customer.controller.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDto(CustomerEntity entity);
}
