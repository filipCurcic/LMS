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
import app.entities.CourseAttending;
import app.services.CourseAttendingService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/courseattending")
public class CourseAttendingController {
	@Autowired
	CourseAttendingService cs;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<CourseAttending>> getCourseAttendings() {
		return new ResponseEntity<Iterable<CourseAttending>>(cs.getCourseAttendings(), HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<CourseAttending> addCourseAttending(@RequestBody CourseAttending courseattending) {
		cs.AddCourseAttending(courseattending);
		return new ResponseEntity<CourseAttending>(courseattending, HttpStatus.OK);
	}

	@RequestMapping("/{id}")
	public ResponseEntity<CourseAttending> getCourseAttending(@PathVariable Long id) {
		Optional<CourseAttending> courseattending = cs.getCourseAttending(id);
		if (courseattending.isPresent()) {
			return new ResponseEntity<CourseAttending>(courseattending.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseAttending>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CourseAttending> deleteCourseAttending(@PathVariable Long id) {
		try {
			cs.deleteCourseAttending(id);
		} catch (Exception e) {
			return new ResponseEntity<CourseAttending>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CourseAttending>(HttpStatus.NO_CONTENT);
	}
}