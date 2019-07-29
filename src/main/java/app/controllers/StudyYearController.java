package app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import app.entities.StudyYear;
import app.services.StudyYearService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/study-year")
public class StudyYearController {
	
	@Autowired
	StudyYearService studyYearSer;
	
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping("/all")
	public ResponseEntity<Iterable<StudyYear>> getStudyYears(){
		return new ResponseEntity<Iterable<StudyYear>>(studyYearSer.getAll(), HttpStatus.OK);
	}
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<StudyYear> getStudyYearById(@PathVariable Long id) {
        Optional<StudyYear> studyYear = studyYearSer.getOne(id);
        if(studyYear.isPresent()) {
            return new ResponseEntity<StudyYear>(studyYear.get(), HttpStatus.OK);
        }
        return new ResponseEntity<StudyYear>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Secured("ROLE_ADMINISTRATOR_STAFF")
	public ResponseEntity<StudyYear> addStudyYear(@RequestBody StudyYear studyYear){
		studyYearSer.addStudyYear(studyYear);
		return new ResponseEntity<StudyYear>(studyYear, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StudyYear> deleteStudyYear(@PathVariable Long id){
		try {
			studyYearSer.removeStudyYear(id);
		} catch (Exception e) {
			return new ResponseEntity<StudyYear>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StudyYear>(HttpStatus.NO_CONTENT);
	}
	
//    @RequestMapping(value="/course/{studyYearId}", method=RequestMethod.GET)
//    public ResponseEntity<ArrayList<Course>> getStudyYears(@PathVariable Long studyYearId) {
//        return new ResponseEntity<ArrayList<Course>>(studyYearSer.getCourse(studyYearId), HttpStatus.OK);
//    }


}
