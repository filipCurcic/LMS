
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

import app.entities.CourseRealization;
import app.services.CourseRealizationService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/course-realization")
public class CourseRealizationController {
	
	@Autowired
	CourseRealizationService cs;
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping("/all")
	public ResponseEntity<Iterable<CourseRealization>> getCourseRealizations() {
		return new ResponseEntity<Iterable<CourseRealization>>(cs.getCourseRealizations(), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<CourseRealization> addCourseRealization(@RequestBody CourseRealization courserealization) {
		cs.AddCourseRealization(courserealization);
		return new ResponseEntity<CourseRealization>(courserealization, HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<CourseRealization> getCourseRealizationById(@PathVariable Long id) {
        Optional<CourseRealization> courseRealization=  cs.getCourseRealization(id);
        if(courseRealization.isPresent()) {
            return new ResponseEntity<CourseRealization>(courseRealization.get(), HttpStatus.OK);
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