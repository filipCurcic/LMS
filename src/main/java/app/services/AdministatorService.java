package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Administrator;
import app.repositories.AdministatorRepository;

@Service
public class AdministatorService {

	@Autowired
	AdministatorRepository adminRepository;
	
	@Autowired
	LoginService loginService;
	
	
	public AdministatorService() {
		
	}
	
	public List<Administrator> getAdministrator() {
		return adminRepository.findAll();
	}
	
	public Administrator getOne(Long id) {
		return adminRepository.findById(id).orElse(null);
	}
	
	public Administrator getByUsername(String username) {
		return adminRepository.getByUsername(username).orElse(null);
	}
	
	
	public void addAdministrator(Administrator admin) {
		loginService.addPermssion(admin.getRegisteredUser(), "ROLE_ADMINISTRATOR");
		adminRepository.save(admin);
	}
	
	public void removeAdministrator(Long id) {
		Optional<Administrator> admin= adminRepository.findById(id);
		if(admin.isPresent()) {
			adminRepository.delete(admin.get());
		}
	}
	
	public void updateAdministrator(Long id, Administrator administrator) {
		Optional<Administrator> admin= adminRepository.findById(id);
		if(admin.isPresent()) {
			administrator.setId(admin.get().getId());
			adminRepository.save(administrator);
		}
	}
	

}
