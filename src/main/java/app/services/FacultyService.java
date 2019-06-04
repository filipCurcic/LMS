package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Faculty;
import app.entities.University;
import app.repositories.FacultyRepository;

@Service
public class FacultyService {

	@Autowired
	FacultyRepository facRep;
	
	
	public List<Faculty> getAll(){
		return facRep.findAll();
	}
	
	public Faculty getOne(Long id){
		return facRep.findById(id).orElse(null);
	}
	
	public void addFaculty(Faculty fac) {
		facRep.save(fac);
	}
	
	public void removeFaculty(Long id) {
		Optional<Faculty> is = facRep.findById(id);
		facRep.delete(is.get());
	}
	
	public void updateFaculty(Long id, Faculty fac) {
		Optional<Faculty> faculty = facRep.findById(id);
		if(faculty.isPresent()) {
			fac.setId(faculty.get().getId());
			facRep.save(fac);
		}
	}
	
}
