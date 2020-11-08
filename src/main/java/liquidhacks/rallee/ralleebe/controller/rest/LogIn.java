package liquidhacks.rallee.ralleebe.controller.rest;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import liquidhacks.rallee.ralleebe.model.LoginUserDetails;
import liquidhacks.rallee.ralleebe.model.UserDTO;


@SessionAttributes({"currentUser"})
@RestController
class Login {

	@GetMapping("/login")
	public String login() {
		
		
		return "login!";
	}
	
	@PostMapping("/postLogin")
	public String postLogin(Model model, HttpSession session) {
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		validatePrincipal(auth.getPrincipal());
		UserDTO loggedInUser = ((LoginUserDetails) auth.getPrincipal()).getUserDetails();
		
		model.addAttribute("currentUser", loggedInUser.getEmail());
		session.setAttribute("userId", loggedInUser.getId());
		
		return "redirect:/wallPage";
		
	}
	
	private void validatePrincipal(Object principal) {
		if (!(principal instanceof UserDTO)) {
			throw new IllegalArgumentException("Principal cannot be null");
		}
	}
}