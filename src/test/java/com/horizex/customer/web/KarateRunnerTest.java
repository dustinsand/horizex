package com.horizex.customer.web;

import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class KarateRunnerTest {

    @Karate.Test
    Karate testAll() {
        return Karate.run("customer").relativeTo(getClass());
    }
}