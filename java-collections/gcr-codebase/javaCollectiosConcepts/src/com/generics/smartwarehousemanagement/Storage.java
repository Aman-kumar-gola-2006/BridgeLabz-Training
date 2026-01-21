package com.generics.smartwarehousemanagement;

import java.util.ArrayList;
import java.util.List;

class Storage<T extends WarehouseItem> {

    private List<T> items = new ArrayList<>();

    // Method to add item to storage
    public void addItem(T item) {
        items.add(item);
    }

    // Method to return all stored items
    public List<T> getItems() {
        return items;
    }
}