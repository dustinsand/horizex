package com.horizex.shared

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName

/**
 * Test class for KotlinUtils.
 * This class demonstrates Kotlin test integration with the Spring Boot project.
 */
class KotlinUtilsTest {

    @Test
    @DisplayName("Test format string")
    fun testFormatString() {
        // Test with default suffix
        val result1 = KotlinUtils.formatString("hello")
        assertEquals("Hello!", result1)
        
        // Test with custom suffix
        val result2 = KotlinUtils.formatString("world", ".")
        assertEquals("World.", result2)
        
        // Test with empty string
        val result3 = KotlinUtils.formatString("", "?")
        assertEquals("?", result3)
    }
}