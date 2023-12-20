package com.example.dinemaster.repository;

import java.util.ArrayList;

import com.example.dinemaster.model.Restaurant;

public interface RestaurantRepository {
    ArrayList<Restaurant> getAllRestaurants();

    Restaurant addRestaurant(Restaurant restaurant);

    Restaurant getRestaurantById(int id);

    Restaurant updateRestaurant(Restaurant restaurant, int id);

    void deleteRestaurant(int id);
}