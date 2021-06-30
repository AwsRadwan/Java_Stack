package com.aws.belt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aws.belt.models.Course;
import com.aws.belt.models.Courses_Users;
import com.aws.belt.models.User;

@Repository
public interface UandCRepo extends CrudRepository<Courses_Users, Long> {
	Courses_Users findByUserAndCourse(User u, Course c);

}
