package com.project.capstone.repository;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.capstone.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public Optional<User> findByName(String name);

	public boolean existsByName(String name);

}
