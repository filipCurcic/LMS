package app.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Exam;
import app.entities.ExamTopic;
import app.repositories.ExamRepository;



@Service
public class ExamService {
	
	@Autowired
	ExamRepository exRep;
	
	@Autowired
	ExamTopicService examTopicService;
	
	
	public Iterable<Exam> getAll(){
		return exRep.findAll();
	}
	
	
	public Optional<Exam> getOne(Long id){
		return exRep.findById(id);
	}
	
	@Transactional
	public void addExam(Exam exam) {
		Exam e = new Exam(exam.getStartTime(), exam.getEndTime(), exam.getPoints(), exam.getDurationInMinutes(),
				exam.getCourseRealization(), exam.getExamType(), exam.getExamRealizations(), exam.getSyllabus());
		e.setSyllabus(null);
		e.setId(exRep.save(e).getId());
		for (ExamTopic examTopic : exam.getSyllabus()) {
			examTopic.setExam(e);
			examTopicService.addExamTopic(examTopic);
		}
	}

	
	public void removeExam(Long id) {
		Optional<Exam> is = exRep.findById(id);
		exRep.delete(is.get());
	}
	
	

}
