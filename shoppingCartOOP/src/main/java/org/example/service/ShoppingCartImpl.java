package org.example.service;

import org.example.model.Customer;
import org.example.model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartImpl implements ShoppingCart {
    private Map<Customer,List<Item>> shoppingCart;
    private Customer customer;
    private List<Item> customerItems;

    public ShoppingCartImpl(Customer customer, List<Item> customerItems) {
        this.customer = customer;
        this.customerItems = customerItems;
        shoppingCart = new HashMap<>();
        shoppingCart.put(customer,customerItems);
    }

    @Override
    public List<Item> getCustomerItems(Customer customer) {
        return shoppingCart.get(customer);
    }

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

    @Override
    public double calculateTotalPrice(List<Item> list){
        double sum = 0;
        for (Item i : list) {
            sum += i.getPrice();
        }
        return sum;
    }

    @Override
    public Map<Customer,List<Item>> clearShoppingCart(Customer customer) {
        // need to clear Customer's HashMap without leaving it null
        shoppingCart.clear();
        shoppingCart = new HashMap<>();
        List<Item> clearCart = new ArrayList<>();
        shoppingCart.put(customer, clearCart);
        return shoppingCart;
    }
}
