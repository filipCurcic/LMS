package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.RegisteredUser;
import app.repositories.RegisteredUserRepository;

@Service
public class RegisteredUserService {

	@Autowired
	private RegisteredUserRepository registeredUserRepository;
	
	public List<RegisteredUser> getRegisteredUser() {
		return registeredUserRepository.findAll();
	}
	
	public RegisteredUser getOne(Long id) {
		return registeredUserRepository.findById(id).orElse(null);
	}
	
	public Optional<RegisteredUser> getRegisteredUserByUserName(String username) {
        return registeredUserRepository.findByUsername(username);
    }
	
	public void addUser(RegisteredUser registerredUser) {
		registeredUserRepository.save(registerredUser);
	}
	
	public void removeRegisteredUser(Long id) {
		Optional<RegisteredUser> reg= registeredUserRepository.findById(id);
		if(reg.isPresent()) {
			registeredUserRepository.delete(reg.get());
		}
	}
	
	public void updateUser(Long id, RegisteredUser registeredUser) {
		Optional<RegisteredUser> reg = registeredUserRepository.findById(id);
		if(reg.isPresent()) {
			registeredUser.setId(reg.get().getId());
			registeredUser.setUsername(reg.get().getUsername());
			registeredUser.setPassword(reg.get().getPassword());
			registeredUserRepository.save(registeredUser);
		}
	}

}
