package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.CalendarEvent;
import app.repositories.CalendarEventRepository;

@Service
public class CalendarEventService {
	
	@Autowired
	CalendarEventRepository calendarEventRepository;
	
	public Iterable<CalendarEvent> getCalendarEvents() {
		return calendarEventRepository.findAll();
	}
	
	public Optional<CalendarEvent> getOneEvent(Long id) {
		return calendarEventRepository.findById(id);
	}
	
	public void addCalendarEvent(CalendarEvent calendarEvent) {
		calendarEventRepository.save(calendarEvent);
	}
	
	public void removeCalendarEvent(Long id) {
		Optional<CalendarEvent> calendarEvent = calendarEventRepository.findById(id);
		if(calendarEvent.isPresent()) {
			calendarEventRepository.delete(calendarEvent.get());
		}
	}
	
	public void updateCalendarEvent(Long id, CalendarEvent calendarEvent) {
		Optional<CalendarEvent> c = calendarEventRepository.findById(id);
		if(c.isPresent()) {
			calendarEvent.setId(c.get().getId());
			calendarEventRepository.save(calendarEvent);
		}
	}


}
