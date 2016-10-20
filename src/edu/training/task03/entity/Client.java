package edu.training.task03.entity;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Client extends Thread {

    private final static Logger LOG = LogManager.getLogger(Client.class);
    private static final long MAX_WAIT = 20;
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
                    isLock = table.getLock().tryLock(50, TimeUnit.MILLISECONDS);
                    if(isLock) {
                        LOG.info("Client " + clientId + " using " + table.getTableId());
                        TimeUnit.MILLISECONDS.sleep(100);
                        break;
                    } else {
                        LOG.info("Client " + clientId + " can't took " + table.getTableId());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if(isLock) {
                        LOG.info("Client " + clientId + " release " + table.getTableId());
                        table.getLock().unlock();
                    }
                }
            }
            }
        }
}