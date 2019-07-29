package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Exam;
import app.repositories.ExamRepository;



@Service
public class ExamService {
	
	@Autowired
	ExamRepository exRep;
	
	
	public Iterable<Exam> getAll(){
		return exRep.findAll();
	}
	
	public Iterable<Exam> getExamsForStudent(Long studentId){
		return exRep.getExamsForStudent(studentId);
	}
	
	public Optional<Exam> getOne(Long id){
		return exRep.findById(id);
	}
	
	public void addExam(Exam fac) {
		exRep.save(fac);
	}
	
	public void removeExam(Long id) {
		Optional<Exam> is = exRep.findById(id);
		exRep.delete(is.get());
	}

}
