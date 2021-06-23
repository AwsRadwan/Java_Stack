package com.aws.dojo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aws.dojo.models.Dojo;
import com.aws.dojo.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>, JpaRepository<Ninja, Long> {
	List<Ninja> findAll();
	long countByDojo(Dojo dojo);
	
}
