package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.entities.CourseRealization;
import app.entities.Teacher;
import app.repositories.CourseRealizationRepository;
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
	
	@Autowired
	CourseRealizationRepository courseRealizationRepository;
    
	
	public Iterable<Teacher> getTeachers() {
		return teacherRep.findAll();
	}
	
	public Optional<Teacher> getOne(Long id) {
		return teacherRep.findById(id);
	}
	
	public Optional<Teacher> getTeacherByUsername(String username) {
        return teacherRep.getByUsername(username);
    }
	
	
	
	public void addTeacher(Teacher teacher) {
		loginService.addPermssion(teacher.getRegisteredUser(), "ROLE_PROFESSOR");
		teacher.getRegisteredUser().setPassword(passwordEncoder.encode(teacher.getRegisteredUser().getPassword()));
		teacherRep.save(teacher);
	}
	
	public void removeTeacher(Long id) {
		Optional<Teacher> teacher= teacherRep.findById(id);
		Teacher t = teacher.get();
		t.setDeleted(true);
		teacherRep.save(t);
	}
	
	public void updateTeacher (String username, Teacher teacher) {
		 Optional<Teacher> t = teacherRep.getByUsername(username);
	        if(t.isPresent()) {
	            teacher.setId(t.get().getId());
	            teacher.getRegisteredUser().setPassword(passwordEncoder.encode(teacher.getRegisteredUser().getPassword()));
	            registeredUserService.updateUser(teacher.getRegisteredUser().getId(), teacher.getRegisteredUser());
	            addressService.updateAddress(teacher.getAddress().getId(), teacher.getAddress());
	            teacherRep.save(teacher);   
	        }
	}
	
	public Iterable<CourseRealization> getCourseRealizations(String username) {
        return courseRealizationRepository.findByTeacherUsername(username);
    }

}
