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
        List<Item> customerItems = new ArrayList<>();
        ConsoleUI ui = new ConsoleUI();
        ui.displayMessage("Welcome to the Candy Store!");
        Customer customer = ui.initializeCustomer();
        ShoppingCart shoppingCart = new ShoppingCartImpl(customer, customerItems);
        MenuController menuController = new MenuController(shoppingCart, ui,customer);
        menuController.run();
    }
}
