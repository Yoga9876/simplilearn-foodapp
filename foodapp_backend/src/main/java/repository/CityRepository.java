package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.City;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    // Custom query method to find a city by its name
    Optional<City> findByName(String name);

    // Custom query method to find cities by a specific property (example)
    List<City> findByPopulationGreaterThan(int population);

    // You can add more custom query methods here based on your requirements
}

