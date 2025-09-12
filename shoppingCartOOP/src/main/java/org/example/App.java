package org.example;

import org.example.controller.MenuController;
import org.example.model.Customer;
import org.example.model.Item;
import org.example.service.ShoppingCart;
import org.example.service.ShoppingCartImpl;
import org.example.view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Customer customer = new Customer("Bill", 200.00);
        List<Item> customerItems = new ArrayList<>();
        ConsoleUI ui = new ConsoleUI();
        ShoppingCart shoppingCart = new ShoppingCartImpl(customer, customerItems);
        MenuController menuController = new MenuController(shoppingCart, ui);
        menuController.run();
    }
}
