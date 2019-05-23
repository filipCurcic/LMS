package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.AdministratorStaff;
import app.repositories.AdministratorStaffRepository;

@Service
public class AdministratorStaffService {

	@Autowired
	AdministratorStaffRepository administratorStaffRepository;
	
	@Autowired
	LoginService loginService;
	
	public Iterable<AdministratorStaff> getAdministratorStaff() {
		return administratorStaffRepository.findAll();
	}
	
	public Optional<AdministratorStaff> getOne(Long id) {
		return administratorStaffRepository.findById(id);
	}
	
	public void addAdministratorStaff(AdministratorStaff adminStaff) {
		loginService.addPermssion(adminStaff.getRegisteredUser(), "ROLE_ADMINISTRATION_STAFF");
		administratorStaffRepository.save(adminStaff);
	}
	
	public void removeAdministratorStaff(Long id) {
		Optional<AdministratorStaff> adminStaff = administratorStaffRepository.findById(id);
		if(adminStaff.isPresent()) {
			administratorStaffRepository.delete(adminStaff.get());
		}
	}
	
	public void updateAdministrationStaff(Long id, AdministratorStaff adminStaff) {
		Optional<AdministratorStaff> as = administratorStaffRepository.findById(id);
		if(as.isPresent()) {
			adminStaff.setId(as.get().getId());
			administratorStaffRepository.save(adminStaff);
		}
	}
	
	
}
