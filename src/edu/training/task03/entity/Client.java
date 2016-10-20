package edu.training.task03.entity;

import java.util.concurrent.TimeUnit;

public class Client extends Thread {

    private static final long MAX_WAIT = 1000;
    private final int clientId;
    private Restaurant restaurant;

    public Client(int clientId, Restaurant restaurant) {
        this.clientId = clientId;
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        while ((currentTime + MAX_WAIT) > System.currentTimeMillis()) {
            for (Table table : restaurant.getRestaurantTables()) {
                boolean isLock = false;
                try {
                    isLock = table.getLock().tryLock(1000, TimeUnit.MILLISECONDS);
                    System.out.println("Client " + clientId + " try took " + table.getTableId());
                    if(isLock) {
                        System.out.println("Client " + clientId + " using " + table.getTableId());
                        TimeUnit.MILLISECONDS.sleep(2000);
                        break;
                    } else {
                        System.out.println("Client " + clientId + " can't took " + table.getTableId());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if(isLock) {
                        System.out.println("Client " + clientId + " release " + table.getTableId());
                        table.getLock().unlock();
                    }
                }
            }
            }
        }
}