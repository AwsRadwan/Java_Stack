package com.aws.license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aws.license.models.License;
import com.aws.license.models.Person;
import com.aws.license.services.LicenseService;

@Controller
public class LicenseController {

	private final LicenseService licenseService;
	
	public LicenseController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/license")
	public String addLicense(Model model, @ModelAttribute("license") License license) {
		List<Person> persons = licenseService.allPersonWithout();
		model.addAttribute("persons", persons);
		return "license.jsp";
	}
	
	
	@RequestMapping(value="/addnewl", method = RequestMethod.POST)
    public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
    	if (result.hasErrors()) {
			return "/license.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/";
		}
    }
	
}
