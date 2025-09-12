package org.example.view;

import java.text.NumberFormat;
import java.util.Scanner;

public class ConsoleUI{

    Scanner scanner = new Scanner(System.in);
    NumberFormat currency = NumberFormat.getCurrencyInstance();

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

    public void hitEnterToContinue() {
        scanner.nextLine();
    }

    public String asCurrency(double money) {
        return currency.format(money);
    }

    public String displayMenu() {
        displayMessage("Welcome to the Shopping Cart! ");
        //displayMessage("Available Money:  " + asCurrency(shoppingCart.getCustomerMoney()));
        displayMessage("");
        int answer;
        boolean menuRunning = true;
        while (menuRunning) {
            displayMessage("1. Display Cart" +
                    "\n2. Remove an Item" +
                    "\n3. Add an Item" +
                    "\n4. Checkout" +
                    "\n5. Exit");
            answer = Integer.parseInt(scanner.nextLine());
            if (answer != 1 && answer != 2 && answer != 3 && answer != 4 && answer != 5) {
                displayMessage("Invalid Entry. Please Try Again.");
            } else {
                menuRunning = false;
            }
        }
        return answer;
    }


}

