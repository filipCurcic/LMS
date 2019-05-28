package app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.dto.StudyCourseDto;
import app.entities.StudyCourse;
import app.mappers.StudyCoureseMapper;
import app.services.StudyCourseService;

@Controller
@RequestMapping("/study-course")
public class StudyCourseController {
	
	@Autowired
	StudyCourseService stuCouSer;
	
	@Autowired
	StudyCoureseMapper studyCourseMapper;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<StudyCourseDto>> getUniversities(){
		List<StudyCourse> studyCourse = stuCouSer.getAll();
		return ResponseEntity.ok(studyCourseMapper.toDTO(studyCourse));
	}
	
	@RequestMapping("/{id}")
	public StudyCourseDto getStudyCourse(@PathVariable Long id) {
		StudyCourse studyCourse = stuCouSer.getOne(id);
		return studyCourseMapper.toDTO(studyCourse);
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
