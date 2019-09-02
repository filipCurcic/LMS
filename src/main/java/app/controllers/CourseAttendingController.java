package app.controllers;

import java.util.ArrayList;
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

import app.entities.Course;
import app.entities.CourseAttending;
import app.entities.Student;
import app.services.CourseAttendingService;
import app.utils.View.HideOptionalProperties;
import app.utils.View.ShowStudyYear;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/course-attending")
public class CourseAttendingController {
	@Autowired
	CourseAttendingService cs;
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping("/all")
	public ResponseEntity<Iterable<CourseAttending>> getCourseAttendings() {
		return new ResponseEntity<Iterable<CourseAttending>>(cs.getCourseAttendings(), HttpStatus.OK);
	}
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<CourseAttending> getCourseAttendingById(@PathVariable Long id) {
        Optional<CourseAttending> courseAttending= cs.getCourseAttending(id);
        if(courseAttending.isPresent()) {
            return new ResponseEntity<CourseAttending>(courseAttending.get(), HttpStatus.OK);
        }
        return new ResponseEntity<CourseAttending>(HttpStatus.NOT_FOUND);
    }


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<CourseAttending> addCourseAttending(@RequestBody CourseAttending courseattending) {
		cs.AddCourseAttending(courseattending);
		return new ResponseEntity<CourseAttending>(courseattending, HttpStatus.OK);
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
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/average-mark/{studentUsername}", method=RequestMethod.GET)
    public ResponseEntity<Double> getAverageMark(@PathVariable String studentUsername) {
        Double averageMark = cs.findAvgMark(studentUsername);
        return new ResponseEntity<Double>(averageMark, HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/studentsWhoDidntPassExam/{courseId}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Student>> getStudentsWhoDidntPassExam(@PathVariable Long courseId) {
        return new ResponseEntity<Iterable<Student>>(cs.getStudentsWhoDidntPassExam(courseId), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/current-courses/{studentUsername}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Course>> getCurrentCourseByStudentId(@PathVariable String studentUsername) {
    	return new ResponseEntity<ArrayList<Course>>(cs.getCurrentCourses(studentUsername), HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/past-courses/{studentUsername}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Object>> getPastCourseByStudentUsername(@PathVariable String studentUsername) {
    	return new ResponseEntity<ArrayList<Object>>(cs.getPastCourses(studentUsername), HttpStatus.OK);
    }

}