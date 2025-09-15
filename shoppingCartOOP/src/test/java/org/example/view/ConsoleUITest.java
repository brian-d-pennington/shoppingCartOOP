package org.example.view;

import org.example.model.Customer;
import org.example.utils.Util;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleUITest {
    ConsoleUI ui;
    Util util;
    Customer customer;

    @BeforeEach
    void setUp() {
        ui = new ConsoleUI();
        util = new Util();
        customer = new Customer("Test User", 10.00);
    }
}