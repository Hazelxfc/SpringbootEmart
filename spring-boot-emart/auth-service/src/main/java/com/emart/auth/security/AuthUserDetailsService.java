package com.emart.auth.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.emart.auth.dao.UserDao;
import com.emart.auth.entity.UserEntity;

public class AuthUserDetailsService implements UserDetailsService {
	private UserDao userRepository;

	public AuthUserDetailsService(UserDao userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findUserByUserName(username);
		if (userEntity != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

			return new User(userEntity.getUserName(), userEntity.getPassword(), authorities);
		}

		throw new UsernameNotFoundException("User '" + username + "' not found.");
	}

}
