package org.example.service;

import org.example.model.Customer;
import org.example.model.Item;

import java.util.List;
import java.util.Map;

public interface ShoppingCart {
    public List<Item> getCustomerItems(Customer customer);
    public Map<Customer,List<Item>> customerAddItem(Customer customer, Item item);
    public Map<Customer,List<Item>> customerRemoveItem(Customer customer, Item item);
    public double calculateTotalPrice(List<Item> list);
    public Map<Customer,List<Item>> clearShoppingCart(Customer customer);
}
