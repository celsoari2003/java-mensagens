package br.com.atlantico.testProgramador.navigation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*")
public class LoginController {

	@GetMapping
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
