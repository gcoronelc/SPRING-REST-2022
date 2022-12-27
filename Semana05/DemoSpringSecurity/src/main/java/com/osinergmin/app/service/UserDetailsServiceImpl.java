package com.osinergmin.app.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.osinergmin.app.model.Role;
import com.osinergmin.app.model.User;
import com.osinergmin.app.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsernameAndDisabled(username, false);
		if (user == null) {
			throw new UsernameNotFoundException("No existe el usuario.");
		}
		return new org.springframework.security.core.userdetails
				.User(user.getUsername(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

}
