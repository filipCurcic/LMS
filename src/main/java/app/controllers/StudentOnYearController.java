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

import app.entities.StudentOnYear;
import app.services.StudentOnYearService;

@Controller
@RequestMapping("/studentOnYear")
public class StudentOnYearController {
	
	@Autowired
	StudentOnYearService stuOnYSer;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<StudentOnYear>> getUniversities(){
		return new ResponseEntity<Iterable<StudentOnYear>>(stuOnYSer.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<StudentOnYear> getStudentOnYear(@PathVariable Long id) {
		Optional<StudentOnYear> uni = stuOnYSer.getOne(id);
		if (uni.isPresent()) {
			return new ResponseEntity<StudentOnYear>(uni.get(), HttpStatus.OK);
		}
		return new ResponseEntity<StudentOnYear>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<StudentOnYear> addStudentOnYear(@RequestBody StudentOnYear stuOnY){
		stuOnYSer.addStudentOnYear(stuOnY);
		return new ResponseEntity<StudentOnYear>(stuOnY, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StudentOnYear> deleteStudentOnYear(@PathVariable Long id){
		try {
			stuOnYSer.removeStudentOnYear(id);
		} catch (Exception e) {
			return new ResponseEntity<StudentOnYear>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StudentOnYear>(HttpStatus.NO_CONTENT);
	}

}
