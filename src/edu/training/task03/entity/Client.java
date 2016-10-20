package edu.training.task03.entity;

import java.util.Random;

public class Client extends Thread {

    private final int clientId;
    private Restaurant restaurant;
    private boolean isUsing = true;

    public Client(int clientId, Restaurant restaurant) {
        this.clientId = clientId;
        this.restaurant = restaurant;

        if (restaurant != null) {
            restaurant.IncreaseTablesCounter();
        }
    }

    @Override
    public void run() {
        while (2 < new Random().nextInt(500)) {
            for (Table table : restaurant.getRestaurantTables()) {
                if(table.tryGetTable(this, 100)) {
                    System.out.println("Client " + clientId + " using " + table.getTableId());
                    }
                }
            }
        }
}