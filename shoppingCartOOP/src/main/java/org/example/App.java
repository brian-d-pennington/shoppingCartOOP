package org.example;

import org.example.controller.MenuController;
import org.example.model.Customer;
import org.example.model.Item;
import org.example.service.ShoppingCart;
import org.example.service.ShoppingCartImpl;
import org.example.view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("Welcome to the Shopping Cart! ");
        Customer customer = new Customer("Bill", 200.00);
        List<Item> customerItems = new ArrayList<>();
        ConsoleUI ui = new ConsoleUI();
        Item hersey = new Item("Hersey",2.00);
        Item kitkat = new Item("Kitkat",2.50);
        Item milkway = new Item("MilkyWay",2.50);
        Item candyCorn = new Item("CandyCorn",0.50);
        customerItems.add(milkway);
        customerItems.add(hersey);
        ShoppingCart shoppingCart = new ShoppingCartImpl(customer, customerItems);
        MenuController menuController = new MenuController(shoppingCart, ui,customer);
        ui.displayMessage("Welcome to the Shopping Cart! ");
        menuController.run();
    }
}
