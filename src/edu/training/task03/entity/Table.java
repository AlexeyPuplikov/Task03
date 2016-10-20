package edu.training.task03.entity;

import java.util.concurrent.locks.ReentrantLock;

public class Table {

    private final int tableId;
    private final ReentrantLock lock;

    public Table(int tableId) {
        this.tableId = tableId;
        lock = new ReentrantLock();
    }

    int getTableId() {
        return tableId;
    }

    ReentrantLock getLock() {
        return lock;
    }

}
