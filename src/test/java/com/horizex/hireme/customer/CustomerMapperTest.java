package com.horizex.hireme.customer;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerMapperTest {
    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    @Test
    public void entityToDto() {
        // Given
        Customer entity = new Customer();
        entity.setFirstName("testFName");

        // When
        CustomerDTO dto = customerMapper.toDto(entity);

        // Then
        assertEquals("testFName", dto.firstName());
        // TODO assertions for all the fields
    }
}
