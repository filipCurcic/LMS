
package app.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Course;
import app.entities.CourseAttending;
import app.entities.Student;
import app.repositories.CourseAttendingRepository;

@Service
public class CourseAttendingService {
	@Autowired
	CourseAttendingRepository cr;

	public CourseAttendingService() {
	}

	public Iterable<CourseAttending> getCourseAttendings() {
		return cr.findAll();
	}
	
	public Iterable<CourseAttending> getExamsForStudent(Long studentId) {
		return cr.getExamsForStudent(studentId);
	}

	public Optional<CourseAttending> getCourseAttending(Long id) {
		return cr.findById(id);
	}
	
	public Double findAvgMark(String studentUsername) {
		return cr.findAverageMark(studentUsername);
	}
	
	public Iterable<Student> getStudentsWhoDidntPassExam(Long courseId) {
        return cr.findStudentsWhoDidntPassExam(courseId);
    }
    
    public ArrayList<Course> getCurrentCourses(String username){
    	return cr.findCurrentCourses(username);
    }
    
    public ArrayList<Object> getPastCourses(String username){
    	return cr.findPastCourses(username);
    }

	public void AddCourseAttending(CourseAttending courseattending) {
		cr.save(courseattending);
	}

	public void deleteCourseAttending(Long id) {
		Optional<CourseAttending> courseattending = cr.findById(id);
		cr.delete(courseattending.get());
	}
	
	public void updateCourseAttending(Long id, CourseAttending courseAttending) {
        Optional<CourseAttending> ca= cr.findById(id);
        if(ca.isPresent()) {
            courseAttending.setId(ca.get().getId());
            cr.save(courseAttending);
        }
    }
}