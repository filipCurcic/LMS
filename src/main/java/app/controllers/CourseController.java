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

import app.dto.CourseDto;
import app.entities.Course;
import app.mappers.CourseMapper;
import app.services.CourseService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService cs;
	
	@Autowired
	CourseMapper courseMapper;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<CourseDto>> getCourses() {
		List<Course> course = cs.getCourses();
		return ResponseEntity.ok(courseMapper.toDTO(course));
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		cs.AddCourse(course);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

	@RequestMapping("/{id}")
	public CourseDto getCourse(@PathVariable Long id) {
		Course course = cs.getCourse(id);
		return courseMapper.toDTO(course);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Course> deleteCourse(@PathVariable Long id) {
		try {
			cs.deleteCourse(id);
		} catch (Exception e) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
	}
}