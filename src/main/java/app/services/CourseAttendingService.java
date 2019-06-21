
package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.CourseAttendingDto;
import app.entities.CourseAttending;
import app.repositories.CourseAttendingRepository;

@Service
public class CourseAttendingService {
	@Autowired
	CourseAttendingRepository cr;

	public CourseAttendingService() {
	}

	public List<CourseAttending> getCourseAttendings() {
		return cr.findAll();
	}
	
	public List<CourseAttending> getExamsForStudent(Long studentId) {
		return cr.getExamsForStudent(studentId);
	}

	public CourseAttending getCourseAttending(Long id) {
		return cr.findById(id).orElse(null);
	}

	public void AddCourseAttending(CourseAttending courseattending) {
		cr.save(courseattending);
	}

	public void deleteCourseAttending(Long id) {
		Optional<CourseAttending> courseattending = cr.findById(id);
		cr.delete(courseattending.get());
	}
}