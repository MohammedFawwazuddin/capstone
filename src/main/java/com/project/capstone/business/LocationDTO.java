package com.project.capstone.business;

import lombok.Data;

@Data
public class LocationDTO {
    private String  address;
    
    private String aptSuite;

    private String city;

    private String state;

    private String zip;

    private String country;
}
