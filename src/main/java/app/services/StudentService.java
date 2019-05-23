package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Student;
import app.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository stuRep;
	
	public Iterable<Student> getAll(){
		return stuRep.findAll();
	}
	
	public Optional<Student> getOne(Long id){
		return stuRep.findById(id);
	}
	
	public void addStudent(Student ispit) {
		stuRep.save(ispit);
	}
	
	public void removeStudent(Long id) {
		Optional<Student> is = stuRep.findById(id);
		stuRep.delete(is.get());
	}
	
	

}
