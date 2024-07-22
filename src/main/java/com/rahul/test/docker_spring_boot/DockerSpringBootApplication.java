package com.rahul.test.docker_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller

public class DockerSpringBootApplication {
	@GetMapping
	public String index(final Model model) {
		model.addAttribute("title", "Welcoum to Rahul Cloud..Azure DevOps!!");
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerSpringBootApplication.class, args);
	}

}
