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

import app.entities.StudyCourse;
import app.services.StudyCourseService;

@Controller
@RequestMapping("/studyCourse")
public class StudyCourseController {
	
	@Autowired
	StudyCourseService stuCouSer;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<StudyCourse>> getUniversities(){
		return new ResponseEntity<Iterable<StudyCourse>>(stuCouSer.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<StudyCourse> getStudyCourse(@PathVariable Long id) {
		Optional<StudyCourse> uni = stuCouSer.getOne(id);
		if (uni.isPresent()) {
			return new ResponseEntity<StudyCourse>(uni.get(), HttpStatus.OK);
		}
		return new ResponseEntity<StudyCourse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<StudyCourse> addStudyCourse(@RequestBody StudyCourse stuCou){
		stuCouSer.addStudyCourse(stuCou);
		return new ResponseEntity<StudyCourse>(stuCou, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StudyCourse> deleteStudyCourse(@PathVariable Long id){
		try {
			stuCouSer.removeStudyCourse(id);
		} catch (Exception e) {
			return new ResponseEntity<StudyCourse>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StudyCourse>(HttpStatus.NO_CONTENT);
	}

}
