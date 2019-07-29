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

import com.fasterxml.jackson.annotation.JsonView;

import app.entities.CourseOutcome;
import app.services.CourseOutcomeService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/course-outcome")
public class CourseOutcomeController {
	
	@Autowired
	CourseOutcomeService cs;
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping("/all")
	public ResponseEntity<Iterable<CourseOutcome>> getCourseOutcomes() {
		return new ResponseEntity<Iterable<CourseOutcome>>(cs.getCourseOutcomes(), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<CourseOutcome> addCourseOutcome(@RequestBody CourseOutcome courseoutcome) {
		cs.AddCourseOutcome(courseoutcome);
		return new ResponseEntity<CourseOutcome>(courseoutcome, HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<CourseOutcome> getCourseOutcomeById(@PathVariable Long id) {
        Optional<CourseOutcome> courseOutcome= cs.getCourseOutcome(id);
        if(courseOutcome.isPresent()) {
            return new ResponseEntity<CourseOutcome>(courseOutcome.get(), HttpStatus.OK);
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