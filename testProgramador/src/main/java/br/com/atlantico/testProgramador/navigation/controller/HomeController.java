package br.com.atlantico.testProgramador.navigation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
@CrossOrigin(origins = "*")
public class HomeController {

	@GetMapping
	public String home() {
		return "home";
	}
	
}
