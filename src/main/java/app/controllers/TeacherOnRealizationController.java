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

import app.entities.TeacherOnRealization;
import app.services.TeacherOnRealizationService;
import app.utils.View.HideOptionalProperties;


@CrossOrigin(origins= {"http://localhost:4200"} ) 
@RestController 
@RequestMapping( "/teacher-on-realization" ) 
public class TeacherOnRealizationController {
	
	@Autowired
	TeacherOnRealizationService ts;
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping("/all")
	public ResponseEntity<Iterable<TeacherOnRealization>> getTeachersOnRealization() {
		return new  ResponseEntity<Iterable<TeacherOnRealization>>(ts.getTeachersOnRealization(), HttpStatus.OK);

	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<TeacherOnRealization> addTeacherOnRealization(@RequestBody TeacherOnRealization teacherOnRealization) {
		ts.addTeacherOnRealization(teacherOnRealization);
		return new ResponseEntity<TeacherOnRealization>(teacherOnRealization, HttpStatus.OK);
	}


	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<TeacherOnRealization> getTeacherOnRealizationById(@PathVariable Long id) {
        Optional<TeacherOnRealization> teacherOnRealization = ts.getOne(id);
        if(teacherOnRealization.isPresent()) {
            return new ResponseEntity<TeacherOnRealization>(teacherOnRealization.get(), HttpStatus.OK);
        }
        return new ResponseEntity<TeacherOnRealization>(HttpStatus.NOT_FOUND);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TeacherOnRealization> removeTeacherOnRealization(@PathVariable Long id) {
		try {
			ts.removeTeacherOnRealization(id);
		} catch (Exception e) {
			return new ResponseEntity<TeacherOnRealization>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TeacherOnRealization>(HttpStatus.NO_CONTENT);
	}

}
