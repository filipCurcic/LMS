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

import com.fasterxml.jackson.annotation.JsonView;

import app.entities.University;
import app.services.UniversityService;
import app.utils.View.HideOptionalProperties;

@Controller
@RequestMapping("/university")
public class UniversityController {
	
	@Autowired
	UniversityService uniSer;
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping("/all")
	public ResponseEntity<Iterable<University>> getUniversities(){
		return new ResponseEntity<Iterable<University>>(uniSer.getAll(), HttpStatus.OK);
	}
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<University> getUniversityById(@PathVariable Long id) {
        Optional<University> unversity = uniSer.getOne(id);
        if(unversity.isPresent()) {
            return new ResponseEntity<University>(unversity.get(), HttpStatus.OK);
        }
        return new ResponseEntity<University>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<University> addUniversity(@RequestBody University university){
		uniSer.addUniversity(university);
		return new ResponseEntity<University>(university, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<University> deleteUniversity(@PathVariable Long id){
		try {
			uniSer.removeUniversity(id);
		} catch (Exception e) {
			return new ResponseEntity<University>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<University>(HttpStatus.NO_CONTENT);
	}
	
	
}
