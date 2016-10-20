package edu.training.task03.main;

import edu.training.task03.initialization.Initialization;
import edu.training.task03.entity.Restaurant;

public class Main {

    public static void main(String[] args) {
        Restaurant restaurant = Initialization.restaurantInitialize(3);
        Initialization.clientInitialize(5, restaurant);
    }
}
