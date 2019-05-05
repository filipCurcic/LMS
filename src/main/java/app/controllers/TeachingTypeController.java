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

import app.entities.TeachingType;
import app.services.TeachingTypeService;

@CrossOrigin(origins= {"http://localhost:4200"} ) 
@RestController 
@RequestMapping( "/teachingtype" ) 
public class TeachingTypeController {
	
	@Autowired
	TeachingTypeService ts;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<TeachingType>> getTeachers() {
		return new ResponseEntity<Iterable<TeachingType>>(ts.getTeachingTypes(), HttpStatus.OK);
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<TeachingType> addTeachingType(@RequestBody TeachingType teachingType) {
		ts.addTeachingType(teachingType);
		return new ResponseEntity<TeachingType>(teachingType, HttpStatus.OK);
	}


	@RequestMapping("/{id}")
	public ResponseEntity<TeachingType> getOne(@PathVariable Long id) {
		Optional<TeachingType> teachingType = ts.getOne(id);
		if (teachingType.isPresent()) {
			return new ResponseEntity<TeachingType>(teachingType.get(), HttpStatus.OK);
		}
		return new ResponseEntity<TeachingType>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TeachingType> removeTeachingType(@PathVariable Long id) {
		try {
			ts.removeTeachingType(id);
		} catch (Exception e) {
			return new ResponseEntity<TeachingType>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TeachingType>(HttpStatus.NO_CONTENT);
	}

}
