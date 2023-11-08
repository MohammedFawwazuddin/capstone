package com.project.capstone.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "features")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "name")
    private String name;

    @Column(name = "internal_name")
    private String internalName;
 
    @Column(name = "details")
    private String details;
 
    @OneToMany(cascade = CascadeType.ALL)
    private List<Parameter> parameters;
 
    public Feature() {
        this.parameters = new ArrayList<>();
    }

   

    // Getters and setters
}
