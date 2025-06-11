package com.horizex.customer.adapter.output.jpa;

import com.horizex.customer.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerJpaMapper {
    Customer toCustomerDomainModel(CustomerJpaEntity customerJpaEntity);
}