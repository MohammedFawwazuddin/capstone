package com.project.capstone.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.capstone.entity.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {
}

