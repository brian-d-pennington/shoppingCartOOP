package org.example.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Util {
    private static Scanner console = new Scanner(System.in);

    // Method to round double values and calculations to 2 decimal places
    public double roundMoneyTwoDecimals(double value) {
        BigDecimal bd = new BigDecimal(value);
        return bd.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    // Method for prompt user for int
    public int promptUserForInt(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return Integer.parseInt(console.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }
    // Method to get an int within the specified range
    public int promptUserForIntInRange(String prompt, int rangeStart, int rangeEnd) {
        while (true) {
            int choice = promptUserForInt(prompt);
            if (choice >= rangeStart && choice <= rangeEnd) {
                return choice;
            }
            System.out.println("Please enter a number between " +rangeStart+ " and " +rangeEnd+ " only");
        }
    }

    // Method for prompt user for string
    public static String promptUserForString(String prompt) {
        if (!prompt.isEmpty()) {
            System.out.println(prompt);
        }
        return console.nextLine();
    }

    // Method to get true or false based on the user's answer to a y/n question
    public boolean promptUserForYN(String prompt) {
        while (true) {
            String res = promptUserForString(prompt + " (y/n)").toLowerCase();
            if (res.startsWith("y")) {
                return true;
            } else if (res.startsWith("n")) {
                return false;
            }
            System.out.println("Please enter 'y' or 'n'");
        }
    }
}
