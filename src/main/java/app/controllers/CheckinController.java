package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.dto.CalendarEventDto;
import app.entities.CalendarEvent;
import app.services.CheckinService;

@Controller
@RequestMapping("/checkin")
public class CheckinController {
	
	@Autowired
	CheckinService cs;
	


}
