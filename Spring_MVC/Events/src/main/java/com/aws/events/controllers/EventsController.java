package com.aws.events.controllers;

import java.util.ArrayList;

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

import com.aws.events.models.Event;
import com.aws.events.models.Message;
import com.aws.events.models.User;
import com.aws.events.services.EventsService;
import com.aws.events.services.UserService;

@Controller
@RequestMapping("/events")
public class EventsController {
	
	private UserService userService;
    private EventsService eventService;
    private static ArrayList<String> states = new ArrayList<String>();
    
    
    public EventsController(UserService userService, EventsService eventService) {
        this.userService = userService;
        this.eventService = eventService;
        
        states.add("VA");
        states.add("MD");
        states.add("DC");
        states.add("NC");
        states.add("SC");
        states.add("WV");
        states.add("PA");

    }
    
    @RequestMapping("")
    public String eventsPage(Model model, HttpSession session, @ModelAttribute("newEvent") Event newEvent) {
    	Long id = (Long)session.getAttribute("user_id");
    	User u = userService.findUserById(id);
    	model.addAttribute("user", u);
    	model.addAttribute("events", eventService.getAllEvents());
        model.addAttribute("states", states);
    	return "homePage.jsp";
    }
    
    @RequestMapping(value="", method=RequestMethod.POST)
    public String newEvent(@Valid @ModelAttribute("newEvent") Event event, BindingResult result, Model model, HttpSession session) {
    	Long id = (Long)session.getAttribute("user_id");
    	User u = userService.findUserById(id);
        eventService.saveUser(u);
    	if(result.hasErrors()) {
    		model.addAttribute("user", u);
        	model.addAttribute("events", eventService.getAllEvents());
            model.addAttribute("states", states);
    		return "homePage.jsp";
    	}
    	else {
    		this.eventService.saveEvent(u, event);
    		return "redirect:/events";
    	}
    }
    
    @RequestMapping("/{id}/join")
    public String joinEvent(@PathVariable("id") long id, HttpSession session) {
    	Long iddd = (Long)session.getAttribute("user_id");
    	User u = userService.findUserById(iddd);
    	this.eventService.joinEvent(u, id);
    	return "redirect:/events";
    }
    
    @RequestMapping("/{id}/cancel")
    public String cancelEvent(@PathVariable("id") long id, HttpSession session) {
    	Long iddd = (Long)session.getAttribute("user_id");
    	User u = userService.findUserById(iddd);
    	this.eventService.leaveEvent(u, id);
    	return "redirect:/events";
    }
    
    @RequestMapping("/{id}/delete")
    public String deleteEvent(@PathVariable("id") long id) {
    	this.eventService.deleteEvent(id);
    	return "redirect:/events";
    }
    
    @RequestMapping("/{id}/edit")
    public String editEvent(@PathVariable("id") long id, Model model) {
    	model.addAttribute("event", eventService.findEventById(id));
    	model.addAttribute("states", states);
    	return "edit.jsp";
    }
    
    @RequestMapping(value="/{id}/edit", method=RequestMethod.POST)
    public String editEventSubmit(@PathVariable("id") long id, @Valid @ModelAttribute("event") Event event, BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		return "edit.jsp";
    	}
    	else {
    		this.eventService.editEvent(id, event);
    		return "redirect:/events";
    	}
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String event(@PathVariable("id") long id, Model model) {
    	model.addAttribute("event", this.eventService.findEventById(id));
    	return "event.jsp";
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public String addComment(@PathVariable("id") long id, HttpSession session, @RequestParam(value="text", required=true) String text) {
    	if(text.length() == 0) {
    		return "event.jsp";
    	}
    	else {
    		Long iddd = (Long)session.getAttribute("user_id");
        	User user = userService.findUserById(iddd);
            Message message = new Message();
            message.setText(text);
    		this.eventService.addMessage(message, id, user);
    		return "redirect:/events/" + id;	
    	}
    }

}
