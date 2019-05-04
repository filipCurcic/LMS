package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Faculty;
import app.repositories.FacultyRepository;

@Service
public class FacultyService {

	@Autowired
	FacultyRepository facRep;
	
	
	public Iterable<Faculty> getAll(){
		return facRep.findAll();
	}
	
	public Optional<Faculty> getOne(Long id){
		return facRep.findById(id);
	}
	
	public void addFaculty(Faculty fac) {
		facRep.save(fac);
	}
	
	public void removeFaculty(Long id) {
		Optional<Faculty> is = facRep.findById(id);
		facRep.delete(is.get());
	}
	
}