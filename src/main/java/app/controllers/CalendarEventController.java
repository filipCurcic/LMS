package app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.dto.CalendarEventDto;
import app.entities.CalendarEvent;
import app.mappers.CalendarEventMapper;
import app.services.CalendarEventService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/citcalendar-event")
public class CalendarEventController {

	@Autowired
	CalendarEventService calendarEventService;
	
	@Autowired
	CalendarEventMapper calendarEventMapper;
	
	
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<CalendarEventDto>> getAll(){
		List<CalendarEvent> calendarEvent= calendarEventService.getCalendarEvents();
		return ResponseEntity.ok(calendarEventMapper.toDTO(calendarEvent));

	}

	
	@RequestMapping("/{id}")
	public ResponseEntity<CalendarEvent> getCalendarEvent(@PathVariable Long id) {
		Optional<CalendarEvent> calendarEvent= calendarEventService.getOneEvent(id);
		if (calendarEvent.isPresent()) {
			return new ResponseEntity<CalendarEvent>(calendarEvent.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CalendarEvent>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<CalendarEvent> addCalendarEvent(@RequestBody CalendarEvent  calendarEvent){
		calendarEventService.addCalendarEvent(calendarEvent);
		return new ResponseEntity<CalendarEvent>(calendarEvent, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CalendarEvent> deleteCalendarEvent(@PathVariable Long id){
		try {
			calendarEventService.removeCalendarEvent(id);
		} catch (Exception e) {
			return new ResponseEntity<CalendarEvent>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CalendarEvent>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CalendarEvent> editCalendarEvent(@PathVariable Long id, @RequestBody CalendarEvent calendarEvent){
		calendarEventService.updateCalendarEvent(id, calendarEvent);
		return new ResponseEntity<CalendarEvent>(calendarEvent, HttpStatus.OK);
	}


}
