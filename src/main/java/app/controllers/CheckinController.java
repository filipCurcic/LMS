package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import app.services.CheckinService;

@Controller
@RequestMapping("/checkin")
public class CheckinController {
	
	@Autowired
	CheckinService cs;
	


}
