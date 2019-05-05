package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.TeachingType;
import app.repositories.TeachingTypeRepository;

@Service
public class TeachingTypeService {

	@Autowired
	TeachingTypeRepository teachingTypeRep;

	public Iterable<TeachingType> getTeachingTypes() {
		return teachingTypeRep.findAll();
	}

	public Optional<TeachingType> getOne(Long id) {
		return teachingTypeRep.findById(id);
	}

	public void addTeachingType(TeachingType teachingType) {
		teachingTypeRep.save(teachingType);
	}

	public void removeTeachingType(Long id) {
		Optional<TeachingType> teachingType = teachingTypeRep.findById(id);
		if (teachingType.isPresent()) {
			teachingTypeRep.delete(teachingType.get());
		}
	}

	public void updateTeachingType(Long id, TeachingType teachingType) {
		Optional<TeachingType> teachingTp = teachingTypeRep.findById(id);
		if (teachingTp.isPresent()) {
			teachingType.setId(teachingTp.get().getId());
			teachingTypeRep.save(teachingType);
		}
	}

}
