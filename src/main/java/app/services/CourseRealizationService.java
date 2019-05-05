package app.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.entities.CourseRealization;
import app.repositories.CourseRealizationRepository;

@Service
public class CourseRealizationService {
	@Autowired
	CourseRealizationRepository cr;

	public CourseRealizationService() {
	}

	public Iterable<CourseRealization> getCourseRealizations() {
		return cr.findAll();
	}

	public Optional<CourseRealization> getCourseRealization(Long id) {
		return cr.findById(id);
	}

	public void AddCourseRealization(CourseRealization courserealization) {
		cr.save(courserealization);
	}

	public void deleteCourseRealization(Long id) {
		Optional<CourseRealization> courserealization = cr.findById(id);
		cr.delete(courserealization.get());
	}
}