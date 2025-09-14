package org.example.controller;

import org.example.model.Customer;
import org.example.model.Item;
import org.example.service.ShoppingCart;
import org.example.utils.Util;
import org.example.view.ConsoleUI;
import org.example.view.Menu;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

public class MenuController {
    private ShoppingCart shoppingCart;
    private ConsoleUI ui = new ConsoleUI();
    Customer customer;
    List<Item> items;
    Util util = new Util();
    List<Item> displayItems = new ArrayList<>();
    Menu menu = new Menu();
    int thisItem;
    List<Item> currentCart;

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
                case 1: try {
                    items = shoppingCart.getCustomerItems(customer);
                } catch (IllegalFormatException e) {
                    System.out.println(e); // handles null or corrupted data object
                }
                    if (items.isEmpty()){
                        ui.displayMessage("You haven't added any items yet.");
                    } else {
                        ui.displayMessage("Currently in your shopping cart:");
                        for (Item item : items){
                            ui.displayMessage(item.getName()+ " : $" +item.getPrice());
                        }
                    }
                    break;

            //remove an item  - display cart, allow user to select what/how many to remove
                case 2: try {
                    currentCart = shoppingCart.getCustomerItems(customer);
                } catch (IllegalFormatException e) {
                    System.out.println(e); // handles null or corrupted data object
                }
                    int cartSize = currentCart.size();
                    if (currentCart.isEmpty()) {
                        ui.displayMessage("You don't have any items to remove.");
                    } else {
                        itemsToChooseFrom(currentCart);
                        thisItem = util.promptUserForIntInRange("Select which item to remove:", 1, cartSize+1);
                        shoppingCart.customerRemoveItem(customer, currentCart.get(thisItem-1));
                        double itemPrice = displayItems.get(thisItem - 1).getPrice();
                        customer.setFundsForDisplay(customer.getFundsForDisplay() + itemPrice);
                    }
                break;

            //add an item - The user can add items to the cart as they wish.
                case 3: itemsToChooseFrom(displayItems);
                    thisItem = util.promptUserForIntInRange("Select menu item to add:", 1, 8);
                    shoppingCart.customerAddItem(customer, displayItems.get(thisItem - 1));
                    if (customer.getFundsForDisplay() < 0) {
                        System.out.println("WARNING! You do not have enough $ to complete this purchase.");
                        // prompt to add money or suggest removing items
                    }
                    double itemPrice = displayItems.get(thisItem - 1).getPrice();
                    customer.setFundsForDisplay(customer.getFundsForDisplay() - itemPrice);
                    break;

            //checkout - calculate total, and if Customer has sufficient funds, complete transaction
                case 4: try {
                    currentCart = shoppingCart.getCustomerItems(customer);
                } catch (IllegalFormatException e) {
                    System.out.println(e); // handles null or corrupted data object
                }
                    ui.displayMessage("The total for your current items");
                    itemsToChooseFrom(currentCart);
                    double total = util.roundMoneyTwoDecimals(shoppingCart.calculateTotalPrice(currentCart));
                    ui.displayMessage("is $" + total);
                    boolean confirmSale = util.promptUserForYN("Would you like to complete the transaction? Y/N");
                    boolean sufficientFunds;
                    if (confirmSale) {
                        sufficientFunds = customer.customerSufficientFunds(total);
                        if (sufficientFunds) {
                            customer.updateFundsAfterSale(total);
                            ui.displayMessage("Thank you for your purchase " + customer.getName() + "! You now have $" + util.roundMoneyTwoDecimals(customer.getFunds()));
                            shoppingCart.clearShoppingCart(customer);
                        } else {
                            ui.displayMessage("You do not have enough funds. Please remove some items from your cart.");
                        }
                    } else {
                        ui.displayMessage("Ok. Please continue shopping then.");
                    }
                    break;

            //exit
                case 5:
                    running = false;
                    break;
            }
        }
    }

    public void itemsToChooseFrom(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + ": " + items.get(i));
        }
    }
}
