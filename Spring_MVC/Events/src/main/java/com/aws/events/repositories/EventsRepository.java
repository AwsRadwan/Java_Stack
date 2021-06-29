package com.aws.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.aws.events.models.Event;

@Repository
public interface EventsRepository extends CrudRepository<Event, Long> {
	List<Event> findAll();
	
	@Query("SELECT e FROM Event e WHERE state = ?1")
	List<Event> findEventsInState(String state);
	
	@Query("SELECT e FROM Event e WHERE state <> ?1")
	List<Event> findEventsExcludingState(String state);

}
