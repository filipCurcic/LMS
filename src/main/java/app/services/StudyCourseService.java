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
	
	
}
