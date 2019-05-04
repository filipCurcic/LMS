package app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.entities.Student;
import app.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService stuSer;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<Student>> getStudent(){
		return new ResponseEntity<Iterable<Student>>(stuSer.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		Optional<Student> uni = stuSer.getOne(id);
		if (uni.isPresent()) {
			return new ResponseEntity<Student>(uni.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		stuSer.addStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
		try {
			stuSer.removeStudent(id);
		} catch (Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
	
}
