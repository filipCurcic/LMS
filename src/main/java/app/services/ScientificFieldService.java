package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.ScientificField;
import app.repositories.ScientificFieldRepository;

@Service
public class ScientificFieldService {
	@Autowired
	ScientificFieldRepository scientificFieldRep;
	
	public Iterable<ScientificField> getScientificFields() {
		return scientificFieldRep.findAll();
	}
	
	public Optional<ScientificField> getOne(Long id) {
		return scientificFieldRep.findById(id);
	}
	
	public void addScientificField(ScientificField scientificField) {
		scientificFieldRep.save(scientificField);
	}
	
	public void removeScientificField(Long id) {
		Optional<ScientificField> scientificField= scientificFieldRep.findById(id);
		if(scientificField.isPresent()) {
			scientificFieldRep.delete(scientificField.get());
		}
	}
	
	public void updateScientificField(Long id, ScientificField scientificField) {
		Optional<ScientificField> sf = scientificFieldRep.findById(id);
		if(sf.isPresent()) {
			scientificField.setId(sf.get().getId());
			scientificFieldRep.save(scientificField);
		}
	}

}
