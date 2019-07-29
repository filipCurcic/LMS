package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Checkin;
import app.repositories.CheckinRepository;

@Service
public class CheckinService {
	
	@Autowired
	CheckinRepository cr;
	
	
	public Iterable<Checkin> getCheckins() {
		return cr.findAll();
	}
	
	public Optional<Checkin> getOneEvent(Long id) {
		return cr.findById(id);
	}
	
	public void addCheckin(Checkin calendarEvent) {
		cr.save(calendarEvent);
	}
	
	public void removeCheckin(Long id) {
		Optional<Checkin> calendarEvent = cr.findById(id);
		if(calendarEvent.isPresent()) {
			cr.delete(calendarEvent.get());
		}
	}

}
