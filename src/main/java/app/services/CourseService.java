package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Course;
import app.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository cr;

	public CourseService() {
	}

	public List<Course> getCourses() {
		return cr.findAll();
	}

	public Course getCourse(Long id) {
		return cr.findById(id).orElse(null);
	}

	public void AddCourse(Course course) {
		cr.save(course);
	}

	public void deleteCourse(Long id) {
		Optional<Course> course = cr.findById(id);
		cr.delete(course.get());
	}
}