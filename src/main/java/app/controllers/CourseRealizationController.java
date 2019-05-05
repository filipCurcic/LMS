
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
import app.entities.CourseRealization;
import app.services.CourseRealizationService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/courserealization")
public class CourseRealizationController {
	@Autowired
	CourseRealizationService cs;

	@RequestMapping("/")
	public ResponseEntity<Iterable<CourseRealization>> getCourseRealizations() {
		return new ResponseEntity<Iterable<CourseRealization>>(cs.getCourseRealizations(), HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<CourseRealization> addCourseRealization(@RequestBody CourseRealization courserealization) {
		cs.AddCourseRealization(courserealization);
		return new ResponseEntity<CourseRealization>(courserealization, HttpStatus.OK);
	}

	@RequestMapping("/{id}")
	public ResponseEntity<CourseRealization> getCourseRealization(@PathVariable Long id) {
		Optional<CourseRealization> courserealization = cs.getCourseRealization(id);
		if (courserealization.isPresent()) {
			return new ResponseEntity<CourseRealization>(courserealization.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseRealization>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CourseRealization> deleteCourseRealization(@PathVariable Long id) {
		try {
			cs.deleteCourseRealization(id);
		} catch (Exception e) {
			return new ResponseEntity<CourseRealization>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CourseRealization>(HttpStatus.NO_CONTENT);
	}
}