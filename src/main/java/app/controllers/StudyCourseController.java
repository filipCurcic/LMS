package app.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.dto.StudyCourseDto;
import app.entities.Student;
import app.entities.StudyCourse;
import app.mappers.StudyCoureseMapper;
import app.services.FileService;
import app.services.StudyCourseService;

@Controller
@RequestMapping("/study-course")
public class StudyCourseController {
	
	@Autowired
	FileService fileService;
	
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
	
	// Get Course by Faculty id
	@RequestMapping("/faculty/{id}")
	public ResponseEntity<Iterable<StudyCourseDto>> getCourseOnFaculty(@PathVariable Long id){
		List<StudyCourse> studyCourse = stuCouSer.getCourseOnFaculty(id);
		return ResponseEntity.ok(studyCourseMapper.toDTO(studyCourse));
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<StudyCourse> addStudyCourse(@RequestBody StudyCourse stuCou){
		stuCouSer.addStudyCourse(stuCou);
		return new ResponseEntity<StudyCourse>(stuCou, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Secured("ROLE_ADMINISTRATOR")
	public ResponseEntity<StudyCourse> addStudyCoourse(@RequestPart("courseImages") MultipartFile file, @RequestPart("data") String studyCourseStr) throws IOException {
		StudyCourse studyCourse = new ObjectMapper().readValue(studyCourseStr, StudyCourse.class);
		fileService.addStudyCourseImage(file, "studyCourse_img", studyCourse);
		stuCouSer.addStudyCourse(studyCourse);
		return new ResponseEntity<StudyCourse>(studyCourse, HttpStatus.OK);
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
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<StudyCourse> updateStudent(@PathVariable Long id, @RequestPart("courseImages") Optional<MultipartFile> file, @RequestPart("data") String studyCourse) throws IOException {
    	StudyCourse sc = new ObjectMapper().readValue(studyCourse, StudyCourse.class);
		if(file.isPresent()) {
			fileService.addStudyCourseImage(file.get(), "teacher" + sc.getId(), sc);
		}
    	stuCouSer.updateStudyCourse(id, sc);
        return new ResponseEntity<StudyCourse>(sc, HttpStatus.OK);
    }

}
