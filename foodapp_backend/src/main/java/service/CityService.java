package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.City;
import repository.CityRepository;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City cityDetails) {
        City city = cityRepository.findById(id).orElse(null);
        if (city != null) {
            // Update city details here
            city.setName(cityDetails.getName());
            // Update other fields as needed
            return cityRepository.save(city);
        }
        return null; // Return null if city is not found
    }

    public boolean deleteCity(Long id) {
        City city = cityRepository.findById(id).orElse(null);
        if (city != null) {
            cityRepository.delete(city);
            return true;
        }
        return false; // Return false if city is not found
    }
}

