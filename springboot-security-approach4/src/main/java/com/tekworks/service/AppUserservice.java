package com.tekworks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tekworks.entity.AppUser;
import com.tekworks.repository.AppUserRepository;

@Service
public class AppUserservice implements UserDetailsService {

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> user = appUserRepository.findByUsername(username);
		if(user.isPresent())
		return user.get();
		throw new UsernameNotFoundException("user not found!!!");
	}

}
