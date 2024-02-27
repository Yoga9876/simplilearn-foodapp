package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Dish;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    // Custom query method to find a dish by its name
    Optional<Dish> findByName(String name);

    // Custom query method to find dishes by a specific property (example)
    List<Dish> findByPriceLessThan(double price);

    // You can add more custom query methods here based on your requirements
}

