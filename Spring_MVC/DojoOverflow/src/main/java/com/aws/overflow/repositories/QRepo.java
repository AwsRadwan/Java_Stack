package com.aws.overflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aws.overflow.models.Question;

@Repository
public interface QRepo extends CrudRepository<Question, Long> {
	List<Question> findAll();
	Optional<Question> findById(Long id);

}
