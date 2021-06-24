package com.aws.world.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aws.world.models.City;
import com.aws.world.models.Country;
import com.aws.world.models.Language;

@Repository
public interface LangRepository extends CrudRepository<Language, Integer> {

	
	
}