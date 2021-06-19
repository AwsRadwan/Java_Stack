package com.aws.spring_routing.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class DojoController {
	@RequestMapping("")
	public String hello() {
		return "The dojo is awesome!";
	}
	@RequestMapping("/dojo-{a}")
	public String site(@PathVariable("a") String a) {
		return a + " is located in Southern California";
	}
	@RequestMapping("/{b}")
	public String java(@PathVariable("b") String b) {
		return b + " is better!";
	}
}
