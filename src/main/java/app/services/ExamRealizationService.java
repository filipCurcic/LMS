package app.services;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.StudentExamRegistrationDTO;
import app.entities.Exam;
import app.entities.ExamRealization;
import app.repositories.ExamRealizationRepository;
import app.repositories.ExamRepository;
import app.repositories.StudentOnYearRepository;

@Service
public class ExamRealizationService {

	@Autowired
	ExamRealizationRepository examRealizationRepository;
	
	@Autowired
	StudentOnYearRepository studentOnYearRepository;
	
	@Autowired
	ExamRepository examRepository;
	
	public ArrayList<ExamRealization> getRegisteredExamsByStudent(Long studentId) {
		return examRealizationRepository.findRegisteredExamsByStudentId(studentId);
	}

	public boolean registerExam(Long examId, Long courseRealId, String studentUsername) {
		try {
			Long studentOnYearId = studentOnYearRepository.getStudentOnYearByCourseRealizationAndStudent(courseRealId, studentUsername);
			Exam exam = examRepository.findById(examId).get();
			if (studentOnYearId != null && exam != null) {
				ExamRealization er = new ExamRealization();
				er.setExam(exam);
				er.setNote("");
				er.setPoints(null);
				er.setStudentOnYear(studentOnYearRepository.findById(studentOnYearId).get());
				examRealizationRepository.saveAndFlush(er);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

		
	public ArrayList<StudentExamRegistrationDTO> getRegisteredExamsBySubject(Long courseId, String teacherUsername) {
		Calendar today = Calendar.getInstance();
		today.setTime(new Date());
		Calendar beforeFifteen = Calendar.getInstance();
		beforeFifteen.setTime(new Date());
		beforeFifteen.add(Calendar.DATE, -15);
		ArrayList<Object[]> fetched = examRealizationRepository.findRegisteredExamsByCourse(courseId, teacherUsername,
				beforeFifteen.getTime(), today.getTime());
		ArrayList<StudentExamRegistrationDTO> registrations = new ArrayList<StudentExamRegistrationDTO>(fetched.size());
		if (fetched.size() > 0) {
			try {
				for (int i = 0; i < fetched.size(); i++) {
					registrations.add(new StudentExamRegistrationDTO((String) fetched.get(i)[0],
							(String) fetched.get(i)[1], (String) fetched.get(i)[2], (Long) fetched.get(i)[3],
							(Long) fetched.get(i)[4], (Long) fetched.get(i)[5], (Long) fetched.get(i)[6], (Long) fetched.get(i)[7]));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return registrations;
	}

	public void add(ExamRealization er) {
		examRealizationRepository.save(er);
	}
	
	public Optional<ExamRealization> findById(Long id) {
		return examRealizationRepository.findById(id);
	}

	public void updateById(Long id, ExamRealization newER) {
		Optional<ExamRealization> er = examRealizationRepository.findById(id);
		if(er.isPresent()) {
			newER.setId(er.get().getId());
			examRealizationRepository.save(newER);		
		}
	}
	
}
