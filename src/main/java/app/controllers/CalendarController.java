package app.controllers;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.CalendarEventDto;
import app.entities.CalendarEvent;
import app.mappers.CalendarEventMapper;
import app.services.CalendarService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/calendar")
public class CalendarController {
	
	@Autowired
	CalendarService calendarService;
	
	@Autowired
	CalendarEventMapper calendarMapper;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<CalendarEventDto>> getEventsCount() {
		
		List<CalendarEvent> calendarEvents = (List<CalendarEvent>) calendarService.getAll();
		return ResponseEntity.ok(calendarMapper.toDTO(calendarEvents));
		//		return new ResponseEntity<Iterable<CalendarEvent>>(calendarService.getEvents(), HttpStatus.OK);
		
	}
	
	@RequestMapping("/eventCount/{dayVar}/{monthVar}/{yearVar}") // List of events in one day
	public ResponseEntity<List<CalendarEventDto>> getCalendarEvents(@PathVariable String dayVar, @PathVariable String monthVar, @PathVariable String yearVar) {
		Integer day = Integer.parseInt(dayVar);
		Integer month = Integer.parseInt(monthVar);
		Integer year = Integer.parseInt(yearVar);
		System.out.println(day);
		System.out.println(month);
		System.out.println(year);
		List<CalendarEvent> eventslist = (List<CalendarEvent>) calendarService.getOneDayEvents(day, month, year);
		return ResponseEntity.ok(calendarMapper.toDTO(eventslist));
	}
	
	
	@RequestMapping("/eventCount/{monthVar}/{yearVar}") // List of events in one month
	public ResponseEntity<List<CalendarEventDto>> getCalendarEvents(@PathVariable String monthVar, @PathVariable String yearVar) {
		Integer month = Integer.parseInt(monthVar);
		Integer year = Integer.parseInt(yearVar);
		System.out.println(month);
		System.out.println(year);
		List<CalendarEvent> eventsCount = (List<CalendarEvent>) calendarService.getEventCount(month, year);
		return ResponseEntity.ok(calendarMapper.toDTO(eventsCount));
	}
	
	@RequestMapping("/addEvent")
	public ResponseEntity<CalendarEvent> addCalendarEvent(@RequestBody CalendarEvent event) {
		System.out.println("----------");
		System.out.println(event.getDateEvent());
		calendarService.addEvent(event);
		return new ResponseEntity<CalendarEvent>(event, HttpStatus.OK);
	}
	
	
}
