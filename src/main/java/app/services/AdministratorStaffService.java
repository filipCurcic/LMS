package app.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.entities.AdministratorStaff;
import app.entities.Student;
import app.entities.StudentOnYear;
import app.entities.StudyYear;
import app.repositories.AdministratorStaffRepository;

@Service
public class AdministratorStaffService {

	@Autowired
	AdministratorStaffRepository administratorStaffRepository;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudyYearService studyYearService;
	
	@Autowired
	StudentOnYearService studentOnYearService;
	
	@Autowired
	RegisteredUserService registeredUserService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
    
	
	public Iterable<AdministratorStaff> getAdministratorStaff() {
		return administratorStaffRepository.findAll();
	}
	
	public Optional<AdministratorStaff> getOne(Long id) {
		return administratorStaffRepository.findById(id);
	}
	
	public Optional<AdministratorStaff> getOneByUsername(String username) {
		return administratorStaffRepository.getByUsername(username);
	}
	
	public void addAdministratorStaff(AdministratorStaff adminStaff) {
		loginService.addPermssion(adminStaff.getRegisteredUser(), "ROLE_ADMINISTRATOR_STAFF");
		adminStaff.getRegisteredUser().setPassword(passwordEncoder.encode(adminStaff.getRegisteredUser().getPassword()));
		administratorStaffRepository.save(adminStaff);
	}
	
	public void removeAdministratorStaff(Long id) {
		Optional<AdministratorStaff> adminStaff = administratorStaffRepository.findById(id);
		AdministratorStaff admin = adminStaff.get();
		admin.setDeleted(true);
		administratorStaffRepository.save(admin);
	}
	
	public void updateAdministrationStaff(String username, AdministratorStaff adminStaff) {
		 Optional<AdministratorStaff> admin = administratorStaffRepository.getByUsername(username);
	        if(admin.isPresent()) {
	            adminStaff.setId(admin.get().getId());
	            adminStaff.getRegisteredUser().setPassword(passwordEncoder.encode(adminStaff.getRegisteredUser().getPassword()));
	            registeredUserService.updateUser(adminStaff.getRegisteredUser().getId(), adminStaff.getRegisteredUser());
	            addressService.updateAddress(adminStaff.getAddress().getId(), adminStaff.getAddress());
	            administratorStaffRepository.save(adminStaff);
	        }
	}
	
	public Iterable<Student> getStudentsForEnrollmentToTheNextYear(String studyCourse, int studyYear) {
        return administratorStaffRepository.findStudentsForEnrollmentToTheNextYear(studyCourse, studyYear);
    }
	
	public Boolean enrollmentStudentToTheNextYear(ArrayList<String> ids) { 
    	Optional<Student> student = studentService.getOneStudent(Long.valueOf(ids.get(0)));
    	if(student.isPresent()) {
    		Student s = student.get();
    		s.setStudyYear(s.getStudyYear()+1);
    		Optional<StudyYear> oldstudyYear= studyYearService.getYearOfStudyById(Long.valueOf(ids.get(1)));
    		Optional<StudyYear> sy = studyYearService.getNextYearOfStudyByStudyProgram(Long.valueOf(ids.get(1)));
    		Optional<StudentOnYear> soy = studentOnYearService.getStudentYearByYearOfStudyId(oldstudyYear.get().getId());
    		soy.get().setStudyYear(sy.get());
    		studentOnYearService.updateStudentOnYear(soy.get().getId(), soy.get());;
    		return true;
    	}
        return false;
    }
	
}
