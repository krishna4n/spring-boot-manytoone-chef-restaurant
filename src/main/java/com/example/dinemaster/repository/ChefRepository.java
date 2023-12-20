package com.example.dinemaster.repository;

import java.util.ArrayList;

import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;

public interface ChefRepository {
    ArrayList<Chef> getAllChefs();

    Chef addChef(Chef chef);

    Chef getChefById(int id);

    Chef updateChef(Chef chef, int id);

    void deleteChef(int id);

    Restaurant getChefRestaurant(int id);
}