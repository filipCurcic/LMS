package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.CalendarEvent;
import app.repositories.CalendarRepository;

@Service
public class CalendarService {
	
	@Autowired
	CalendarRepository calendarRepository;
	
	public Iterable<CalendarEvent> getAll() {
		return calendarRepository.findAll();
	}
	
	public List<CalendarEvent> getOneDayEvents(Integer day, Integer month, Integer year) {
		return calendarRepository.findEventsInDay(day, month, year);
	}
	
	public List<CalendarEvent> getEventCount(Integer month, Integer year) {
		return calendarRepository.findEventsInMonth(month, year);
	}
	
	public void addEvent(CalendarEvent event) {
		calendarRepository.save(event);
	}

}
