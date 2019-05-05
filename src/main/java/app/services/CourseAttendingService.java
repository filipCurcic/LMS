
package app.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.entities.CourseAttending;
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

	public Optional<CourseAttending> getCourseAttending(Long id) {
		return cr.findById(id);
	}

	public void AddCourseAttending(CourseAttending courseattending) {
		cr.save(courseattending);
	}

	public void deleteCourseAttending(Long id) {
		Optional<CourseAttending> courseattending = cr.findById(id);
		cr.delete(courseattending.get());
	}
}