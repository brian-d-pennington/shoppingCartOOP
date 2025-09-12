package org.example.service;

import org.example.model.Customer;
import org.example.model.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartImpl implements ShoppingCart {
    private Map<Customer,List<Item>> shoppingCart;
    private Customer customer;
    private List<Item> customerItems;

    public ShoppingCartImpl(Customer customer, List<Item> customerItems) {
        this.customer = customer;
        this.customerItems = customerItems; // redundant?
        shoppingCart = new HashMap<>();
        shoppingCart.put(customer,customerItems); // check?
    }

    @Override
    public List<Item> getCustomerItems(Customer customer) {
        return shoppingCart.get(customer);
    }

    public Item

    @Override
    public Map<Customer,List<Item>> customerAddItem(Customer customer, Item item) {
        customerItems = getCustomerItems(customer);
        customerItems.add(item);
        shoppingCart.put(customer, customerItems);
        return shoppingCart;
    }

    @Override
    public Map<Customer,List<Item>> customerRemoveItem(Customer customer, Item item) {
        customerItems = getCustomerItems(customer);
        customerItems.remove(item);
        shoppingCart.put(customer, customerItems);
        return shoppingCart;
    }

//    public double calculateTotalPrice(){
//
//    }

}
