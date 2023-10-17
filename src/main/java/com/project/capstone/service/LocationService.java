package com.project.capstone.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.capstone.Entity.Location;
import com.project.capstone.business.LocationDTO;
import com.project.capstone.repository.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public String getLocationInfo() {
        // Implement logic to fetch location information here, e.g., from a database or an external API.
        // Return a location string or object.
        return "Location: SomeLocationInfo";
    }

    public Boolean saveLocation(LocationDTO locationDTO) {
        try{
            Location location = new Location();
            location.setLocation(locationDTO.getAddress());
            location.setSuite(locationDTO.getAptSuite());
            location.setCity(locationDTO.getCity());
            location.setState(locationDTO.getState());
            location.setZipCode(locationDTO.getZip());
            location.setCountry(locationDTO.getCountry());
            locationRepository.save(location);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
