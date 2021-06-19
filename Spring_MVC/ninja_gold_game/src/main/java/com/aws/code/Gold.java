package com.aws.code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Gold {
	
	public static int count=0;
	public static ArrayList<String> list = new ArrayList<String>();
//	HttpSession session;
	
	
	@RequestMapping("/")
	public String main(HttpSession session) {
		session.setAttribute("count", count);
		session.setAttribute("list", list);
		return "ninja.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addGold(@RequestParam(value = "hidden") String val) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		if(val.equals("hidden1")) {
			int randomNum = ThreadLocalRandom.current().nextInt(10, 21);
			count += randomNum;  
			LocalDateTime now = LocalDateTime.now();
			String x = String.format("earned %d golds from the farm! %s .", randomNum, dtf.format(now));
			list.add(x);
			return "redirect:/";
		}
		if(val.equals("hidden2")) {
			int r2 = ThreadLocalRandom.current().nextInt(5, 11);
			count += r2;
			LocalDateTime now = LocalDateTime.now();
			String x = String.format("earned %d golds from the Cave! %s .", r2, dtf.format(now));
			list.add(x);
			return "redirect:/";
		}
		if(val.equals("hidden3")) {
			int r3 = ThreadLocalRandom.current().nextInt(2, 6);
			count += r3;
			LocalDateTime now = LocalDateTime.now();
			String x = String.format("earned %d golds from the House! %s .", r3, dtf.format(now));
			list.add(x);
			return "redirect:/";
		}
		if(val.equals("hidden4")) {
			int r4 = ThreadLocalRandom.current().nextInt(-50, 51);
			count += r4;
			LocalDateTime now = LocalDateTime.now();
			String x = String.format("earned %d golds from the Casino! %s .", r4, dtf.format(now));
			list.add(x);
			return "redirect:/";
		}
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset() {
		count =0;
		list.clear();
		return "redirect:/";
	}
	
}
