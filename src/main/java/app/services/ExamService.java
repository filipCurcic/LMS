package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Exam;
import app.repositories.ExamRepository;



@Service
public class ExamService {
	
	@Autowired
	ExamRepository exRep;
	
	
	public List<Exam> getAll(){
		return exRep.findAll();
	}
	
	public List<Exam> getExamsForStudent(Long studentId){
		return exRep.getExamsForStudent(studentId);
	}
	
	public Exam getOne(Long id){
		return exRep.findById(id).orElse(null);
	}
	
	public void addExam(Exam fac) {
		exRep.save(fac);
	}
	
	public void removeExam(Long id) {
		Optional<Exam> is = exRep.findById(id);
		exRep.delete(is.get());
	}

}
