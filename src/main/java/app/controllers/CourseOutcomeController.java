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
import app.entities.CourseOutcome;
import app.services.CourseOutcomeService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/courseoutcome")
public class CourseOutcomeController {
	@Autowired
	CourseOutcomeService cs;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<CourseOutcome>> getCourseOutcomes() {
		return new ResponseEntity<Iterable<CourseOutcome>>(cs.getCourseOutcomes(), HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<CourseOutcome> addCourseOutcome(@RequestBody CourseOutcome courseoutcome) {
		cs.AddCourseOutcome(courseoutcome);
		return new ResponseEntity<CourseOutcome>(courseoutcome, HttpStatus.OK);
	}

	@RequestMapping("/{id}")
	public ResponseEntity<CourseOutcome> getCourseOutcome(@PathVariable Long id) {
		Optional<CourseOutcome> courseoutcome = cs.getCourseOutcome(id);
		if (courseoutcome.isPresent()) {
			return new ResponseEntity<CourseOutcome>(courseoutcome.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseOutcome>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CourseOutcome> deleteCourseOutcome(@PathVariable Long id) {
		try {
			cs.deleteCourseOutcome(id);
		} catch (Exception e) {
			return new ResponseEntity<CourseOutcome>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CourseOutcome>(HttpStatus.NO_CONTENT);
	}
}