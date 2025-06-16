package com.horizex.customer

import com.horizex.customer.domain.CustomerService
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import java.util.*

@Slf4j
@Service
class CustomerApi(
    private val customerService: CustomerService,
    private val customerDtoMapper: CustomerDtoMapper
) {
    fun getCustomer(customerId: UUID): CustomerDto? {
        return customerService.findCustomerById(customerId).map(customerDtoMapper::toCustomerDto)
            .orElse(null)
    }
}
