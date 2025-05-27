package com.horizex.customer.mapper;

import com.horizex.customer.CustomerDto;
import com.horizex.customer.domain.models.Customer;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerMapperTest {
    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    @Test
    public void testEntityToDtoWithAllFieldsPopulated() {
        // Given
        UUID id = UUID.randomUUID();
        Customer entity = new Customer();
        entity.setId(id);
        entity.setFirstName("John");
        entity.setMiddleName("Doe");
        entity.setLastName("Smith");
        entity.setEmailAddress("john.smith@example.com");
        entity.setPhoneNumber("123-456-7890");

        // When
        CustomerDto dto = customerMapper.toDto(entity);

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
        Customer entity = new Customer();
        entity.setId(id);
        entity.setFirstName("John");
        entity.setMiddleName(null); // Optional field set to null
        entity.setLastName("Smith");
        entity.setEmailAddress("john.smith@example.com");
        entity.setPhoneNumber(null); // Optional field set to null

        // When
        CustomerDto dto = customerMapper.toDto(entity);

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
        CustomerDto dto = customerMapper.toDto(null);

        // Then
        assertNull(dto);
    }

    @Test
    public void testEntityToDtoWithNullRequiredFields() {
        // Given
        Customer entity = new Customer();
        // Not setting required fields (firstName, lastName, emailAddress)

        // When
        CustomerDto dto = customerMapper.toDto(entity);

        // Then
        assertNull(dto.firstName());
        assertNull(dto.lastName());
        assertNull(dto.emailAddress());
    }

    @Test
    public void testEntityToDtoWithEmptyStrings() {
        // Given
        Customer entity = new Customer();
        entity.setFirstName("");
        entity.setMiddleName("");
        entity.setLastName("");
        entity.setEmailAddress("");
        entity.setPhoneNumber("");

        // When
        CustomerDto dto = customerMapper.toDto(entity);

        // Then
        assertEquals("", dto.firstName());
        assertEquals("", dto.middleName());
        assertEquals("", dto.lastName());
        assertEquals("", dto.emailAddress());
        assertEquals("", dto.phoneNumber());
    }
}
