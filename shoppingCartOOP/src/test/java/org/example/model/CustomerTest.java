package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {
    private Customer customer;

    //set up for each test
    @BeforeEach
    void setUp() {
        customer = new Customer("Bill", 200.00);
    }

    @Test
    void constructor_setsFields() {
        // constructor test just asserts
        assertEquals("Bill", customer.getName());
        assertEquals(200.00, customer.getFunds());
    }

    @Test
    void setName_updatesName() {
        //act
        customer.setName("Alice");
        //assert
        assertEquals("Alice", customer.getName());
    }

    @Test
    void setFunds_updatesFunds() {
        //act
        customer.setFunds(123.45);
        //assert
        assertEquals(123.45, customer.getFunds());
    }

    @Test
    void toString_formatsTwoDecimals() {
        //act
        customer.setFunds(3.456);
        //asserts
        assertEquals("Hi Bill! You have 3.46 remaining", customer.toString());
    }
    @Test
    void getFundsForDisplay() {
        //getter just asserts
        assertEquals(0.0, customer.getFundsForDisplay());
    }

    @Test
    void setFundsForDisplay_updatesValue() {
        //act
        customer.setFundsForDisplay(50);
        //asserts
        assertEquals(50, customer.getFundsForDisplay());
    }

    @Test
    void customerSufficientFunds() {
        //acts + asserts
        assertTrue(customer.customerSufficientFunds(100));
    }

    @Test
    void customerAddsFunds() {
        //act
        customer.customerAddsFunds(25.00);
        //asserts both to make sure its works
        assertEquals(225.00, customer.getFunds());
        assertEquals(25.00, customer.getFundsForDisplay());
    }

    @Test
    void updateFundsAfterSale() {
        //act
        customer.updateFundsAfterSale(30.00);
        //asserts both methods to validate functionality
        assertEquals(170.00, customer.getFunds());
        assertEquals(170.00, customer.getFundsForDisplay());
    }
}