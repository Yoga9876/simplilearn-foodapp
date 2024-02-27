package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Dish;
import repository.DishRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    // Method to retrieve all dishes
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    // Method to retrieve a dish by its ID
    public Optional<Dish> getDishById(Long id) {
        return dishRepository.findById(id);
    }

    // Method to create a new dish
    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    // Method to update an existing dish
    public Optional<Dish> updateDish(Long id, Dish dishDetails) {
        Optional<Dish> optionalDish = dishRepository.findById(id);
        if (optionalDish.isPresent()) {
            Dish existingDish = optionalDish.get();
            existingDish.setName(dishDetails.getName());
            existingDish.setIngredients(dishDetails.getIngredients());
            existingDish.setPrice(dishDetails.getPrice());
            return Optional.of(dishRepository.save(existingDish));
        }
        return Optional.empty();
    }

    // Method to delete a dish by its ID
    public boolean deleteDish(Long id) {
        Optional<Dish> optionalDish = dishRepository.findById(id);
        if (optionalDish.isPresent()) {
            dishRepository.delete(optionalDish.get());
            return true;
        }
        return false;
    }
}
