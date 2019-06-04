package app.services;

import java.util.List;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Student;
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
	
	public List<StudentOnYear> getIndex(Long id) {
		return stuOnYRep.findIndeksByStudentId(id);
	}
	
	
}
