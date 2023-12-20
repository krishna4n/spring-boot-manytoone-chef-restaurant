package com.example.dinemaster.service;

import java.util.ArrayList;
import java.util.List;

import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.repository.RestaurantJpaRepository;
import com.example.dinemaster.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RestaurantJpaService implements RestaurantRepository {

    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;

    @Override
    public ArrayList<Restaurant> getAllRestaurants() {
        try {
            List<Restaurant> restaurant = restaurantJpaRepository.findAll();
            return (ArrayList<Restaurant>) restaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        try {
            restaurantJpaRepository.save(restaurant);
            return restaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        try {
            Restaurant r = restaurantJpaRepository.findById(id).get();
            return r;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant, int id) {
        try {
            Restaurant r = restaurantJpaRepository.findById(id).get();
            if (restaurant.getName() != "") {
                r.setName(restaurant.getName());
            }
            if (restaurant.getAddress() != "") {
                r.setName(restaurant.getAddress());
            }
            if (restaurant.getCuisineType() != "") {
                r.setCuisineType(restaurant.getCuisineType());
            }
            if (restaurant.getRating() != 0) {
                r.setRating(restaurant.getRating());
            }

            restaurantJpaRepository.save(r);
            return r;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteRestaurant(int id) {
        try {
            restaurantJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}