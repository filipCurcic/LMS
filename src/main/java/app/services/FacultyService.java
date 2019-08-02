package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Faculty;
import app.repositories.AddressRepository;
import app.repositories.FacultyRepository;
import app.repositories.UniversityRepository;

@Service
public class FacultyService {

	@Autowired
	FacultyRepository facRep;
	
	@Autowired
	UniversityRepository universityRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public Iterable<Faculty> getAll(){
		return facRep.findAll();
	}
	
	public Iterable<Faculty> getFacultiesOnUni(Long id){
		System.out.println(id);
		return facRep.getFacultiesOnUni(id);
	}
	
	
	public Optional<Faculty> getOne(Long id){
		return facRep.findById(id);
	}
	
	public void addFaculty(Faculty fac) {
		fac.setUniversity(universityRepository.getOne(1l));
		fac.setAddress(addressRepository.getOne(1l));
		facRep.save(fac);
	}
	
	public void removeFaculty(Long id) {
		Optional<Faculty> is = facRep.findById(id);
		facRep.delete(is.get());
	}
	
	public void updateFaculty(Long id, Faculty faculty) {
		Optional<Faculty> fac = facRep.findById(id);
		if(fac.isPresent()) {
			faculty.setId(fac.get().getId());
			facRep.save(faculty);
		}
	}
	
}
