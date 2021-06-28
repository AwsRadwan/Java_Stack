package com.aws.overflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aws.overflow.models.Answer;
import com.aws.overflow.models.Question;
import com.aws.overflow.models.Tag;
import com.aws.overflow.services.MainService;

@Controller
public class Maincontroller {
	private final MainService ser;

	public Maincontroller(MainService ser) {
		this.ser = ser;
	}

	@RequestMapping("/")
	public String go() {
		return "redirect:/questions";
	}

	@RequestMapping("/questions")
	public String main(Model model) {
		model.addAttribute("qs", ser.findAllQ());
		return "index.jsp";
	}

	@RequestMapping("/questions/new")
	public String addnew(Model model, @ModelAttribute("ques") Question q, @ModelAttribute("tag") Tag t) {
		return "new.jsp";
	}

	@RequestMapping(value = "/add_q", method = RequestMethod.POST)
	public String addQ(Model model, @Valid @ModelAttribute("ques") Question q, @RequestParam("tag") String tag,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/new.jsp";
		} else {
			ser.creatQuestion(q);
			String str = tag;
			List<String> arr = Arrays.asList(str.trim().split("\\s*,\\s*"));

			// Create tags array list
			ArrayList<Tag> tags = new ArrayList<Tag>();
			for (int i = 0; i < arr.size(); i++) {
				tags.add(ser.createTag(arr.get(i)));
			}

			// Set tags to question
			q.setTags(tags);

			// Update question
			ser.saveQ(q);
			return "redirect:/questions";
		}
	}

	@RequestMapping("/questions/{id}")
	public String thisQ(Model model, @PathVariable("id") Long id, @ModelAttribute("ans") Answer a) {
		Question q = ser.findQ(id);
		model.addAttribute("q", q);
//		model.addAttribute("anss", q.getAnswers());
		return "answer.jsp";
	}
	
//	@RequestMapping("/questions/{id}")
//	public String thisQ(Model model, @PathVariable("id") Long id) {
//		Answer a = new Answer(); 
//		Question q = ser.findQ(id);
//		model.addAttribute("q", q);
//		model.addAttribute("ans", a);
//		return "answer.jsp";
//	}

	@RequestMapping(value = "/add_a/{id}", method = RequestMethod.POST)
	public String addA(Model model, @Valid @ModelAttribute("ans") Answer a, BindingResult result,
			@PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "/new.jsp";
		} else {
			ser.creatAnswer(a);
			return "redirect:/questions/{id}";
		}
	}

}
