package edu.training.task03.main;

import edu.training.task03.creator.Creator;
import edu.training.task03.entity.Restaurant;

public class Main {

    public static void main(String[] args) {
        Restaurant restaurant = Creator.createRestaurant(6);
        Creator.createListOfClient(7, restaurant);
    }
}
