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
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable Long id) {
        Optional<Administrator> administrator = adminService.getOne(id);
        if(administrator.isPresent()) {
            return new ResponseEntity<Administrator>(administrator.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
    }
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping("/username/{username}")
	public ResponseEntity<Administrator> getAdministratorByUsername(@PathVariable String username) {
		Optional<Administrator> administrator = adminService.getByUsername(username);
        if(administrator.isPresent()) {
            return new ResponseEntity<Administrator>(administrator.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
    }
	
	@JsonView(HideOptionalProperties.class)
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
