package org.example.service;

import org.example.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Bill", 200.00);
    }

    @Test
    void constructor_setsFields() {
        assertEquals("Bill", customer.getName());
        assertEquals(200.00, customer.getFunds());
    }

    @Test
    void setName_updatesName() {
        customer.setName("Alice");
        assertEquals("Alice", customer.getName());
    }

    @Test
    void setFunds_updatesFunds() {
        customer.setFunds(123.45);
        assertEquals(123.45, customer.getFunds());
    }

    @Test
    void toString_formatsTwoDecimals() {
        customer.setFunds(3.456);
        assertEquals("Hi Bill! You have 3.46 remaining", customer.toString());
    }
}