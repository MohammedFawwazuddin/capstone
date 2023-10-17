package com.project.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.capstone.Entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
