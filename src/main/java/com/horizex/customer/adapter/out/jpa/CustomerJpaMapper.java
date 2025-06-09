package com.horizex.customer.adapter.out.jpa;

import com.horizex.customer.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerJpaMapper {
    Customer toCustomerDomainModel(CustomerJpaEntity customerJpaEntity);
}