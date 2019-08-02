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

import app.entities.StudentOnYear;
import app.services.StudentOnYearService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/student-on-year")
public class StudentOnYearController {
	
	@Autowired
	StudentOnYearService stuOnYSer;
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping("/all")
	public ResponseEntity<Iterable<StudentOnYear>> getUniversities(){
		return new ResponseEntity<Iterable<StudentOnYear>>(stuOnYSer.getAll(), HttpStatus.OK);
	}
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<StudentOnYear> getStudentOnYearById(@PathVariable Long id) {
        Optional<StudentOnYear> studentOnYear= stuOnYSer.getOne(id);
        if(studentOnYear.isPresent()) {
            return new ResponseEntity<StudentOnYear>(studentOnYear.get(), HttpStatus.OK);
        }
        return new ResponseEntity<StudentOnYear>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<StudentOnYear> addStudentOnYear(@RequestBody StudentOnYear stuOnY){
		stuOnYSer.addStudentOnYear(stuOnY);
		return new ResponseEntity<StudentOnYear>(stuOnY, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StudentOnYear> deleteStudentOnYear(@PathVariable Long id){
		try {
			stuOnYSer.removeStudentOnYear(id);
		} catch (Exception e) {
			return new ResponseEntity<StudentOnYear>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StudentOnYear>(HttpStatus.NO_CONTENT);
	}

}
