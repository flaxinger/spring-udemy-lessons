package com.flaxinger.springlearnudemyfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class SpringLearnUdemyFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnUdemyFinalApplication.class, args);
	}

	@RequestMapping("/")
	public String home(){
		return "home";
	}
}
