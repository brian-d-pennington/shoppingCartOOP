package org.example.service;

import org.example.model.Customer;
import org.example.utils.Util;
import org.example.view.ConsoleUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuControllerTest {
    Customer customerToTest;
    Util util;

    @BeforeEach
    void setUp() {
         customerToTest = new Customer("Test User", 10.00);
         util = new Util();
    }

    @Test
    void testCustomerAddsFunds() {
        // arrange
        double expected = 15.00;
        // act
        customerToTest.customerAddsFunds(5.00);
        double actual = util.roundMoneyTwoDecimals(customerToTest.getFunds());
        // assert
        assertEquals(expected, actual);
    }

    @Test
    void TestCustomerAddsToNegativeFunds() {
        // arrange
        customerToTest.setFunds(-10.00);
        double expected = 5.00;
        // act
        customerToTest.customerAddsFunds(15.00);
        double actual = util.roundMoneyTwoDecimals(customerToTest.getFunds());
        // assert
        assertEquals(expected, actual);
    }
}
