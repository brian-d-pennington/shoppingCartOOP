package org.example.model;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Item {
    String name;
    Double price;

    public Item(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s  $%.2f", name, price);
    }
}
