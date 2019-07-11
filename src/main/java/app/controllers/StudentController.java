package app.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.dto.StudentDto;
import app.entities.Student;
import app.mappers.StudentMapper;
import app.services.FileService;
import app.services.StudentService;
import app.utils.GeneratePDF;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService stuSer;
	
	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	FileService fileService;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<StudentDto>> getStudent(){
		List<Student> student= stuSer.getAll();
		return ResponseEntity.ok(studentMapper.toDTO(student));	
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable Long id) {
		Student student = stuSer.getOne(id);
		return new ResponseEntity<StudentDto>(studentMapper.toDTO(student), HttpStatus.OK);
	}
	
	@RequestMapping("/username/{username}")
	public ResponseEntity<StudentDto> getStudentUsername(@PathVariable String username) {
		Student student = stuSer.getStudentByUsernamee(username);
		return new ResponseEntity<StudentDto>(studentMapper.toDTO(student), HttpStatus.OK);
	}
	
	//registered user(only for student)
	@RequestMapping("/logged/{username}")
	public ResponseEntity<StudentDto> getLoggedStudent(@PathVariable String username) {
		Student student = stuSer.getLoggedStudent(username);
		return new ResponseEntity<StudentDto>(studentMapper.toDTO(student), HttpStatus.OK);
	}
	
	@RequestMapping(value="/findByName/{name}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Optional<Student>>> getStudentsByFirstName(@PathVariable String firstName) {
		Iterable<Optional<Student>> students = stuSer.getStudentsByFirstName(firstName);
	    return new ResponseEntity<Iterable<Optional<Student>>>(students, HttpStatus.OK);
    }
	    
	@RequestMapping(value="/findByJmbg/{jmbg}", method=RequestMethod.GET)
	public ResponseEntity<Student> getStudentByJmbg(@PathVariable String jmbg) {
	    Optional<Student> student = stuSer.getStudentByJmbg(jmbg);
	       if(student.isPresent()) {
	           return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
	       }
	       return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}
	
//	@RequestMapping(value="/username/{username}", method=RequestMethod.GET)
//    public ResponseEntity<Student> getStudentByUsername(@PathVariable String username) {
//        Optional<Student> student = stuSer.getStudentByUsername(username);
//        if(student.isPresent()) {
//            return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
//    }

	    
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Transactional
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR_STAFF','ROLE_ADMINISTRATOR')")
	public ResponseEntity<Student> addStudent(@RequestPart("profileImage") MultipartFile file, @RequestPart("data") String studentStr) throws IOException {
		System.out.println("controller");
		Student student = new ObjectMapper().readValue(studentStr, Student.class);
		System.out.println("controller1");
		fileService.addProfileImageStudent(file, "student_" + student.getRegisteredUser().getUsername(), student);
		System.out.println("controller2");
		stuSer.addStudent(student);
		System.out.println("controller4");
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Student> add(@RequestBody Student student) {
		stuSer.addStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@RequestMapping(value="/username/{username}", method=RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Student> updateStudent(@PathVariable String username, @RequestPart("profileImage") Optional<MultipartFile> file, @RequestPart("data") String student) throws IOException {
    	Student s = new ObjectMapper().readValue(student, Student.class);
		if(file.isPresent()) {
			fileService.addProfileImageStudent(file.get(), "teacher" + s.getRegisteredUser().getUsername(), s);
		}
    	stuSer.updateStudent(username, s);
        return new ResponseEntity<Student>(s, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
		try {
			stuSer.removeStudent(id);
		} catch (Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Student> softDeleteStudent(@PathVariable Long id){
		try {
			stuSer.deleteStudent(id);
		} catch (Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
    @RequestMapping(value = "/pdf", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> exportStudentsToPDF() {

        ByteArrayInputStream bis = GeneratePDF.students((List<Student>)stuSer.getAll());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=students.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
