package app.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonView;

import app.dto.ExamDTO;
import app.dto.ExamRegistrationDTO;
import app.dto.StudentExamRegistrationDTO;
import app.entities.Exam;
import app.entities.ExamType;
import app.services.ExamService;
import app.utils.View;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@Controller
@RequestMapping("/exam")
public class ExamController {
	
	@Autowired
	ExamService exSer;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/all")
	public ResponseEntity<Iterable<Exam>> getExams() {
		return new ResponseEntity<Iterable<Exam>>(exSer.getAll(), HttpStatus.OK);
	}
	
//	@RequestMapping("/all/student/{studentId}")
//	public ResponseEntity<Iterable<Exam>> getExamsForStudent(@PathVariable Long studentId) {
//		return new ResponseEntity<Iterable<Exam>>(exSer.getExamsForStudent(studentId), HttpStatus.OK);
//	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Exam> addExam(@RequestBody Exam exam) {
		exSer.addExam(exam);
		return new ResponseEntity<Exam>(exam, HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Exam> getExam(@PathVariable Long id) {
		
		return new ResponseEntity<Exam>(HttpStatus.NOT_FOUND);
		
		
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Exam> removeExam(@PathVariable Long id) {
		try {
			exSer.removeExam(id);
		} catch (Exception e) {
			return new ResponseEntity<Exam>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Exam>(HttpStatus.NO_CONTENT);
	}
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/types", method=RequestMethod.GET)
    public ResponseEntity<Iterable<ExamType>> getExamTypes() {
        return new ResponseEntity<Iterable<ExamType>>(exSer.getExamTypes(), HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{studentId}/exams", method=RequestMethod.GET)
    public ResponseEntity<Collection<ExamDTO>> getExamsByStudent(@PathVariable Long studentId){
    	Collection<ExamDTO> exams = exSer.getExamsByStudent(studentId);
    	if (exams.isEmpty()) return new ResponseEntity<Collection<ExamDTO>>(HttpStatus.NO_CONTENT);
    	return new ResponseEntity<Collection<ExamDTO>>(exams, HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/availableExams/{username}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<ExamRegistrationDTO>> getAvailableExamsForRegistration(@PathVariable String username) {
    	ArrayList<ExamRegistrationDTO> exams = exSer.getAvailableExamsForRegistration(username);
    	if (exams.size() == 0) return new ResponseEntity<ArrayList<ExamRegistrationDTO>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<ArrayList<ExamRegistrationDTO>>(exams, HttpStatus.OK);
    }
    
    @JsonView(View.HideOptionalProperties.class)
    @RequestMapping(value="/{teacherUsername}/{subjectId}/addGrades", method=RequestMethod.POST)
    public ResponseEntity<ArrayList<Exam>> addGrades(@PathVariable String teacherUsername, @PathVariable Long courseId, @ RequestBody ArrayList<StudentExamRegistrationDTO> studentGrades){
    	
    	try {
    		exSer.addGrades(courseId, teacherUsername, studentGrades);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
    }


}
