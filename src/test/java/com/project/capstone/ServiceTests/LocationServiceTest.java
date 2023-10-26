package com.project.capstone.ServiceTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.capstone.business.LocationDTO;
import com.project.capstone.entity.Location;
import com.project.capstone.repository.LocationRepository;
import com.project.capstone.service.LocationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class LocationServiceTest {

    @InjectMocks
    private LocationService locationService;

    @Mock
    private LocationRepository locationRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetLocationInfo() {
        String expectedLocationInfo = "Location: SomeLocationInfo";

        // Call the method and check if it returns the expected information
        String locationInfo = locationService.getLocationInfo();
        assertEquals(expectedLocationInfo, locationInfo);
    }

    @Test
    public void testSaveLocation() {
        // Create a LocationDTO for testing
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setAddress("123 Main St");
        locationDTO.setAptSuite("Apt 101");
        locationDTO.setCity("City");
        locationDTO.setState("State");
        locationDTO.setZip("12345");
        locationDTO.setCountry("Country");

        // Create a Location entity for testing
        Location location = new Location();
        location.setLocation(locationDTO.getAddress());
        location.setSuite(locationDTO.getAptSuite());
        location.setCity(locationDTO.getCity());
        location.setState(locationDTO.getState());
        location.setZipCode(locationDTO.getZip());
        location.setCountry(locationDTO.getCountry());

        // Mock the save method of LocationRepository
        when(locationRepository.save(Mockito.any(Location.class))).thenReturn(location);

        // Call the saveLocation method and check if it returns true
        assertTrue(locationService.saveLocation(locationDTO));
    }

    @Test
    public void testSaveLocationWithError() {
        // Mock the save method of LocationRepository to throw an exception
        when(locationRepository.save(Mockito.any(Location.class))).thenThrow(new RuntimeException("Test exception"));

        // Call the saveLocation method and check if it returns false
        assertFalse(locationService.saveLocation(new LocationDTO()));
    }

    @Test
    public void testFindLocationById() {
        long locationId = 1L;
        Location location = new Location();
        location.setId(locationId);

        // Mock the findById method of LocationRepository
        when(locationRepository.findById(locationId)).thenReturn(Optional.of(location));

        // Call the findLocationById method and check if it returns the expected Location
        Optional<Location> foundLocation = locationService.findLocationById(locationId);
        assertTrue(foundLocation.isPresent());
        assertEquals(locationId, foundLocation.get().getId());
    }

    @Test
    public void testFindAllLocations() {
        // Create a list of Location entities for testing
        List<Location> locations = new ArrayList<>();
        locations.add(new Location());
        locations.add(new Location());

        // Mock the findAll method of LocationRepository
        when(locationRepository.findAll()).thenReturn(locations);

        // Call the findAllLocations method and check if it returns the list of locations
        List<Location> foundLocations = locationService.findAllLocations();
        assertEquals(locations.size(), foundLocations.size());
    }
}

