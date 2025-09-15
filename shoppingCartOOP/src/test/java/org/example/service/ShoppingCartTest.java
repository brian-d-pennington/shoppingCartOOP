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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {
    Customer customer = new Customer("Robert", 100);
    List<Item> customerItems = new ArrayList<>();
    ShoppingCartImpl sc;
    Map<Customer, List<Item>> shoppingCart;


    @BeforeEach
    public void setUp() {
        sc = new ShoppingCartImpl(customer, customerItems);
        customerItems.add(new Item("Soda", 2.00));
        customerItems.add(new Item("Beer", 1.00));
        customerItems.add(new Item("Juice", 3.00));
        Item water = new Item("Water", 5.00);
        customerItems.add(water);
        shoppingCart = new HashMap<>();
        shoppingCart.put(customer,customerItems);

    }

    @Test
    public void getCustomerItemsTest() {
        List<Item> actual = sc.getCustomerItems(customer);
        List<Item> expected = customerItems;
        assertEquals(expected, actual);
    }

    @Test
    public void customerAddItemTest() {
        Item itemBeans = new Item("Beans", 3.00);
        sc.customerAddItem(customer, itemBeans);
        Item actual = customerItems.get(4);
        assertEquals(itemBeans, actual);

    }
    @Test
    public void customerAddItemToShoppingCartTest() {
        Item itemBeans = new Item("Beans", 3.00);
        sc.customerAddItem(customer, itemBeans);
        List<Item> actual = shoppingCart.get(customer);
        assertEquals(customerItems, actual);
    }

    @Test
    public void customerRemoveItemTest() {
        sc.customerRemoveItem(customer, water)

    }
//
//
//    public void calculateTotalPriceTest(){


}


