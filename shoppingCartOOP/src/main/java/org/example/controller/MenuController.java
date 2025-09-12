package org.example.controller;

import org.example.model.Customer;
import org.example.model.Item;
import org.example.service.ShoppingCart;
import org.example.view.ConsoleUI;

import java.util.List;
import java.util.Scanner;

public class MenuController {
    private ShoppingCart shoppingCart;
    private ConsoleUI ui = new ConsoleUI();
    Customer customer;
    Scanner scanner = new Scanner(System.in);
    List<Item> items;

    public MenuController(ShoppingCart shoppingCart, ConsoleUI ui, Customer customer) {
        this.shoppingCart = shoppingCart;
        this.ui = ui;
        this.customer = customer;
    }

    public void run() {
        boolean running = true;

        while (running) {
            int choice = ui.displayMenu();
            switch (choice) {
            //display cart
                case 1: items = shoppingCart.getCustomerItems(customer);
                    for (Item item : items){
                        System.out.println(item);
                        ui.displayMessage(item.toString());
                    }
                    break;

            //remove an item  - display cart, allow user to select what/how many to remove
                case 2: //Only remove an item from the cart when the quantity for that item is zero.

                    break;

            //add an item
                case 3: // The user can add items to the cart as they wish.

                    // display items
//                    Item thisItem = dis
//                    shoppingCart.customerAddItem(customer, Item);
                    break;

            //checkout
                case 4: //When the user checks out, empty their cart and display the total amount due.

                    break;

            //exit
                case 5:
                    running = false;
                    break;
            }
        }
    }

}
