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

import app.entities.RegisteredUser;
import app.services.RegisteredUserService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/registered-user")
public class RegisteredUserController {
	
	@Autowired
	RegisteredUserService registeredUserService;
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping("/all")
	public ResponseEntity<Iterable<RegisteredUser>> getRegisteredUsers(){
		return new ResponseEntity<Iterable<RegisteredUser>>(registeredUserService.getRegisteredUser(), HttpStatus.OK);

	}

	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<RegisteredUser> getRegisteredUserById(@PathVariable Long id) {
        Optional<RegisteredUser> registeredUser = registeredUserService.getOne(id);
        if(registeredUser.isPresent()) {
            return new ResponseEntity<RegisteredUser>(registeredUser.get(), HttpStatus.OK);
        }
        return new ResponseEntity<RegisteredUser>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<RegisteredUser> addRegisteredUser(@RequestBody RegisteredUser registeredUser){
		registeredUserService.addUser(registeredUser);
		return new ResponseEntity<RegisteredUser>(registeredUser, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<RegisteredUser> deleteRegisteredUser(@PathVariable Long id){
		try {
			registeredUserService.removeRegisteredUser(id);
		} catch (Exception e) {
			return new ResponseEntity<RegisteredUser>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<RegisteredUser>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RegisteredUser> editRegisteredUser(@PathVariable Long id, @RequestBody RegisteredUser registeredUser){
		registeredUserService.updateUser(id, registeredUser);
		return new ResponseEntity<RegisteredUser>(registeredUser, HttpStatus.OK);
	}


}
