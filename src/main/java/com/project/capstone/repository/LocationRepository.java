package com.project.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.capstone.Entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
    // You can add custom query methods here if needed.
}
