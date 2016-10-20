package edu.training.task03.creator;

import edu.training.task03.entity.Client;
import edu.training.task03.entity.Restaurant;
import edu.training.task03.entity.Table;

public class Creator {

    public static Restaurant createRestaurant(int countOfTables) {
        Restaurant restaurant = new Restaurant();
        for(int i = 0; i < countOfTables; i++) {
            restaurant.addTable(new Table(i));
        }
        return restaurant;
    }

    public static void createListOfClient(int countOfClient, Restaurant restaurant) {
        for(int i = 0; i < countOfClient; i++) {
            new Client(i, restaurant).start();

        }
    }
}
