
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

import app.dto.CourseRealizationDto;
import app.entities.CourseRealization;
import app.mappers.CourseRealizationMapper;
import app.services.CourseRealizationService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/course-realization")
public class CourseRealizationController {
	
	@Autowired
	CourseRealizationService cs;
	
	@Autowired
	CourseRealizationMapper courseRealizationMapper;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<CourseRealizationDto>> getCourseRealizations() {
		List<CourseRealization> courseRealization = cs.getCourseRealizations();
		return ResponseEntity.ok(courseRealizationMapper.toDTO(courseRealization));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<CourseRealization> addCourseRealization(@RequestBody CourseRealization courserealization) {
		cs.AddCourseRealization(courserealization);
		return new ResponseEntity<CourseRealization>(courserealization, HttpStatus.OK);
	}

	@RequestMapping("/{id}")
	public CourseRealizationDto getCourseRealization(@PathVariable Long id) {
		CourseRealization courseRealization = cs.getCourseRealization(id);
		return courseRealizationMapper.toDTO(courseRealization);
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