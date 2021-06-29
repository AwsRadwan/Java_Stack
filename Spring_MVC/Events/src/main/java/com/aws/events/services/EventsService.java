package com.aws.events.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aws.events.models.Event;
import com.aws.events.models.Message;
import com.aws.events.models.User;
import com.aws.events.repositories.EventsRepository;
import com.aws.events.repositories.MessageRepository;
import com.aws.events.repositories.UserRepository;

@Service
public class EventsService {
	private final UserRepository userRepository;
	private final EventsRepository eventRepository;
	private final MessageRepository messageRepository;
    
    public EventsService(UserRepository userRepository, EventsRepository eventRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.messageRepository = messageRepository;
    }
    
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    public Event findEventById(Long id) {
    	Optional<Event> e = eventRepository.findById(id);
    	
    	if(e.isPresent()) {
            return e.get();
    	} else {
    	    return null;
    	}
    }
    
    public Message findMessageById(Long id) {
    	Optional<Message> m = messageRepository.findById(id);
    	
    	if(m.isPresent()) {
            return m.get();
    	} else {
    	    return null;
    	}
    }
    
    public List<Event> getAllEvents(){
		return eventRepository.findAll();
	}
    public List<User> getAllUsers(){
		return userRepository.findAll();
	}
    public List<Message> getAllMessages(){
		return messageRepository.findAll();
	}
    
    public void deleteEvent(Long id) {
		this.eventRepository.deleteById(id);
	}
    public void deleteMessage(Long id) {
		this.messageRepository.deleteById(id);
	}
    public void deleteUser(Long id) {
		this.userRepository.deleteById(id);
	}
    
    public void saveEvent(User user, Event event) {
		event.setHost(user);
		List<User> joiners = new ArrayList<>();
		joiners.add(user);
		event.setJoiners(joiners);
		this.eventRepository.save(event);
	}
    
    public void joinEvent(User user, Long eventID) {
		List<Event> joinedEvents = user.getJoinedEvents();
		Event event = this.findEventById(eventID);
		if(!joinedEvents.contains(event)) {
			joinedEvents.add(event);
			user.setJoinedEvents(joinedEvents);
			this.userRepository.save(user);
		}
	}
    
    public void leaveEvent(User user, Long eventID) {
		List<Event> joinedEvents = user.getJoinedEvents();
		Event event = this.findEventById(eventID);
		int indexOfEvent = joinedEvents.indexOf(event);
		if(indexOfEvent > -1 && !event.getHost().equals(user)) { // if the event is in the arraylist and the user isn't the host
			joinedEvents.remove(indexOfEvent);
		}
		user.setJoinedEvents(joinedEvents);
		this.userRepository.save(user);	
	}
    
    public void addMessage(Message message, Long eventID, User user) {
		Event event = this.findEventById(eventID);
		message.setEvent(event);
		message.setAuthor(user);
		this.messageRepository.save(message);
	}
    
    public void saveMessage(Message message) {
		this.messageRepository.save(message);
	}
    public void saveEvent(Event e) {
		this.eventRepository.save(e);
	}
    public void saveUser(User u) {
		this.userRepository.save(u);
	}
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public void editEvent(Long id, Event changedEvent) {
		Event original = this.findEventById(id);
		original.setName(changedEvent.getName());
		original.setDate(changedEvent.getDate());
		original.setCity(changedEvent.getCity());
		original.setState(changedEvent.getState());
		this.eventRepository.save(original);
	}
    
    
}
