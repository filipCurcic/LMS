package app.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import app.entities.RegisteredUser;
import app.entities.UserPermission;

@Component
public class UserDetailsServiceImp implements UserDetailsService {

	
	@Autowired
	RegisteredUserService registeredUserService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<RegisteredUser> registeredUser= registeredUserService.getRegisteredUserByUserName(username);
		
		if(registeredUser.isPresent()) {
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			for(UserPermission userPermission : registeredUser.get().getUserPermission()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(userPermission.getPermission().getTitle()));
			}
			
			return new org.springframework.security.core.userdetails.User(registeredUser.get().getUsername(), registeredUser.get().getPassword(), grantedAuthorities);
		}
		
		return null;
	}
}
