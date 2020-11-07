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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException    {
		UserDTO user = userRepository.findByUsername(username).get();
		if(user == null)
		{
			throw new UsernameNotFoundException(username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
	}
}