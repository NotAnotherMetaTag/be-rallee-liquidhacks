package liquidhacks.rallee.ralleebe.controller.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Login {

	@PostMapping("/login")
	public String login(){
		return "Hello! Welcome to the Java Spring Boot Basic Rest Template.\n";
	}
}