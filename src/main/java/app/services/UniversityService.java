package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.University;
import app.repositories.UniversityRepository;

@Service
public class UniversityService {

	@Autowired
	UniversityRepository uniRep;

	public List<University> getAll(){
		return uniRep.findAll();
	}
	
	public University getOne(Long id){
		return uniRep.findById(id).orElse(null);
	}
	
	public void addUniversity(University ispit) {
		uniRep.save(ispit);
	}
	
	public void removeUniversity(Long id) {
		Optional<University> is = uniRep.findById(id);
		uniRep.delete(is.get());
	}
	
	
	
}
