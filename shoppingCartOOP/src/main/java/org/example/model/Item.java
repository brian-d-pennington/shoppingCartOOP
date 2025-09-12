package org.example.model;
import java.util.HashMap;
import java.util.Map;

public class Item {
    private Map<String,Double> items;

    public Item() {
        this.items = items;
        items = new HashMap<>();
        seedDefaults();
    }
    public Item(Map<String, Double> items) {
        this.items = items;
        items = new HashMap<>();
        seedDefaults();
    }

    private void seedDefaults() {
        this.items.put("hersey", 2.00);
        this.items.put("kitkat", 3.20);
        this.items.put("milkyway", 2.75);
        this.items.put("reeses", 2.50);
        this.items.put("candycorn", 0.75);
    }

    public Map<String, Double> getItems() {
        return items;
    }
    public void setItems(Map<String, Double> items) {
        this.items = items;
    }
    public Double getPrice(String name) {
        return items.get(name);
    }
}
