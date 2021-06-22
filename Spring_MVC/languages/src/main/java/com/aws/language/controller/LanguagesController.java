package com.aws.language.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aws.language.models.Language;
import com.aws.language.services.LanguageService;

@Controller
public class LanguagesController {

private final LanguageService languageService;
    
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    @RequestMapping("/")
    public String main() {
        return "redirect:/languages";
    }
    
    @RequestMapping("/languages")
    public String index(@ModelAttribute("language") Language lang, Model model) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "/index.jsp";
    }
    
    @RequestMapping(value="/languages", method = RequestMethod.POST)
    public String addlang(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
    	if (result.hasErrors()) {
			return "/index.jsp";
		} else {
			languageService.createLanguage(lang);
			return "redirect:/languages";
		}
    }
    
    @RequestMapping("/languages/{id}/edit")
    public String editlang(@PathVariable("id") Long id, Model model) {
    	Language lang = languageService.findLanguage(id);
        model.addAttribute("lang", lang);
        return "/edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("lang") Language lang, BindingResult result) {
        if (result.hasErrors()) {
            return "/edit.jsp";
        } else {
            languageService.updateLanguage(lang);
            return "redirect:/languages";
        }
    }
	
    @RequestMapping(value="/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
    	Language lang = languageService.findLanguage(id);
        model.addAttribute("lang", lang);
		return "/show.jsp";
	}
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
    	Language lang = languageService.findLanguage(id);
    	languageService.deleteLanguage(lang);
    	return "redirect:/";
    }
}
