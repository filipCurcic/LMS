package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.entities.Teacher;
import app.repositories.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRep;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	RegisteredUserService registeredUserService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
    
	
	public List<Teacher> getTeachers() {
		return teacherRep.findAll();
	}
	
	public Teacher getOne(Long id) {
		return teacherRep.findById(id).orElse(null);
	}
	
	public Teacher getTeacherByUsername(String username) {
        return teacherRep.getByUsername(username).orElse(null);
    }
	
	
	
	public void addTeacher(Teacher teacher) {
		loginService.addPermssion(teacher.getRegisteredUser(), "ROLE_PROFESSOR");
		teacher.getRegisteredUser().setPassword(passwordEncoder.encode(teacher.getRegisteredUser().getPassword()));
		teacherRep.save(teacher);
	}
	
	public void removeTeacher(Long id) {
		Optional<Teacher> teacher= teacherRep.findById(id);
		if(teacher.isPresent()) {
			teacherRep.delete(teacher.get());
		}
	}
	
	public void updateTeacher (String username, Teacher teacher) {
		 Optional<Teacher> t = teacherRep.getByUsername(username);
	        if(t.isPresent()) {
	            teacher.setId(t.get().getId());
	            teacher.getRegisteredUser().setPassword(passwordEncoder.encode(teacher.getRegisteredUser().getPassword()));
	            registeredUserService.updateUser(teacher.getRegisteredUser().getId(), teacher.getRegisteredUser());
	            addressService.updateAddress(teacher.getAddress().getId(), teacher.getAddress());
	           
	        }
	}

}
