package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import app.entities.Teacher;
import app.repositories.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRep;
	
	public Iterable<Teacher> getTeachers() {
		return teacherRep.findAll();
	}
	
	public Optional<Teacher> getOne(Long id) {
		return teacherRep.findById(id);
	}
	
	public void addTeacher(Teacher teacher) {
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
			teacherRep.save(teacher);
		}
	}

}