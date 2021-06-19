package com.aws.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Counter {
	public int counter=0;
	
	@RequestMapping("/")
	public String wel() {
		counter++;
		return "welcome.jsp";
	}
	
	@RequestMapping("/count")
	public String count(HttpSession session) {
		session.setAttribute("count", counter);
		return "count.jsp";
	}
}
