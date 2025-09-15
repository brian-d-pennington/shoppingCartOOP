package org.example.service;

import org.example.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @Test
    void getFundsForDisplay() {
        assertEquals(0.0, customer.getFundsForDisplay());
    }

    @Test
    void setFundsForDisplay_updatesValue() {
        customer.setFundsForDisplay(50);
        assertEquals(50, customer.getFundsForDisplay());
    }

    @Test
    void customerSufficientFunds() {
        assertTrue(customer.customerSufficientFunds(100));
    }

    @Test
    void customerAddsFunds() {
        customer.customerAddsFunds(25.00);
        assertEquals(225.00, customer.getFunds());
        assertEquals(25.00, customer.getFundsForDisplay());
    }

    @Test
    void updateFundsAfterSale() {
        customer.updateFundsAfterSale(30.00);
        assertEquals(170.00, customer.getFunds());
        assertEquals(170.00, customer.getFundsForDisplay());
    }
}