package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Teacher;
import app.repositories.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRep;
	
	@Autowired
	RegisteredUserService registeredUserService;
	
	@Autowired
	UniversityService universityService;
	
	@Autowired
	FacultyService facultyService;
	
	@Autowired
	LoginService loginService;
	
	
	
	public List<Teacher> getTeachers() {
		return teacherRep.findAll();
	}
	
	public Teacher getOne(Long id) {
		return teacherRep.findById(id).orElse(null);
	}
	
	public void addTeacher(Teacher teacher) {
		loginService.addPermssion(teacher.getRegisteredUser(), "ROLE_PROFESSOR");
		teacherRep.save(teacher);
	}
	
	public void removeTeacher(Long id) {
		Optional<Teacher> teacher= teacherRep.findById(id);
		if(teacher.isPresent()) {
			teacherRep.delete(teacher.get());
		}
	}
	
	public void updateTeacher(Long id, Teacher teacher) {
		Optional<Teacher> teach = teacherRep.findById(id);
		if(teach.isPresent()) {
			teacher.setId(teach.get().getId());
			registeredUserService.updateUser(teacher.getRegisteredUser().getId(), teacher.getRegisteredUser());
			teacherRep.save(teacher);
		}
	}

}
