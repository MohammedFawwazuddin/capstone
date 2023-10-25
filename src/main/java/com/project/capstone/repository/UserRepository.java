package com.project.capstone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.capstone.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	 public Optional<User> findByName(String username);
	// public Optional<User> findById(Long id);
	 public boolean existsByName(String name);


}
