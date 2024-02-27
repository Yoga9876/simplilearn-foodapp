package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Restaurant;
import repository.RestaurantRepository;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // Method to retrieve all restaurants
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    // Method to retrieve a restaurant by its ID
    public Restaurant getRestaurantById(Long id) {
        // Use the restaurantRepository to fetch the restaurant by its ID
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        // Check if the restaurant exists
        if (optionalRestaurant.isPresent()) {
            // If the restaurant exists, return it
            return optionalRestaurant.get();
        } else {
            // If the restaurant does not exist, return null
            return null;
        }
    }

    // Method to create a new restaurant
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // Method to update an existing restaurant
    public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails) {
        // Check if the restaurant with the given ID exists
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            // If the restaurant exists, update its details
            Restaurant existingRestaurant = optionalRestaurant.get();
            // Set the updated details from the restaurantDetails object
            existingRestaurant.setName(restaurantDetails.getName());
            existingRestaurant.setAddress(restaurantDetails.getAddress());
            existingRestaurant.setPhoneNumber(restaurantDetails.getPhoneNumber());
            // Save the updated restaurant to the database
            return restaurantRepository.save(existingRestaurant);
        } else {
            // If the restaurant does not exist, return null
            return null;
        }
    }

    // Method to delete a restaurant by its ID
    public boolean deleteRestaurant(Long id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            restaurantRepository.delete(optionalRestaurant.get());
            return true;
        }
        return false;
    }
}
