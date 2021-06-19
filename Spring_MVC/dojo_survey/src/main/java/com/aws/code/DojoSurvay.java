package com.aws.code;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurvay {

	@RequestMapping("/")
	public String main() {
		return "main.jsp";
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(Model model, @RequestParam(value = "name") String name,
			@RequestParam(value = "loc") String location, @RequestParam(value = "lang") String language,
			@RequestParam(value = "comment") String comment) {
		if (comment.equals(null)) {
			model.addAttribute("name", name);
			model.addAttribute("location", location);
			model.addAttribute("language", language);
			return "result.jsp";
		}
		else {
			model.addAttribute("name", name);
			model.addAttribute("location", location);
			model.addAttribute("language", language);
			model.addAttribute("comment", comment);
			return "result.jsp";
		}
	}
	@RequestMapping("/result")
	public String result() {
		return "redirect:/";
	}
	

}
