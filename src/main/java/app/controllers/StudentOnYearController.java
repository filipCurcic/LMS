package app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.dto.StudentOnYearDto;
import app.entities.StudentOnYear;
import app.mappers.StudentOnYearMapper;
import app.services.StudentOnYearService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/student-on-year")
public class StudentOnYearController {
	
	@Autowired
	StudentOnYearService stuOnYSer;
	
	@Autowired
	StudentOnYearMapper studentOnYearMapper;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<StudentOnYearDto>> getUniversities(){
		List<StudentOnYear> studentOnYear = stuOnYSer.getAll();
		return ResponseEntity.ok(studentOnYearMapper.toDTO(studentOnYear));
	}
	
	@RequestMapping("/{id}")
	public StudentOnYearDto getStudentOnYear(@PathVariable Long id) {
			StudentOnYear studentOnYear = stuOnYSer.getOne(id);
			return studentOnYearMapper.toDTO(studentOnYear);
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
