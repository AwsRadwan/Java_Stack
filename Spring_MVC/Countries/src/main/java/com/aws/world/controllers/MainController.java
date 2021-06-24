package com.aws.world.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aws.world.services.MainService;

@Controller
public class MainController {
	private final MainService ser;
	
	public MainController(MainService ser) {
		this.ser = ser;
	}
	
	@RequestMapping("/")
	public String main(Model model) {
		return "index.jsp";
	}
	@RequestMapping("/1")
	public String main1(Model model) {
		List<Object[]> arr = ser.findCSS();
		model.addAttribute("arr", arr);
		return "index.jsp";
	}
	@RequestMapping("/2")
	public String main2(Model model) {
		List<Object[]> arr2 = ser.findCBCC();
		model.addAttribute("arr2", arr2);
		return "index.jsp";
	}
	@RequestMapping("/3")
	public String main3(Model model) {
		List<Object[]> arr3 = ser.findC3();
		model.addAttribute("arr3", arr3);
		return "index.jsp";
	}
	@RequestMapping("/4")
	public String main4(Model model) {
		List<Object[]> arr4 = ser.findC4();
		model.addAttribute("arr4", arr4);
		return "index.jsp";
	}
	@RequestMapping("/5")
	public String main5(Model model) {
		List<Object[]> arr5 = ser.findC5();
		model.addAttribute("arr5", arr5);
		return "index.jsp";
	}
	@RequestMapping("/6")
	public String main6(Model model) {
		List<Object[]> arr6 = ser.findC6();
		model.addAttribute("arr6", arr6);
		return "index.jsp";
	}
	@RequestMapping("/7")
	public String main7(Model model) {
		List<Object[]> arr7 = ser.findC7();
		model.addAttribute("arr7", arr7);
		return "index.jsp";
	}
	@RequestMapping("/8")
	public String main8(Model model) {
		List<Object[]> arr8 = ser.findC8();
		model.addAttribute("arr8", arr8);
		return "index.jsp";
	}
	
	

}
