package app.controllers;

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

import com.fasterxml.jackson.annotation.JsonView;

import app.entities.CalendarEvent;
import app.services.CalendarEventService;
import app.utils.View.HideOptionalProperties;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/calendar-event")
public class CalendarEventController {

	@Autowired
	CalendarEventService calendarEventService;
	
	
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/all")
	public ResponseEntity<Iterable<CalendarEvent>> getAll(){
		return new ResponseEntity<Iterable<CalendarEvent>>(calendarEventService.getCalendarEvents(), HttpStatus.OK);

	}

	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<CalendarEvent> getCalendarEventById(@PathVariable Long id) {
        Optional<CalendarEvent> ce = calendarEventService.getOneEvent(id);
        if(ce.isPresent()) {
            return new ResponseEntity<CalendarEvent>(ce.get(), HttpStatus.OK);
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
