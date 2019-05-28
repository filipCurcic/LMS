package app.controllers;

import java.util.List;
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

import app.dto.TeacherOnRealizationDto;
import app.entities.TeacherOnRealization;
import app.mappers.TeacherOnRealizationMapper;
import app.services.TeacherOnRealizationService;


@CrossOrigin(origins= {"http://localhost:4200"} ) 
@RestController 
@RequestMapping( "/teacher-on-realization" ) 
public class TeacherOnRealizationController {
	@Autowired
	TeacherOnRealizationService ts;
	
	@Autowired
	TeacherOnRealizationMapper teacherOnRealizationMapper;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<TeacherOnRealizationDto>> getTeachersOnRealization() {
		List<TeacherOnRealization> teacherOnRealization = ts.getTeachersOnRealization();
		return ResponseEntity.ok(teacherOnRealizationMapper.toDTO(teacherOnRealization));

	}
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<TeacherOnRealization> addTeacherOnRealization(@RequestBody TeacherOnRealization teacherOnRealization) {
		ts.addTeacherOnRealization(teacherOnRealization);
		return new ResponseEntity<TeacherOnRealization>(teacherOnRealization, HttpStatus.OK);
	}


	@RequestMapping("/{id}")
	public TeacherOnRealizationDto getOne(@PathVariable Long id) {
		TeacherOnRealization teacherOnRealization = ts.getOne(id);
		return teacherOnRealizationMapper.toDTO(teacherOnRealization);
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
