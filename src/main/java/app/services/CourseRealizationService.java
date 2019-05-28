package app.services;

import java.util.List;
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

	public List<CourseRealization> getCourseRealizations() {
		return cr.findAll();
	}

	public CourseRealization getCourseRealization(Long id) {
		return cr.findById(id).orElse(null);
	}

	public void AddCourseRealization(CourseRealization courserealization) {
		cr.save(courserealization);
	}

	public void deleteCourseRealization(Long id) {
		Optional<CourseRealization> courserealization = cr.findById(id);
		cr.delete(courserealization.get());
	}
}