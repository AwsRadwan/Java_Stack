package com.aws.license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aws.license.models.License;
import com.aws.license.models.Person;
import com.aws.license.services.PersonService;

@Controller
@RequestMapping("/")
public class PersonController {

	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons", persons);
		
		return "index.jsp";
	}
	
	@RequestMapping("/person")
	public String addPerson(Model model, @ModelAttribute("person") Person person) {
		return "person.jsp";
	}
	
	@RequestMapping(value="/addnewp", method = RequestMethod.POST)
    public String addperson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
    	if (result.hasErrors()) {
			return "/person.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/";
		}
    }
	
	@RequestMapping("/person/{id}/details")
	public String details(Model model, @PathVariable("id") Long id) {
		Person person = personService.findPerson(id);
		model.addAttribute("person", person);
		return "details.jsp";
	}
	
}
