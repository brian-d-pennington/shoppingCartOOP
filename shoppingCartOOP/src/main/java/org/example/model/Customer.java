package org.example.model;

public class Customer {
    private String name;
    private double funds;
    private double fundsToDisplay;

    public Customer(String name, double funds) {
        this.name = name;
        this.funds = funds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public double getFundsForDisplay() {
        return fundsToDisplay;
    } // display fund amount needs to be separate

    public void setFundsForDisplay(double fundsToDisplay) {
        this.fundsToDisplay = fundsToDisplay;
    }

    public boolean customerSufficientFunds(double checkoutTotal) {
        if (checkoutTotal <= funds) {
            return true;
        } else {
            return false;
        }
    }

    public void updateFundsAfterSale(double checkoutTotal) {
        funds -= checkoutTotal;
        fundsToDisplay = funds;
    }

    @Override
    public String toString() {
        return String.format("Hi %s! You have %.2f remaining", name, funds);
    }
}
