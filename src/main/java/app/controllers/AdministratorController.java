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

import app.entities.Administrator;
import app.services.AdministatorService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/administrator")
public class AdministratorController {
	
	@Autowired
	AdministatorService adminService;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/all")
	public ResponseEntity<Iterable<Administrator>> getAll(){
		return new ResponseEntity<Iterable<Administrator>>(adminService.getAdministrator(), HttpStatus.OK);
	}
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/{id}")
	public ResponseEntity<Administrator> getAdministrator(@PathVariable Long id) {
		Optional<Administrator> admin = adminService.getOne(id);
		if (admin.isPresent()) {
			return new ResponseEntity<Administrator>(admin.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Administrator> addAddress(@RequestBody Administrator administrator){
		adminService.addAdministrator(administrator);
		return new ResponseEntity<Administrator>(administrator, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Administrator> deleteAdministrator(@PathVariable Long id){
		try {
			adminService.removeAdministrator(id);
		} catch (Exception e) {
			return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Administrator>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Administrator> editAdministrator(@PathVariable Long id, @RequestBody Administrator administrator){
		adminService.updateAdministrator(id, administrator);
		return new ResponseEntity<Administrator>(administrator, HttpStatus.OK);
	}


}
