package com.aws.belt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aws.belt.models.Course;
import com.aws.belt.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	
	User findByEmail(String email);
	List<User> findAll();
	
//	List<User> findBy
	
//	@Query("SELECT e FROM User e WHERE state = ?1")
//	List<Course> findEventsInState(String state);

}
