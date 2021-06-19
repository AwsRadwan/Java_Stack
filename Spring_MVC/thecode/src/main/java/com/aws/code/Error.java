package com.aws.code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Error {
	
	@RequestMapping("/")
	public String wel() {
		return "main.jsp";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String result(RedirectAttributes x, @RequestParam(value="password") String password) {
		if(password.equals(null)) {
			return "result.jsp";
		}
		if(password.equals("bushido")) {
			return "result.jsp";
		}
		x.addFlashAttribute("error", "You must train harder, incorrect password!");
		return "redirect:/";
	}
}
