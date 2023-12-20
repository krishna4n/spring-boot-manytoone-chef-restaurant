package com.example.dinemaster.service;

import java.util.ArrayList;
import java.util.List;

import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.repository.ChefJpaRepository;
import com.example.dinemaster.repository.ChefRepository;
import com.example.dinemaster.repository.RestaurantJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ChefJpaService implements ChefRepository {

    @Autowired
    private ChefJpaRepository chefJpaRepository;

    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;

    @Override
    public ArrayList<Chef> getAllChefs() {
        try {
            List<Chef> chef = chefJpaRepository.findAll();
            return (ArrayList<Chef>) chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Chef addChef(Chef chef) {
        try {
            Restaurant r = chef.getRestaurant();
            int restaurantId = r.getId();
            Restaurant restaurant = restaurantJpaRepository.findById(restaurantId).get();
            chef.setRestaurant(restaurant);
            chefJpaRepository.save(chef);
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Chef getChefById(int id) {
        try {
            Chef chef = chefJpaRepository.findById(id).get();
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Chef updateChef(Chef chef, int id) {
        try {
            Chef c = chefJpaRepository.findById(id).get();
            if (chef.getFirstName() != "") {
                c.setFirstName(chef.getFirstName());
            }
            if (chef.getLastName() != "") {
                c.setLastName(chef.getLastName());
            }
            if (chef.getExpertise() != "") {
                c.setExpertise(chef.getExpertise());
            }
            if (chef.getExperienceYears() != 0) {
                c.setExperienceYears(chef.getExperienceYears());
            }
            Restaurant r = chef.getRestaurant();
            int restaurantId = r.getId();
            Restaurant restaurant = restaurantJpaRepository.findById(restaurantId).get();
            c.setRestaurant(restaurant);
            chefJpaRepository.save(c);
            return c;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteChef(int id) {
        try {
            chefJpaRepository.deleteById(id);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        throw new ResponseStatusException(HttpStatus.NO_CONTENT);

    }

    @Override
    public Restaurant getChefRestaurant(int id) {
        try {
            Chef c = chefJpaRepository.findById(id).get();
            Restaurant r = c.getRestaurant();
            int restaurantId = r.getId();
            Restaurant restaurant = restaurantJpaRepository.findById(restaurantId).get();
            return restaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}