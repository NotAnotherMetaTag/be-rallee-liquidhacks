package liquidhacks.rallee.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hello")
class Hello {

	@GetMapping("/")
	public String Controller(){
		return "Hello! Welcome to the Java Spring Boot Basic Rest Template.\n";
	}
}