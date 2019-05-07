package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.TeacherOnRealization;
import app.repositories.TeacherOnRealizationRepository;

@Service
public class TeacherOnRealizationService {
	
	@Autowired
	TeacherOnRealizationRepository teacherOnRealizationRep;
	
	public Iterable<TeacherOnRealization> getTeachersOnRealization() {
		return teacherOnRealizationRep.findAll();
	}
	
	public Optional<TeacherOnRealization> getOne(Long id) {
		return teacherOnRealizationRep.findById(id);
	}
	
	public void addTeacherOnRealization(TeacherOnRealization teacherOnRealization) {
		teacherOnRealizationRep.save(teacherOnRealization);
	}
	
	public void removeTeacherOnRealization(Long id) {
		Optional<TeacherOnRealization> teacherOnRealization= teacherOnRealizationRep.findById(id);
		if(teacherOnRealization.isPresent()) {
			teacherOnRealizationRep.delete(teacherOnRealization.get());
		}
	}
	
	public void updateTeacherOnRealization(Long id, TeacherOnRealization teacherOnRealization) {
		Optional<TeacherOnRealization> teacherReal = teacherOnRealizationRep.findById(id);
		if(teacherReal.isPresent()) {
			teacherOnRealization.setId(teacherReal.get().getId());
			teacherOnRealizationRep.save(teacherOnRealization);
		}
	}

}

