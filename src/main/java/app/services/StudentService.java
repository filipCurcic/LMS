package app.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.entities.Student;
import app.repositories.StudentRepository;
import app.repositories.StudyYearRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository stuRep;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	RegisteredUserService registeredUserService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	StudyYearRepository studyYearRepository;
    
	public Iterable<Student> getAll(){
		return stuRep.findAll();
	}
	
	public Optional<Student> getOne(Long id){
		return stuRep.findById(id);
	}
	
	public Optional<Student> getOneStudent(Long id){
		return stuRep.findById(id);
	}
	
	public Optional<Student> getStudentByUsername(String username) {
        return stuRep.getByUsername(username);
    }
	
	
	public Optional<Student> getLoggedStudent(String username) {
        return stuRep.getLoggedStudent(username);
    }
	
	
	@Transactional
	public void addStudent(Student student) {
		loginService.addPermssion(student.getRegisteredUser(), "ROLE_STUDENT");
		student.getRegisteredUser().setPassword(passwordEncoder.encode(student.getRegisteredUser().getPassword()));
		stuRep.save(student);
        System.out.println("service saved");
	}
	
	public void removeStudent(Long id) {
		Optional<Student> is = stuRep.findById(id);
		stuRep.delete(is.get());
	}
	
	public void deleteStudent(Long id) {
		Optional<Student> student = stuRep.findById(id);
		Student s = student.get();
		s.setDeleted(true);
		stuRep.save(s);
	}
	
	public void updateStudent (String username, Student student) {
		 Optional<Student> st = stuRep.getByUsername(username);
	        if(st.isPresent()) {
	            student.setId(st.get().getId());
	            student.getRegisteredUser().setPassword(passwordEncoder.encode(student.getRegisteredUser().getPassword()));
	            registeredUserService.updateUser(student.getRegisteredUser().getId(), student.getRegisteredUser());
	            addressService.updateAddress(student.getAddress().getId(), student.getAddress());
	            stuRep.save(student);
	        }
	}
	
	public Iterable<Optional<Student>> getStudentsByFirstName(String name){
    	return stuRep.findStudentsByFirstName("%"+name+"%");
    }
    
	
	public Optional<Student> getStudentByJmbg(String jmbg){
    	return stuRep.findStudentByJmbg(jmbg);
	}

}
