package org.example.service;

import org.example.model.Customer;
import org.example.model.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ShoppingCartTest {
    Map<Customer, List<Item>> shoppingCart = new HashMap<>();
    Customer customer = new Customer("Robert", 100);
    List<Item> customerItems = new ArrayList<>();


    @BeforeEach
    public void setUp() {
        customerItems.add(new Item("Soda", 2.00));
        customerItems.add(new Item("Beer", 1.00));
        customerItems.add(new Item("Juice", 3.00));
        customerItems.add(new Item("Water", 5.00));
    }

    @Test
    public void getCustomerItemsTest() { //henok
    }

    @Test
    public void customerAddItemTest() { //gloria

    }

    @Test
    public void customerRemoveItemTest() {
        shoppingCart.c
    }


//    public void calculateTotalPriceTest(){


}

}
