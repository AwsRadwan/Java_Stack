package com.aws.belt.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aws.belt.models.Course;
import com.aws.belt.models.Courses_Users;
import com.aws.belt.models.User;
import com.aws.belt.repositories.CourseRepo;
import com.aws.belt.repositories.UandCRepo;
import com.aws.belt.repositories.UserRepo;

//import com.aws.events.models.Event;
//import com.aws.events.models.Message;
//import com.aws.events.models.User;
//import com.aws.events.repositories.EventsRepository;
//import com.aws.events.repositories.MessageRepository;
//import com.aws.events.repositories.UserRepository;

@Service
public class MainService {
	private final UserRepo userRepository;
	private final CourseRepo courseRepository;
	private final UandCRepo uandCRepo;
    
    public MainService(UserRepo userRepository, CourseRepo courseRepository, UandCRepo uandCRepo) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.uandCRepo = uandCRepo;
    }
    
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    public Course findCourseById(Long id) {
    	Optional<Course> e = courseRepository.findById(id);
    	
    	if(e.isPresent()) {
            return e.get();
    	} else {
    	    return null;
    	}
    }
    
//    public Message findMessageById(Long id) {
//    	Optional<Message> m = messageRepository.findById(id);
//    	
//    	if(m.isPresent()) {
//            return m.get();
//    	} else {
//    	    return null;
//    	}
//    }
    
    public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
    public List<User> getAllUsers(){
		return userRepository.findAll();
	}
//    public List<Message> getAllMessages(){
//		return messageRepository.findAll();
//	}
    
    public void deleteCourse(Long id) {
		this.courseRepository.deleteById(id);
	}
//    public void deleteMessage(Long id) {
//		this.messageRepository.deleteById(id);
//	}
    public void deleteUser(Long id) {
		this.userRepository.deleteById(id);
	}
    
    public void saveCourse(User user, Course event) {
		event.setHost(user);
		List<User> joiners = new ArrayList<>();
		joiners.add(user);
		event.setJoiners(joiners);
		this.courseRepository.save(event);
	}
    
    public void joinCourse(User user, Long eventID) {
		List<Course> joinedEvents = user.getJoinedCourses();
		Course event = this.findCourseById(eventID);
		if(!joinedEvents.contains(event)) {
			joinedEvents.add(event);
			user.setJoinedCourses(joinedEvents);
			this.userRepository.save(user);
		}
	}
    
    public void leaveCourse(User user, Long eventID) {
		List<Course> joinedEvents = user.getJoinedCourses();
		Course event = this.findCourseById(eventID);
		int indexOfEvent = joinedEvents.indexOf(event);
		if(indexOfEvent > -1 && !event.getHost().equals(user)) { // if the event is in the arraylist and the user isn't the host
			joinedEvents.remove(indexOfEvent);
		}
		user.setJoinedCourses(joinedEvents);
		this.userRepository.save(user);	
	}
//    
//    public void addMessage(Message message, Long eventID, User user) {
//		Event event = this.findEventById(eventID);
//		message.setEvent(event);
//		message.setAuthor(user);
//		this.messageRepository.save(message);
//	}
    
//    public void saveMessage(Message message) {
//		this.messageRepository.save(message);
//	}
    public void saveCourse(Course e) {
		this.courseRepository.save(e);
	}
    public void saveUser(User u) {
		this.userRepository.save(u);
	}
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public void editCourse(Long id, Course changedEvent) {
		Course original = this.findCourseById(id);
		original.setName(changedEvent.getName());
		original.setInstructer(changedEvent.getInstructer());
		original.setCapacity(changedEvent.getCapacity());
		this.courseRepository.save(original);
	}
//    public Date matchDate(User u, Course c) {
//    	Courses_Users uc = uandCRepo.findByUserAndCourse(u, c);
//    	return uc.getCreatedAt();
//    }
//    
    
}