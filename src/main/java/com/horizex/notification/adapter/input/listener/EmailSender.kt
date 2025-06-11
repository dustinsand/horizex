package com.horizex.notification.adapter.input.listener

import com.horizex.customer.CustomerApi
import com.horizex.customer.domain.event.CustomerCreatedEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmailSender(private val customerApi: CustomerApi) {
    private val log: Logger = LoggerFactory.getLogger(EmailSender::class.java)

    @ApplicationModuleListener
    fun on(event: CustomerCreatedEvent) {
        sendEmailFor(event.customerId)
    }

    fun sendEmailFor(customerId: UUID) {
        log.info("Sending email for created customer {}.", customerId)

        // TODO biz logic

        // Example showing able to call Customer Api from Customer module.
        val customer = customerApi.getCustomer(customerId)

        log.info("Email sent for customer {}.", customer)
    }
}
