package liquidhacks.rallee.ralleebe.controller.rest;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import liquidhacks.rallee.ralleebe.model.UserDTO;
import liquidhacks.rallee.ralleebe.repository.LoginDB;

@RestController
class Register {
	private LoginDB userRepo;
	
	public Register(LoginDB userRepo) {
		this.userRepo = userRepo;
	}

	@PostMapping("/register")
	public void register(@RequestBody UserDTO user){
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userRepo.save(user);
	}
	
	@GetMapping("test")
	public Iterable getRegisteredUsers() {
		return userRepo.findAll();
	}
}