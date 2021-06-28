package com.aws.user.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aws.user.models.User;
import com.aws.user.services.UserService;

@Controller
public class Users {
	
	 	private final UserService userService;
	    
	    public Users(UserService userService) {
	        this.userService = userService;
	    }
	    
	    @RequestMapping("/")
	    public String main() {
	    	return "redirect:/registration";
	    }
	    
	    @RequestMapping("/registration")
	    public String registerForm(@ModelAttribute("user") User user) {
	        return "registrationPage.jsp";
	    }
	    @RequestMapping("/login")
	    public String login() {
	        return "loginPage.jsp";
	    }
	    
	    @RequestMapping(value="/registration", method=RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	    	if (result.hasErrors()) {
				return "/registrationPage.jsp";
			} else {
				userService.registerUser(user);
				session.setAttribute("user_id", user.getId());
				return "redirect:/home";
			}
	    }
	    
	    @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	        if (userService.authenticateUser(email, password)) {
	        	session.setAttribute("user_id", userService.findByEmail(email).getId());
	        	return "redirect:/home";
	        }
	        else {
	        	model.addAttribute("error", "email or pasword is not correct");
	        	return "loginPage.jsp";
	        }
	    }
	    
	    @RequestMapping("/home")
	    public String home(HttpSession session, Model model) {
	        Long id = (Long)session.getAttribute("user_id");
	    	User u = userService.findUserById(id);
	    	model.addAttribute("user", u);
	    	return "homePage.jsp";
	    }
	    @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "loginPage.jsp";
	    }

}
