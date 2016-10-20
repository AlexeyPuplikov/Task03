package edu.training.task03.entity;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {

    private Queue<Table> restaurantTables;

    public Restaurant() {
        restaurantTables = new LinkedList<>();
    }

    Queue<Table> getRestaurantTables() {
        return restaurantTables;
    }

    public void addTable(Table table) {
        this.restaurantTables.add(table);
    }

}