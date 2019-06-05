package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.entities.Student;
import app.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository stuRep;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public List<Student> getAll(){
		return stuRep.findAll();
	}
	
	public Student getOne(Long id){
		return stuRep.findById(id).orElse(null);
	}
	
	public Optional<Student> getOneStudent(Long id){
		return stuRep.findById(id);
	}
	
	public Optional<Student> getStudentByUsername(String username) {
        return stuRep.getByUsername(username);
    }
	
	public void addStudent(Student student) {
		loginService.addPermssion(student.getRegisteredUser(), "ROLE_STUDENT");
		student.getRegisteredUser().setPassword(passwordEncoder.encode(student.getRegisteredUser().getPassword()));
        stuRep.save(student);
	}
	
	public void removeStudent(Long id) {
		Optional<Student> is = stuRep.findById(id);
		stuRep.delete(is.get());
	}
	
	public Iterable<Optional<Student>> getStudentsByFirstName(String name){
    	return stuRep.findStudentsByFirstName("%"+name+"%");
    }
    
	
	public Optional<Student> getStudentByJmbg(String jmbg){
    	return stuRep.findStudentByJmbg(jmbg);
	}

}
