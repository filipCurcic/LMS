package app.services;

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
	
	public Iterable<Administrator> getAdministrator() {
		return adminRepository.findAll();
	}
	
	public Optional<Administrator> getOne(Long id) {
		return adminRepository.findById(id);
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
