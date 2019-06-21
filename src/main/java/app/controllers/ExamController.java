package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.entities.Exam;
import app.services.ExamService;

@Controller
@RequestMapping("/exam")
public class ExamController {
	
	@Autowired
	ExamService exSer;
	
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<Exam>> getExams() {
		return new ResponseEntity<Iterable<Exam>>(exSer.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/all/student/{studentId}")
	public ResponseEntity<Iterable<Exam>> getExamsForStudent(@PathVariable Long studentId) {
		return new ResponseEntity<Iterable<Exam>>(exSer.getExamsForStudent(studentId), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Exam> addExam(@RequestBody Exam exam) {
		exSer.addExam(exam);
		return new ResponseEntity<Exam>(exam, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Exam> getExam(@PathVariable Long id) {
		
		return new ResponseEntity<Exam>(HttpStatus.NOT_FOUND);
		
		
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Exam> removeExam(@PathVariable Long id) {
		try {
			exSer.removeExam(id);
		} catch (Exception e) {
			return new ResponseEntity<Exam>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Exam>(HttpStatus.NO_CONTENT);
	}

}
