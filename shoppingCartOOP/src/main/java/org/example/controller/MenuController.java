package org.example.controller;

import org.example.service.ShoppingCart;
import org.example.view.ConsoleUI;
import java.util.Scanner;

public class MenuController {
    private ShoppingCart shoppingCart;
    private ConsoleUI ui;
    Scanner scanner = new Scanner(System.in);

    public MenuController(ShoppingCart shoppingCart, ConsoleUI ui) {
        this.shoppingCart = shoppingCart;
        this.ui = ui;
    }

    public void run() {
        boolean running = true;

        while (running) {
            String choice = ui.displayMenu();
            switch (choice) {
            //ERROR
                case "1":
                    ui.displayMessage("Invalid entry.  Please try again.");
                    break;

            //display cart
                case "2":

                    break;

            //remove an item  - display cart, allow user to select what/how many to remove
                case "2": //Only remove an item from the cart when the quantity for that item is zero.

                    break;

            //add an item
                case "4": // The user can add and remove as many items to the cart as they wish.

                    break;

            //checkout
                case "5": //When the user checks out, empty their cart and display the total amount due.

                    break;

            //exit
                case "6":
                    running = false;
                    break;
            }
        }
    }

}
