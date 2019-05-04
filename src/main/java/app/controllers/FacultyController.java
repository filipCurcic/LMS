package app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.entities.Faculty;
import app.services.FacultyService;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
	
	@Autowired
	FacultyService facSer;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<Faculty>> getUniversities(){
		return new ResponseEntity<Iterable<Faculty>>(facSer.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
		Optional<Faculty> uni = facSer.getOne(id);
		if (uni.isPresent()) {
			return new ResponseEntity<Faculty>(uni.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty){
		facSer.addFaculty(faculty);
		return new ResponseEntity<Faculty>(faculty, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id){
		try {
			facSer.removeFaculty(id);
		} catch (Exception e) {
			return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Faculty>(HttpStatus.NO_CONTENT);
	}

}
