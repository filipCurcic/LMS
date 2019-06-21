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

import app.dto.CourseAttendingDto;
import app.entities.CourseAttending;
import app.mappers.CourseAttendingMapper;
import app.services.CourseAttendingService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/course-attending")
public class CourseAttendingController {
	@Autowired
	CourseAttendingService cs;
	
	@Autowired
	CourseAttendingMapper courseAttendingMapepr;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<CourseAttendingDto>> getCourseAttendings() {
		List<CourseAttending> courseAttending = cs.getCourseAttendings();
		return ResponseEntity.ok(courseAttendingMapepr.toDTO(courseAttending));
	}
	
	@RequestMapping("/studentExams/{studentId}")
	public ResponseEntity<Iterable<CourseAttendingDto>> getExamsForStudent(@PathVariable Long studentId) {
		List<CourseAttending> studentExams = cs.getExamsForStudent(studentId);
		return ResponseEntity.ok(courseAttendingMapepr.toDTO(studentExams));
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<CourseAttending> addCourseAttending(@RequestBody CourseAttending courseattending) {
		cs.AddCourseAttending(courseattending);
		return new ResponseEntity<CourseAttending>(courseattending, HttpStatus.OK);
	}

	@RequestMapping("/{id}")
	public CourseAttendingDto getCourseAttending(@PathVariable Long id) {
		CourseAttending courseAttending = cs.getCourseAttending(id);
		return courseAttendingMapepr.toDTO(courseAttending);
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