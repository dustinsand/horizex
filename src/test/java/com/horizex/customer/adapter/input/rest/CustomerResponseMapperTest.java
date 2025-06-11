package com.horizex.customer.adapter.input.rest;

import com.horizex.customer.domain.Customer;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CustomerResponseMapperTest {
    private final CustomerResponseMapper customerResponseMapper = Mappers.getMapper(CustomerResponseMapper.class);

    @Test
    public void testEntityToDtoWithAllFieldsPopulated() {
        // Given
        UUID id = UUID.randomUUID();
        Customer customer = new Customer(
            id,
            "John",
            "Doe",
            "Smith",
            "john.smith@example.com",
            "123-456-7890"
        );

        // When
        CustomerResponseDto dto = customerResponseMapper.toDto(customer);

        // Then
        assertEquals(id, dto.id());
        assertEquals("John", dto.firstName());
        assertEquals("Doe", dto.middleName());
        assertEquals("Smith", dto.lastName());
        assertEquals("john.smith@example.com", dto.emailAddress());
        assertEquals("123-456-7890", dto.phoneNumber());
    }

    @Test
    public void testEntityToDtoWithNullOptionalFields() {
        // Given
        UUID id = UUID.randomUUID();
        Customer customer = new Customer(
            id,
            "John",
            null, // Optional field set to null
            "Smith",
            "john.smith@example.com",
            null  // Optional field set to null
        );

        // When
        CustomerResponseDto dto = customerResponseMapper.toDto(customer);

        // Then
        assertEquals(id, dto.id());
        assertEquals("John", dto.firstName());
        assertNull(dto.middleName());
        assertEquals("Smith", dto.lastName());
        assertEquals("john.smith@example.com", dto.emailAddress());
        assertNull(dto.phoneNumber());
    }

    @Test
    public void testEntityToDtoWithNullEntity() {
        // When
        CustomerResponseDto dto = customerResponseMapper.toDto(null);

        // Then
        assertNull(dto);
    }

    @Test
    public void testEntityToDtoWithNullRequiredFields() {
        // Given
        Customer customer = new Customer(
            null, // null id
            null, // null firstName
            null, // null middleName
            null, // null lastName
            null, // null emailAddress
            null  // null phoneNumber
        );

        // When
        CustomerResponseDto dto = customerResponseMapper.toDto(customer);

        // Then
        assertNull(dto.firstName());
        assertNull(dto.lastName());
        assertNull(dto.emailAddress());
    }

    @Test
    public void testEntityToDtoWithEmptyStrings() {
        // Given
        Customer customer = new Customer(
            UUID.randomUUID(), // need a non-null ID
            "",  // empty firstName
            "",  // empty middleName
            "",  // empty lastName
            "",  // empty emailAddress
            ""   // empty phoneNumber
        );

        // When
        CustomerResponseDto dto = customerResponseMapper.toDto(customer);

        // Then
        assertEquals("", dto.firstName());
        assertEquals("", dto.middleName());
        assertEquals("", dto.lastName());
        assertEquals("", dto.emailAddress());
        assertEquals("", dto.phoneNumber());
    }
}
