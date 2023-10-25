package com.project.capstone.BusinessTests;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.capstone.business.LocationDTO;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class LocationDTOTest {

    @InjectMocks
    private LocationDTO locationDTO;

    @Test
    public void testGettersAndSetters() {

        locationDTO.setAddress("123 Main St");
        locationDTO.setAptSuite("Apt 4B");
        locationDTO.setCity("New York");
        locationDTO.setState("NY");
        locationDTO.setZip("10001");
        locationDTO.setCountry("USA");

        assert locationDTO.getAddress().equals("123 Main St");
        assert locationDTO.getAptSuite().equals("Apt 4B");
        assert locationDTO.getCity().equals("New York");
        assert locationDTO.getState().equals("NY");
        assert locationDTO.getZip().equals("10001");
        assert locationDTO.getCountry().equals("USA");
    }

    @Test
    public void testSetAddress() {

        locationDTO.setAddress("456 Elm St");

        assert locationDTO.getAddress().equals("456 Elm St");
    }

}
