package com.sp.stockmanager.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping("/meals")
    public Set<Meal> getAllMeals(){
        return mealService.getAllMeals();
    }

    @GetMapping ("/meals/{id}")
    public Meal getMeal(@PathVariable Long id) {
        return mealService.getMeal(id);
    }

    @PostMapping("/meals")
    public void createMeal(@RequestBody Meal meal){
        mealService.addMeal (meal);
    }

    @PutMapping("/meals/{id}")
    public void updateMeal(@RequestBody Meal meal, @PathVariable Long id){
        mealService.updateMeal(meal, id);
    }

    @DeleteMapping("/meals/{id}")
    public void deleteMeal(@PathVariable Long id){
        mealService.deleteMeal(id);
    }

}
