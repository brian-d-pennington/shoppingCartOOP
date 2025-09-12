package org.example.controller;

import org.example.model.Customer;
import org.example.model.Item;
import org.example.service.ShoppingCart;
import org.example.utils.Util;
import org.example.view.ConsoleUI;
import org.example.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private ShoppingCart shoppingCart;
    private ConsoleUI ui = new ConsoleUI();
    Customer customer;
    List<Item> items;
    Util util = new Util();
    List<Item> displayItems = new ArrayList<>();
    Menu menu = new Menu();

    public MenuController(ShoppingCart shoppingCart, ConsoleUI ui, Customer customer) {
        this.shoppingCart = shoppingCart;
        this.ui = ui;
        this.customer = customer;
    }

    public void run() {
        boolean running = true;
        displayItems = menu.createMenu();

        while (running) {
            int choice = ui.displayMenu();
            switch (choice) {
            //display cart
                case 1: items = shoppingCart.getCustomerItems(customer);
                    if (items.isEmpty()){
                        ui.displayMessage("You haven't added any items yet");
                    }
                    for (Item item : items){
                        ui.displayMessage(item.getName()+ " : $" +item.getPrice());
                    }
                    break;

            //remove an item  - display cart, allow user to select what/how many to remove
                case 2: //Only remove an item from the cart when the quantity for that item is zero.

                    break;

            //add an item
                case 3: // The user can add items to the cart as they wish.
                    itemsToChooseFrom();
                    int thisItem = util.promptUserForIntInRange("Select menu item to add:", 1, 8);
                    shoppingCart.customerAddItem(customer, displayItems.get(thisItem - 1));
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

    public void itemsToChooseFrom() {
        for (int i = 0; i < displayItems.size(); i++) {
            System.out.println(i + 1 + ": " + displayItems.get(i));
        }
    }

}
