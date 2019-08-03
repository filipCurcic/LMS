package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.ExamTopic;
import app.repositories.ExamTopicRepository;

@Service
public class ExamTopicService {

	@Autowired
	ExamTopicRepository examTopicRepository;
	
	public Iterable<ExamTopic> getExamTopics() {
        return examTopicRepository.findAll();
    }

    public Optional<ExamTopic> getExamTopicById(Long id) {
        return examTopicRepository.findById(id);
    }
	
	public void addExamTopic(ExamTopic examTopic) {
		examTopicRepository.save(examTopic);
    }
	
	public void removeExamTopic(Long id) {
        Optional<ExamTopic> examTopic = examTopicRepository.findById(id);
        examTopicRepository.delete(examTopic.get());
    }

    public void updateExamTopic(Long id, ExamTopic examTopic) {
        Optional<ExamTopic> e = examTopicRepository.findById(id);
        if(e.isPresent()) {
        	examTopic.setId(e.get().getId());
        	examTopicRepository.save(examTopic);
        }
    }
}
