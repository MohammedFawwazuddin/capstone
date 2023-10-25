
package com.project.capstone.EntityTests;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.project.capstone.Entity.Location;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class LocationTest {

    @Mock
    Location location; // Mock the Location class

    @Test
    public void testConstructor() {
        location = new Location(); // Create an instance of Location

        // You can add assertions here to verify the default state of the object
    }

    @Test
    public void testGettersAndSetters() {
        // Create a Location instance
        Location location = new Location();
        
        // Set some values
        location.setLocation("TestLocation");
        location.setSuite("TestSuite");
        location.setCity("TestCity");
        location.setState("TestState");
        location.setZipCode("TestZipCode");
        location.setCountry("TestCountry");

        // Use getters to retrieve values and assert them
        assertEquals("TestLocation", location.getLocation());
        assertEquals("TestSuite", location.getSuite());
        assertEquals("TestCity", location.getCity());
        assertEquals("TestState", location.getState());
        assertEquals("TestZipCode", location.getZipCode());
        assertEquals("TestCountry", location.getCountry());
    }
}
