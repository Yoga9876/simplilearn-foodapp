package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import model.Dish;
import service.DishService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish) {
        Dish createdDish = dishService.createDish(dish);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDish);
    }

    @GetMapping
    public ResponseEntity<List<Dish>> getAllDishes() {
        List<Dish> dishes = dishService.getAllDishes();
        return ResponseEntity.ok(dishes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable Long id) {
    	Optional<Dish> optionalDish = dishService.getDishById(id);
    	if (optionalDish.isPresent()) {
    	    Dish dish = optionalDish.get();
    	    // Handle the dish object
    	    return ResponseEntity.ok(dish);
    	} else {
    	    return ResponseEntity.notFound().build();
    	}}


    @PutMapping("/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long id, @RequestBody Dish dishDetails) {
    	Optional<Dish> optionalUpdatedDish = dishService.updateDish(id, dishDetails);
    	if (optionalUpdatedDish.isPresent()) {
    	    Dish updatedDish = optionalUpdatedDish.get();
    	    return ResponseEntity.ok(updatedDish);
    	} else {
    	    return ResponseEntity.notFound().build();
    	}}


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long id) {
        boolean deleted = dishService.deleteDish(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

