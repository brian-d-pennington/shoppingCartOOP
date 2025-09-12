package org.example.model;
import java.util.HashMap;
import java.util.Map;

public class Item {
    private Map<String,Double> items;
    public Item(Map<String, Double> items) {
        this.items = items;
    }

    public Map<String, Double> getItems() {
        return items;
    }

    public void setItems(Map<String, Double> items) {
        this.items = items;
    }
}
