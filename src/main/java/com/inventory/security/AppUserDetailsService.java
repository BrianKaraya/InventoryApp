package com.inventory.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.inventory.entities.user.User;
import com.inventory.entities.user.UserRepository;

public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.getUserByEmail(email);
		
		if (user != null) {
			return new AppUserDetails(user);
			
		}
		
		throw new UsernameNotFoundException("Could not find user with email: " + email);
	}

}
