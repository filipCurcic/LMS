package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Title;
import app.repositories.TitleRepository;

@Service
public class TitleService {

	@Autowired
	TitleRepository titleRep;
	
	public List<Title> getTitles() {
		return titleRep.findAll();
	}
	
	public Optional<Title> getOne(Long id) {
		return titleRep.findById(id);
	}
	
	public void addTitle(Title title) {
		titleRep.save(title);
	}
	
	public void removeTitle(Long id) {
		Optional<Title> title= titleRep.findById(id);
		if(title.isPresent()) {
			titleRep.delete(title.get());
		}
	}
	
	public void updateTitle(Long id, Title title) {
		Optional<Title> tit = titleRep.findById(id);
		if(tit.isPresent()) {
			title.setId(tit.get().getId());
			titleRep.save(title);
		}
	}
}
