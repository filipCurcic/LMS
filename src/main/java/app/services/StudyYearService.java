package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.StudyYear;
import app.repositories.StudyYearRepository;

@Service
public class StudyYearService {

	@Autowired
	StudyYearRepository stuYRep;
	
	
	public Iterable<StudyYear> getAll(){
		return stuYRep.findAll();
	}
	
	public Optional<StudyYear> getOne(Long id){
		return stuYRep.findById(id);
	}
	
	public void addStudyYear(StudyYear stuY) {
		stuYRep.save(stuY);
	}
	
	public void removeStudyYear(Long id) {
		Optional<StudyYear> is = stuYRep.findById(id);
		stuYRep.delete(is.get());
	}
	
}
