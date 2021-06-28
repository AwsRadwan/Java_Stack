package com.aws.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aws.overflow.models.Answer;

@Repository
public interface ARepo extends CrudRepository<Answer, Long> {

	List<Answer> findAll();
	
}
