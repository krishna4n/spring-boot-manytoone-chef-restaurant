package com.example.dinemaster.controller;

import java.util.ArrayList;

import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.service.ChefJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChefController {

    @Autowired
    private ChefJpaService chefJpaService;

    @GetMapping("/restaurants/chefs")
    public ArrayList<Chef> getAllChefs() {
        return chefJpaService.getAllChefs();
    }

    @PostMapping("/restaurants/chefs")
    public Chef addChef(@RequestBody Chef chef) {
        return chefJpaService.addChef(chef);
    }

    @GetMapping("/restaurants/chefs/{chefId}")
    public Chef getChefById(@PathVariable("chefId") int id) {
        return chefJpaService.getChefById(id);
    }

    @PutMapping("/restaurants/chefs/{chefId}")
    public Chef updateRestaurant(@RequestBody Chef chef, @PathVariable("chefId") int id) {
        return chefJpaService.updateChef(chef, id);
    }

    @DeleteMapping("/restaurants/chefs/{chefId}")
    public void deleteMapping(@PathVariable("chefId") int id) {
        chefJpaService.deleteChef(id);
    }

    @GetMapping("/chefs/{chefId}/restaurant")
    public Restaurant getChefRestaurant(@PathVariable("chefId") int id) {
        return chefJpaService.getChefRestaurant(id);
    }

}