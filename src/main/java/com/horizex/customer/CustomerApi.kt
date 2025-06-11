package com.horizex.customer

import com.horizex.customer.domain.Customer
import com.horizex.customer.domain.CustomerService
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import java.util.*

@Slf4j
@Service
class CustomerApi(private val customerService: CustomerService) {

    fun getCustomer(customerId: UUID): CustomerDto? {
        return customerService.findCustomerById(customerId).map(::toCustomerDto)
            .orElse(null)
    }

    fun toCustomerDto(customer: Customer): CustomerDto =
        CustomerDto(
            firstName = customer.firstName,
            middleName = customer.middleName,
            lastName = customer.lastName,
            emailAddress = customer.emailAddress,
            phoneNumber = customer.phoneNumber
        )
}
