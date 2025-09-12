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
        Customer customer = new Customer("Bill", 200.00);
        Item item = new Item();
        List<Item> itemList = new ArrayList<>();
        itemList.add(item); // test populate
        ConsoleUI ui = new ConsoleUI();
        ShoppingCart shoppingCart = new ShoppingCartImpl(customer, itemList);
        MenuController menuController = new MenuController(shoppingCart, ui);
        menuController.run();
    }
}
