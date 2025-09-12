package org.example.view;

import org.example.utils.Util;

import java.text.NumberFormat;
import java.util.Scanner;

public class ConsoleUI{
    Util util = new Util();
    Scanner scanner = new Scanner(System.in);
    int answer;

    public double getDouble(String prompt) {
        boolean running = true;
        double result = 0;
        while(running) {
            displayPrompt(prompt);
            String input = scanner.nextLine();
            try {
                result = Double.parseDouble(input);
                running = false;
            } catch (Exception e) {
                displayMessage("Invalid input:");
                displayMessage(e.getLocalizedMessage());
            }
        }

        return result;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayPrompt(String prompt) {
        System.out.print(prompt + ": ");
    }

    public int displayMenu() {
        displayMessage("Welcome to the Shopping Cart! ");
        //displayMessage("Available Money:  " + asCurrency(shoppingCart.getCustomerMoney()));
        displayMessage("");
        boolean menuRunning = true;
        while (menuRunning) {
            displayMessage("1. Display Cart" +
                    "\n2. Remove an Item" +
                    "\n3. Add an Item" +
                    "\n4. Checkout" +
                    "\n5. Exit");
            answer = util.promptUserForIntInRange("Enter a Number", 1, 5);
        }
        return answer;
    }


}

