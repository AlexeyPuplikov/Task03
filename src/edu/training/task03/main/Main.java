package edu.training.task03.main;

import edu.training.task03.entity.Client;
import edu.training.task03.entity.Restaurant;
import edu.training.task03.entity.Table;

public class Main {
    public static void main(String[] args) {
        Client[] clients = new Client[15];
        Table[] tables = new Table[5];

        for (int i = 0; i < 5; i++) {
            tables[i] = new Table(i, 1);
        }
        Restaurant restaurant = new Restaurant();

        for (Table table : tables) {
            restaurant.addTable(table);
        }

        for (int i = 0; i < 3; i++) {
            clients[i] = new Client(i, restaurant);
            clients[i].start();
        }
    }
}
