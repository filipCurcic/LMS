package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.CourseOutcome;
import app.repositories.CourseOutcomeRepository;

@Service
public class CourseOutcomeService {
	@Autowired
	CourseOutcomeRepository cr;

	public CourseOutcomeService() {
	}

	public List<CourseOutcome> getCourseOutcomes() {
		return cr.findAll();
	}

	public CourseOutcome getCourseOutcome(Long id) {
		return cr.findById(id).orElse(null);
	}

	public void AddCourseOutcome(CourseOutcome courseoutcome) {
		cr.save(courseoutcome);
	}

	public void deleteCourseOutcome(Long id) {
		Optional<CourseOutcome> courseoutcome = cr.findById(id);
		cr.delete(courseoutcome.get());
	}
}
