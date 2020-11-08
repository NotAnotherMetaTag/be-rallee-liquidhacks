package liquidhacks.rallee.ralleebe.controller.rest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import liquidhacks.rallee.ralleebe.model.UserDTO;
import liquidhacks.rallee.ralleebe.repository.LoginDB;

@RestController
class Register {
	private LoginDB userRepo;
	
	public Register(LoginDB userRepo) {
		this.userRepo = userRepo;
	}

	@GetMapping("/signup")
	public String showRegistrationForm(WebRequest request, Model model) {
	    UserDTO userDto = new UserDTO();
	    model.addAttribute("user", userDto);
	    return "registration";
	}
	
	@PostMapping("/signup")
	public void signup(String email, String password){
		UserDTO user = new UserDTO();
		user.setPassword(new BCryptPasswordEncoder().encode(password));
		user.setId(UUID.randomUUID());
		user.setEmail(email);
		userRepo.save(user);
	}
	
	@GetMapping("/test")
	public Optional<UserDTO> getRegisteredByUsername(String id) {

		return userRepo.findById(id);
	}
	
	
	@GetMapping("/getAll")
	public List<UserDTO> getAllRegisteredUsers() {
		return userRepo.findAll();
	}
	
}