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
import liquidhacks.rallee.ralleebe.repository.LoginService;

@RestController
class Register {
	private LoginService userRepo;
	
	public Register(LoginService userRepo) {
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
		//user.setPassword(password);
		user.setId(UUID.randomUUID());
		user.setEmail(email);
		userRepo.save(user);
	}
	
	@PostMapping("/login")
	public void login(String email, String password) {
		
	}
	
	@GetMapping("/test")
	public Optional<UserDTO> getRegisteredByUsername(String email) {

		return userRepo.findByEmail(email);
	}
	
	
	@GetMapping("/getAll")
	public List<UserDTO> getAllRegisteredUsers() {
		return userRepo.findAll();
	}
	
}