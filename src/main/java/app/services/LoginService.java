package app.services;


import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.entities.RegisteredUser;
import app.entities.UserPermission;
import app.repositories.PermissionRepository;
import app.repositories.RegisteredUserRepository;
import app.utils.Token;

@Service
public class LoginService {
	
	@Autowired
	private RegisteredUserService registeredUserService;
	
	@Autowired
	private RegisteredUserRepository registeredUserRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImp userDetailsService;
	
	@Autowired
	private Token tokenUtils;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public ResponseEntity<HashMap<String, String>> login(RegisteredUser registeredUser) {
		try {
			
			
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(registeredUser.getUsername(),
					registeredUser.getPassword());
			
			//Authentication authentication = authenticationManager.authenticate(token);
			//SecurityContextHolder.getContext().setAuthentication(authentication);
			
			UserDetails details = userDetailsService.loadUserByUsername(registeredUser.getUsername());
			String userToken = tokenUtils.generateToken(details);
			
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("token", userToken);
			
			return new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK);
			
		} catch (Exception e) {
			//e.printStackTrace();
			return new ResponseEntity<HashMap<String, String>>(HttpStatus.UNAUTHORIZED);
		}
	
	}

	public void addPermssion(RegisteredUser regUser, String role) {
		regUser.setPassword(passwordEncoder.encode(regUser.getPassword()));

		regUser = registeredUserRepository.save(regUser);
		regUser.setUserPermission(new HashSet<UserPermission>());
		regUser.getUserPermission().add(new UserPermission(null, regUser, permissionRepository.findByTitle(role).get()));
		registeredUserRepository.save(regUser);
	}
	
}
