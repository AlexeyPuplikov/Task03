package edu.training.task03.entity;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Table {
    private final int tableId;
    private final int clientCount;
    private final ArrayList<Client> clients;
    private Restaurant restaurant;
    private final ReentrantLock lock;

    public Table(int tableId, int clientCount) {
        this.tableId = tableId;
        lock = new ReentrantLock();
        this.clientCount = clientCount;
        clients = new ArrayList<>(clientCount);
    }

    public int getTableId() {
        return tableId;
    }

    public boolean tryGetTable(Client client, long maxWait) {
        if (maxWait < new Random().nextInt(500)) {
            lock.lock();
            try {
                System.out.println("Client " + client.getId() + " took " + this.getTableId());
                return true;
            } catch (Exception e ) {
                throw e;
            } finally {
                lock.unlock();
                System.out.println("Client " + client.getId() + " release " + this.getTableId());
            }
        } else {
            lock.unlock();
            return false;
        }
    }

    public boolean tryLeaveTable(Client client) {
        lock.lock();
        try {
            return clients.remove(client);
        } catch (Exception e) {
            throw e;
        } finally {
            lock.unlock();
        }
    }
}
