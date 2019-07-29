package app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import app.entities.CalendarEvent;
import app.services.CalendarService;
import app.utils.View.HideOptionalProperties;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/calendar")
public class CalendarController {
	
	@Autowired
	CalendarService calendarService;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/all")
	public ResponseEntity<Iterable<CalendarEvent>> getEventsCount() {
		return new ResponseEntity<Iterable<CalendarEvent>>(calendarService.getAll(), HttpStatus.OK);
		
	}
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/eventCount/{dayVar}/{monthVar}/{yearVar}") // List of events in one day
	public ResponseEntity<Iterable<CalendarEvent>> getCalendarEvents(@PathVariable String dayVar, @PathVariable String monthVar, @PathVariable String yearVar) {
		Integer day = Integer.parseInt(dayVar);
		Integer month = Integer.parseInt(monthVar);
		Integer year = Integer.parseInt(yearVar);
		return new ResponseEntity<Iterable<CalendarEvent>>(calendarService.getOneDayEvents(day, month, year), HttpStatus.OK);
	}
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/eventCount/{monthVar}/{yearVar}") // List of events in one month
	public ResponseEntity<Iterable<CalendarEvent>> getCalendarEvents(@PathVariable String monthVar, @PathVariable String yearVar) {
		Integer month = Integer.parseInt(monthVar);
		Integer year = Integer.parseInt(yearVar);
		return new ResponseEntity<Iterable<CalendarEvent>>(calendarService.getEventCount(month, year), HttpStatus.OK);
	}
	
	@RequestMapping("/addEvent")
	public ResponseEntity<CalendarEvent> addCalendarEvent(@RequestBody CalendarEvent event) {
		calendarService.addEvent(event);
		return new ResponseEntity<CalendarEvent>(event, HttpStatus.OK);
	}
	
	
}
