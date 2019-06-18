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
import org.springframework.stereotype.Service;

import app.entities.RegisteredUser;
import app.entities.UserPermission;
import app.repositories.PermissionRepository;
import app.repositories.RegisteredUserRepository;
import app.utils.TokenUtils;


@Service
public class LoginService {
	
	@Autowired
	RegisteredUserService registeredUserService;

	@Autowired
	RegisteredUserRepository registeredUserRepository;

	@Autowired
	PermissionRepository permissionRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	public ResponseEntity<HashMap<String, String>> login(RegisteredUser registeredUser) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(registeredUser.getUsername(),
					registeredUser.getPassword());
			
			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			UserDetails details = userDetailsService.loadUserByUsername(registeredUser.getUsername());
			String userToken = tokenUtils.generateToken(details);
			
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("token", userToken);
			
			return new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<HashMap<String, String>>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	public void addPermssion(RegisteredUser registeredUser, String role) {
		registeredUser = registeredUserRepository.save(registeredUser);
		registeredUser.setUserPermission(new HashSet<UserPermission>());
		registeredUser.getUserPermission().add(new UserPermission(null, registeredUser, permissionRepository.findByTitle(role).get()));
		registeredUserRepository.save(registeredUser);
	}
	
}