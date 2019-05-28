package app.controllers;

import java.util.List;
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

import app.dto.CourseOutcomeDto;
import app.entities.CourseOutcome;
import app.mappers.CourseOutcomeMapper;
import app.services.CourseOutcomeService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/course-outcome")
public class CourseOutcomeController {
	
	@Autowired
	CourseOutcomeService cs;
	
	@Autowired
	CourseOutcomeMapper courseOutcomeMapper;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<CourseOutcomeDto>> getCourseOutcomes() {
		List<CourseOutcome> courseOutcome = cs.getCourseOutcomes();
		return ResponseEntity.ok(courseOutcomeMapper.toDTO(courseOutcome));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<CourseOutcome> addCourseOutcome(@RequestBody CourseOutcome courseoutcome) {
		cs.AddCourseOutcome(courseoutcome);
		return new ResponseEntity<CourseOutcome>(courseoutcome, HttpStatus.OK);
	}

	@RequestMapping("/{id}")
	public CourseOutcomeDto getCourseOutcome(@PathVariable Long id) {
		CourseOutcome courseOutcome = cs.getCourseOutcome(id);
		return courseOutcomeMapper.toDTO(courseOutcome);
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