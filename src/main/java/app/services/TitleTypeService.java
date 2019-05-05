package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import app.entities.TitleType;
import app.repositories.TitleTypeRepository;

public class TitleTypeService {
	
	@Autowired
	TitleTypeRepository titleTypeRep;
	
	public Iterable<TitleType> getTeachers() {
		return titleTypeRep.findAll();
	}
	
	public Optional<TitleType> getOne(Long id) {
		return titleTypeRep.findById(id);
	}
	
	public void addTitleType(TitleType titleType) {
		titleTypeRep.save(titleType);
	}
	
	public void removeTitleType(Long id) {
		Optional<TitleType> titleType= titleTypeRep.findById(id);
		if(titleType.isPresent()) {
			titleTypeRep.delete(titleType.get());
		}
	}
	
	public void updateTitle(Long id, TitleType titleType) {
		Optional<TitleType> titTp = titleTypeRep.findById(id);
		if(titTp.isPresent()) {
			titleType.setId(titTp.get().getId());
			titleTypeRep.save(titleType);
		}
	}

}
