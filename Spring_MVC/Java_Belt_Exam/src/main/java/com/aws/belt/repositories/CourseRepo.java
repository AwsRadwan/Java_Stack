package com.aws.belt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aws.belt.models.Course;

public interface CourseRepo extends CrudRepository<Course, Long> {
    List<Course> findAll();
	
//	@Query("SELECT e FROM Event e WHERE state = ?1")
//	List<Course> findEventsInState(String state);
//	
//	@Query("SELECT e FROM Event e WHERE state <> ?1")
//	List<Course> findEventsExcludingState(String state);

}
