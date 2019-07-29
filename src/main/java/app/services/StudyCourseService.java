package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.StudyCourse;
import app.repositories.StudyCourseRepository;

@Service
public class StudyCourseService {

	@Autowired
	StudyCourseRepository stuCouRep;
	
	public Iterable<StudyCourse> getAll(){
		return stuCouRep.findAll();
	}
	
	//Get course by Faculty id
	public Optional<StudyCourse> getCourseOnFaculty(Long id){
		return stuCouRep.getCourseOnFaculty(id);
	}
	
	
	public Optional<StudyCourse> getOne(Long id){
		return stuCouRep.findById(id);
	}
	
	public void addStudyCourse(StudyCourse stuCou) {
		stuCouRep.save(stuCou);
	}
	
	public void removeStudyCourse(Long id) {
		Optional<StudyCourse> is = stuCouRep.findById(id);
		stuCouRep.delete(is.get());
	}
	
	public void updateStudyCourse(Long id, StudyCourse studyCourse) {
		Optional<StudyCourse> sc= stuCouRep.findById(id);
		if(sc.isPresent()) {
			studyCourse.setId(sc.get().getId());
			stuCouRep.save(studyCourse);
		}
	}
}
