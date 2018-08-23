package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
@Service
public class DBUserDetailsSerivce implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String lastName) throws UsernameNotFoundException {
		User user = userRepo.findByLastName(lastName);
		UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
				.username(user.getLastName()).password(user.getPassword()).roles(user.getRole().getUserRole()).build();

		return userDetails;
	}

}
