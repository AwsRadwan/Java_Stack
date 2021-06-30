package com.aws.belt.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aws.belt.models.Course;
import com.aws.belt.models.User;
import com.aws.belt.services.MainService;
import com.aws.belt.services.UserService;

//import com.aws.events.models.Event;
//import com.aws.events.models.Message;
//import com.aws.events.models.User;
//import com.aws.events.services.EventsService;
//import com.aws.events.services.UserService;

@Controller
@RequestMapping("/courses")
public class MainController {
	
	private UserService userService;
    private MainService mainService;
    
    
    public MainController(UserService userService, MainService eventService) {
        this.userService = userService;
        this.mainService = eventService;


    }
    
    @RequestMapping("")
    public String eventsPage(Model model, HttpSession session, @ModelAttribute("newEvent") Course newEvent) {
    	Long id = (Long)session.getAttribute("user_id");
    	User u = userService.findUserById(id);
    	model.addAttribute("user", u);
    	model.addAttribute("courses", mainService.getAllCourses());
    	return "homePage.jsp";
    }
    
    @RequestMapping("/new")
    public String newCourse(Model model, HttpSession session, @ModelAttribute("newCourse") Course newCourse) {
    	Long id = (Long)session.getAttribute("user_id");
    	User u = userService.findUserById(id);
    	model.addAttribute("user", u);
    	return "new.jsp";
    }
    
    
    @RequestMapping(value="", method=RequestMethod.POST)
    public String newEvent(@Valid @ModelAttribute("newCourse") Course newCourse, BindingResult result, Model model, HttpSession session) {
    	Long id = (Long)session.getAttribute("user_id");
    	User u = userService.findUserById(id);
    	mainService.saveUser(u);
    	if(result.hasErrors()) {
    		model.addAttribute("user", u);
        	model.addAttribute("events", mainService.getAllCourses());
    		return "new.jsp";
    	}
    	else {
    		this.mainService.saveCourse(u, newCourse);
    		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        	Date date = new Date(System.currentTimeMillis());
        	u.setDate(dateFormat.format(date));
        	mainService.saveUser(u);
    		return "redirect:/courses";
    	}
    }
    
    @RequestMapping("/{id}/join")
    public String joinEvent(@PathVariable("id") long id, HttpSession session) {
    	Long iddd = (Long)session.getAttribute("user_id");
    	User u = userService.findUserById(iddd);
    	this.mainService.joinCourse(u, id);
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Date date = new Date(System.currentTimeMillis());
    	u.setDate(dateFormat.format(date));
    	mainService.saveUser(u);
    	return "redirect:/courses";
    }
    
    @RequestMapping("/{id}/cancel")
    public String cancelEvent(@PathVariable("id") long id, HttpSession session) {
    	Long iddd = (Long)session.getAttribute("user_id");
    	User u = userService.findUserById(iddd);
    	this.mainService.leaveCourse(u, id);
    	return "redirect:/courses";
    }
    
    @RequestMapping("/{id}/delete")
    public String deleteCourse(@PathVariable("id") long id) {
    	this.mainService.deleteCourse(id);
    	return "redirect:/courses";
    }
    
    @RequestMapping("/{id}/edit")
    public String editCourse(@PathVariable("id") long id, Model model) {
    	model.addAttribute("course", mainService.findCourseById(id));
    	return "edit.jsp";
    }
    
    @RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
    public String editCourseSubmit(@PathVariable("id") long id, @Valid @ModelAttribute("course") Course course, BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		return "edit.jsp";
    	}
    	else {
    		this.mainService.editCourse(id, course);
    		return "redirect:/courses";
    	}
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String course(@PathVariable("id") long id, Model model, HttpSession session) {
    	Course c = this.mainService.findCourseById(id);
    	List<User> list = c.getJoiners();
    	model.addAttribute("course", c);
    	Long iddd = (Long)session.getAttribute("user_id");
    	User u = userService.findUserById(iddd);
    	model.addAttribute("user", u);
    	return "course.jsp";
    }
    
//    @RequestMapping(value="/{id}", method=RequestMethod.POST)
//    public String addComment(@PathVariable("id") long id, HttpSession session, @RequestParam(value="text", required=true) String text) {
//    	if(text.length() == 0) {
//    		return "event.jsp";
//    	}
//    	else {
//    		Long iddd = (Long)session.getAttribute("user_id");
//        	User user = userService.findUserById(iddd);
//            Message message = new Message();
//            message.setText(text);
//    		this.eventService.addMessage(message, id, user);
//    		return "redirect:/events/" + id;	
//    	}
//    }

}


