package app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonView;

import app.entities.Faculty;
import app.services.FacultyService;
import app.utils.View.HideOptionalProperties;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
	
	@Autowired
	FacultyService facSer;
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping("/all")
	public ResponseEntity<Iterable<Faculty>> getUniversities(){
		return new ResponseEntity<Iterable<Faculty>>(facSer.getAll(), HttpStatus.OK);
	}
	
	// Faculties for specific University
	@JsonView(HideOptionalProperties.class)
    @RequestMapping("/uni/{id}")
	public ResponseEntity<Iterable<Faculty>> getFacultiesOnUni(@PathVariable Long id){
		return new ResponseEntity<Iterable<Faculty>>(facSer.getFacultiesOnUni(id), HttpStatus.OK);
	}
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
        Optional<Faculty> faculty= facSer.getOne(id);
        if(faculty.isPresent()) {
            return new ResponseEntity<Faculty>(faculty.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);
    }

	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Secured("ROLE_ADMINISTRATOR")
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
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Faculty> editFaculty(@PathVariable Long id, @RequestBody Faculty faculty){
		facSer.updateFaculty(id, faculty);
		return new ResponseEntity<Faculty>(faculty, HttpStatus.CREATED);
	}


}
