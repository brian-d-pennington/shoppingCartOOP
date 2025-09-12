package org.example.view;

import org.example.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<Item> displayItems = new ArrayList<>();

    public List<Item> createMenu() {
        displayItems.add(new Item("Hershey Bar", 2.00));
        displayItems.add(new Item("KitKat", 2.50));
        displayItems.add(new Item("Milky Way", 2.00));
        displayItems.add(new Item("Candy Corn", 1.00));
        displayItems.add(new Item("Snickers Bar", 2.10));
        displayItems.add(new Item("Twix", 1.50));
        displayItems.add(new Item("Donuts", 3.00));
        displayItems.add(new Item("Twinkies", 2.00));

        return displayItems;
    }
}
