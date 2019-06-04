package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Student;
import app.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository stuRep;
	
	@Autowired
	LoginService loginService;
	
	public List<Student> getAll(){
		return stuRep.findAll();
	}
	
	public Student getOne(Long id){
		return stuRep.findById(id).orElse(null);
	}
	
	public void addStudent(Student student) {
		loginService.addPermssion(student.getRegisteredUser(), "ROLE_STUDENT");
		stuRep.save(student);
	}
	
	public void removeStudent(Long id) {
		Optional<Student> is = stuRep.findById(id);
		stuRep.delete(is.get());
	}
	
	

}
