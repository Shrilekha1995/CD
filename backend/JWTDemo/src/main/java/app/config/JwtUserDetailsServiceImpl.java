package app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import app.model.User;
import app.repo.UserRepository;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("JwtUserDetailsServiceImpl loadUserByUsername()..");
		User user=userRepository.findByEmail(username);
		if(user ==null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
			
		}else {
			return JwtUserFactory.create(user);
		}
	}

	
}
