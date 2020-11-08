package liquidhacks.rallee.ralleebe.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import liquidhacks.rallee.ralleebe.model.UserDTO;
import liquidhacks.rallee.ralleebe.repository.LoginDB;

import java.util.Collections;

@Component
public class UserDetailsServiceImplementation implements UserDetailsService {
	private LoginDB userRepository;
	public UserDetailsServiceImplementation(LoginDB userRepository)    {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException    {
		UserDTO user = userRepository.findByEmail(email).get();
		if(user == null)
		{
			throw new UsernameNotFoundException(email);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.emptyList());
	}
}