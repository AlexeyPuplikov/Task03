package edu.training.task03.entity;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {

    private int countOfUsingTables;
    private Queue<Table> restaurantTables;

    public Restaurant() {
        restaurantTables = new LinkedList<>();
    }

    public Queue<Table> getRestaurantTables() {
        return restaurantTables;
    }

    public void addTable(Table table) {
        this.restaurantTables.add(table);
    }

    public int getCountOfUsingTables() {
        return countOfUsingTables;
    }

    public void IncreaseTablesCounter(){
        countOfUsingTables++;
    }

    public void DecreaseTablesCounter(){
        countOfUsingTables--;
    }
}