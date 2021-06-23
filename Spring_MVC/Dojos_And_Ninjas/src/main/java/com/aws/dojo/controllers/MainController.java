package com.aws.dojo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aws.dojo.models.Dojo;
import com.aws.dojo.models.Ninja;
import com.aws.dojo.services.DandNService;

@Controller
public class MainController {
	
	private final DandNService ser;
	
	public MainController(DandNService ser) {
		this.ser = ser;
	}
	
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("dojos", ser.allDojos());
		model.addAttribute("ninjas", ser.allNinjas());
		return "index.jsp";
	}
	
	@RequestMapping("/dojo")
	public String dojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}

	@RequestMapping("/ninja")
	public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", ser.allDojos());
		return "ninja.jsp";
	}
	
	@RequestMapping(value="/adddojo", method = RequestMethod.POST)
    public String adddojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
    	if (result.hasErrors()) {
			return "/dojo.jsp";
		} else {
			ser.createDojo(dojo);
			return "redirect:/";
		}
    }
	
	@RequestMapping(value="/addninja", method = RequestMethod.POST)
    public String addninja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
    	if (result.hasErrors()) {
			return "/ninja.jsp";
		} else {
			ser.createNinja(ninja);
			return "redirect:/";
		}
    }
	
	@RequestMapping(value="/ninja/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Long id) {
		Ninja x = ser.findNinja(id);
		ser.deleteNinja(x);
		return "redirect:/";
	}
	@RequestMapping(value="/dojo/{id}", method = RequestMethod.POST)
	public String deleted(@PathVariable("id") Long id) {
		Dojo x = ser.findDojo(id);
		ser.deleteDojo(x);
		return "redirect:/";
	}
	
}
