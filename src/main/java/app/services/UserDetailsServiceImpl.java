package app.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.entities.RegisteredUser;
import app.entities.UserPermission;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	RegisteredUserService registeredUserService;
	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<RegisteredUser> regUser = registeredUserService.getRegisteredUserByUserName(username);
		
		if(regUser.isPresent()) {
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			for(UserPermission userPermission : regUser.get().getUserPermission()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(userPermission.getPermission().getTitle()));
			}
			
			return new org.springframework.security.core.userdetails.User(regUser.get().getUsername(), regUser.get().getPassword(), grantedAuthorities);
		}
		
		return null;
	}
}