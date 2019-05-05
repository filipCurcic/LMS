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

import app.entities.ScientificField;
import app.services.ScientificFieldService;

@CrossOrigin(origins= {"http://localhost:4200"} ) 
@RestController 
@RequestMapping( "/scientificfield" )
public class ScientificFieldController {
	
	@Autowired
	ScientificFieldService ss;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<ScientificField>> getScientificFields() {
		return new ResponseEntity<Iterable<ScientificField>>(ss.getScientificFields(), HttpStatus.OK);
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<ScientificField> addScientificField(@RequestBody ScientificField scientificField) {
		ss.addScientificField(scientificField);
		return new ResponseEntity<ScientificField>(scientificField, HttpStatus.OK);
	}


	@RequestMapping("/{id}")
	public ResponseEntity<ScientificField> getOne(@PathVariable Long id) {
		Optional<ScientificField> scientificField = ss.getOne(id);
		if (scientificField.isPresent()) {
			return new ResponseEntity<ScientificField>(scientificField.get(), HttpStatus.OK);
		}
		return new ResponseEntity<ScientificField>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ScientificField> removeScientificField(@PathVariable Long id) {
		try {
			ss.removeScientificField(id);
		} catch (Exception e) {
			return new ResponseEntity<ScientificField>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ScientificField>(HttpStatus.NO_CONTENT);
	}

}
