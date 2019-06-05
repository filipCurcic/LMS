package app.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.dto.TeacherDto;
import app.entities.Teacher;
import app.mappers.TeacherMapper;
import app.services.FileService;
import app.services.TeacherService;

@CrossOrigin(origins= {"http://localhost:4200"} ) 
@RestController 
@RequestMapping( "/teacher" ) 
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	TeacherMapper teacherMapper;
	
	@Autowired
	FileService fileService;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<TeacherDto>> getTeachers() {
		List<Teacher> teacher = teacherService.getTeachers();
		return ResponseEntity.ok(teacherMapper.toDTO(teacher));

	}


	@RequestMapping("/{id}")
	public TeacherDto getOne(@PathVariable Long id) {
		Teacher teacher = teacherService.getOne(id);
		return teacherMapper.toDTO(teacher);
	}
	
	@RequestMapping(value="/username/{username}", method=RequestMethod.GET)
    public ResponseEntity<Teacher> getTeacherByUsername(@PathVariable String username) {
        Optional<Teacher> teacher = teacherService.getStudentByUsername(username);
        if(teacher.isPresent()) {
            return new ResponseEntity<Teacher>(teacher.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
    }

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Secured("ROLE_ADMINISTRATOR")
	public ResponseEntity<Teacher> uploadFile(@RequestPart("profileImage") MultipartFile file, @RequestPart("data") String teacherStr) throws IOException {
		Teacher teacher = new ObjectMapper().readValue(teacherStr, Teacher.class);
		fileService.addProfileImageTeacher(file, "teacher_" + teacher.getRegisteredUser().getUsername(), teacher);
		teacherService.addTeacher(teacher);
		return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Teacher> removeTeacher(@PathVariable Long id) {
		try {
			teacherService.removeTeacher(id);
		} catch (Exception e) {
			return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Teacher> updateTeacher(@PathVariable String username, @RequestPart("profileImage") Optional<MultipartFile> file, @RequestPart("data") String teacher) throws IOException {
    	Teacher t = new ObjectMapper().readValue(teacher, Teacher.class);
		if(file.isPresent()) {
			fileService.addProfileImageTeacher(file.get(), "teacher" + t.getRegisteredUser().getUsername(), t);
		}
    	teacherService.updateTeacher(username, t);
        return new ResponseEntity<Teacher>(t, HttpStatus.OK);
    }
}
