package org.example.model;
import java.util.HashMap;
import java.util.List;
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

    public void seedDefaults() {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Double> entry : items.entrySet()) {
            String name = entry.getKey();
            Double price = entry.getValue();
            sb.append(String.format("- %s: %.2f%n", name, price));
        }
        return sb.toString();
    }
}
