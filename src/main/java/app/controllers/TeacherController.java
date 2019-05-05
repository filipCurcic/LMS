package app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.entities.Teacher;
import app.services.TeacherService;

@CrossOrigin(origins= {"http://localhost:4200"} ) 
@RestController 
@RequestMapping( "/teacher" ) 
public class TeacherController {
	@Autowired
	TeacherService ts;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<Teacher>> getTeachers() {
		return new ResponseEntity<Iterable<Teacher>>(ts.getTeachers(), HttpStatus.OK);
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
		ts.addTeacher(teacher);
		return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
	}


	@RequestMapping("/{id}")
	public ResponseEntity<Teacher> getOne(@PathVariable Long id) {
		Optional<Teacher> teacher = ts.getOne(id);
		if (teacher.isPresent()) {
			return new ResponseEntity<Teacher>(teacher.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Teacher> removeTeacher(@PathVariable Long id) {
		try {
			ts.removeTeacher(id);
		} catch (Exception e) {
			return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT);
	}
}
