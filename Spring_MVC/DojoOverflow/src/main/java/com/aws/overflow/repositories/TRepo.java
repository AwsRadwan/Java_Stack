package com.aws.overflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aws.overflow.models.Tag;

@Repository
public interface TRepo extends CrudRepository<Tag, Long> {
	List<Tag> findAll();
	Optional<Tag> findBySubject(String s);

}
