package com.aws.events.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aws.events.models.User;
import com.aws.events.services.UserService;
import com.aws.events.validator.UserValidator;

@Controller
public class UserController {
	
	 	private final UserService userService;
	    private final UserValidator userValidator;
	    private static ArrayList<String> states = new ArrayList<String>();
	    
	    public UserController(UserService userService, UserValidator userValidator) {
	        this.userService = userService;
	        this.userValidator = userValidator;
	        
	        states.add("VA");
	        states.add("MD");
	        states.add("DC");
	        states.add("NC");
	        states.add("SC");
	        states.add("WV");
	        states.add("PA");
	    }
	    
	    @RequestMapping("/")
	    public String main() {
	    	return "redirect:/registration";
	    }
	    
	    @RequestMapping("/registration")
	    public String registerForm(@ModelAttribute("user") User user, Model model) {
	    	model.addAttribute("states", states);
	        return "loginAndRegistration.jsp";
	    }

	    
	    @RequestMapping(value="/registration", method=RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	    	userValidator.validate(user, result);
	    	if (result.hasErrors()) {
				return "/loginAndRegistration.jsp";
			} else {
				userService.registerUser(user);
				session.setAttribute("user_id", user.getId());
				return "redirect:/events";
			}
	    }
	    
	    @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, @ModelAttribute("user") User user) {
	        if (userService.authenticateUser(email, password)) {
	        	session.setAttribute("user_id", userService.findByEmail(email).getId());
	        	return "redirect:/events";
	        }
	        else {
	        	model.addAttribute("error", "email or pasword is not correct");
	        	return "/loginAndRegistration.jsp";
	        }
	    }
	    

	    @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/";
	    }

}

