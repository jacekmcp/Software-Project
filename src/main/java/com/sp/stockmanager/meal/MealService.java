package com.sp.stockmanager.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public Set<Meal> getAllMeals(){
        Set<Meal> meals = new HashSet<>();

        mealRepository.findAll().forEach(meals::add);
        return meals;
    }

    public Meal getMeal(Long id){
        return mealRepository.findById(id).orElse(null);
    }

    public void addMeal(Meal meal){
        mealRepository.save(meal);
    }

    public void updateMeal(Meal meal, Long id){
        meal.setId(id);
        mealRepository.save(meal);
    }

    public void deleteMeal(Long id){
        mealRepository.deleteById(id);
    }

}