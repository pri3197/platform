package com.gala.standardization.platform.service;



import com.gala.standardization.platform.entities.City;
import com.gala.standardization.platform.repository.CityRepository;
import org.springframework.stereotype.Service;



@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City getCityById(String cityId) {
        return cityRepository.findById(cityId).orElse(null);
    }
}
