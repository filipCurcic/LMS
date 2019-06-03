package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Faculty;
import app.repositories.FacultyRepository;

@Service
public class FacultyService {

	@Autowired
	FacultyRepository facRep;
	
	
	public List<Faculty> getAll(){
		return facRep.findAll();
	}
	
	public List<Faculty> getFacultiesOnUni(Long id){
		System.out.println(id);
		return facRep.getFacultiesOnUni(id);
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
	
}
