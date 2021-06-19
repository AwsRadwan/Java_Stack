package com.aws.hello_human;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}
	
	@RequestMapping("")
	public String hello(@RequestParam(value="name", required = false) String name) {
		if(name == null) {
			return "<h1>Hello Human!</h1> <p>Welcome to SpringBoot</p>";
		}
		else {
			return String.format("<a style='float: right' href='/'>Go Back</a> <h1>Hello %s</h1>" + "<p>Welcome to SpringBoot</p>", name);
		}
	}

}
