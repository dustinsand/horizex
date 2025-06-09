package com.horizex.customer.adapter.input.rest;

import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CustomerJpaEntityKarateTest {

    @Karate.Test
    Karate testAll() {
        return Karate.run("customer").relativeTo(getClass());
    }
}