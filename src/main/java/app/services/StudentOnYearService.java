package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.StudentOnYear;
import app.repositories.StudentOnYearRepository;

@Service
public class StudentOnYearService {

	@Autowired
	StudentOnYearRepository stuOnYRep;
	
	public List<StudentOnYear> getAll(){
		return stuOnYRep.findAll();
	}
	
	public StudentOnYear getOne(Long id){
		return stuOnYRep.findById(id).orElse(null);
	}
	
	public void addStudentOnYear(StudentOnYear stuOnY) {
		stuOnYRep.save(stuOnY);
	}
	
	public void removeStudentOnYear(Long id) {
		Optional<StudentOnYear> is = stuOnYRep.findById(id);
		stuOnYRep.delete(is.get());
	}
	
	 public void updateStudentOnYear(Long id, StudentOnYear studentOnYear) {
	        Optional<StudentOnYear> stu = stuOnYRep.findById(id);
	        if(stu.isPresent()) {
	            studentOnYear.setId(stu.get().getId());
	            stuOnYRep.save(studentOnYear);
	        }
	    }
	 
     public Optional<StudentOnYear> getStudentYearByYearOfStudyId(Long id) {
        return stuOnYRep.findById(id);
	    }

	
}
