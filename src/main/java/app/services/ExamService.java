package app.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.ExamDTO;
import app.dto.ExamRegistrationDTO;
import app.dto.StudentExamRegistrationDTO;
import app.entities.CourseAttending;
import app.entities.Exam;
import app.entities.ExamRealization;
import app.entities.ExamTopic;
import app.entities.ExamType;
import app.repositories.ExamRepository;
import app.repositories.ExamTypeRepository;



@Service
public class ExamService {
	
	@Autowired
	ExamRepository exRep;
	
	@Autowired
	ExamTopicService examTopicService;
	
	@Autowired
	StudentOnYearService studentOnYearService;
	
	@Autowired
	ExamRealizationService examRealizationService;
	
	@Autowired
	CourseAttendingService courseAttendingService;
	
	@Autowired
	ExamTypeRepository examTypeRepository;
	
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
	
	public Iterable<ExamType> getExamTypes() {
		return examTypeRepository.findAll();
	}
	
	public ArrayList<ExamDTO> getExamsByStudent(Long studentId) {
		
		ArrayList<Object[]> fetched = exRep.getExamsByStudent(studentId);
		ArrayList<ExamDTO> results = new ArrayList<ExamDTO>();
		try {
			if (fetched != null && fetched.size() > 0) {
				for (int i = 0; i < fetched.size(); i++) {
					results.add(new ExamDTO( (int) fetched.get(i)[0], (String) fetched.get(i)[1], (int) fetched.get(i)[2],
							(String) fetched.get(i)[3], (int) fetched.get(i)[4], (Date) fetched.get(i)[5],
							(int) fetched.get(i)[6]) );
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		

		return results;
	}

	public ArrayList<ExamRegistrationDTO> getAvailableExamsForRegistration(String username) {
		Calendar plusThree = Calendar.getInstance();
		plusThree.setTime(new Date());
		plusThree.add(Calendar.DATE, 3);
		Calendar plusFourteen = Calendar.getInstance();
		plusFourteen.setTime(new Date());
		plusFourteen.add(Calendar.DATE, 14);
		ArrayList<Object[]> available = exRep.getAvailableExamsForRegistration(username, plusThree.getTime(),plusFourteen.getTime());
		ArrayList<ExamRegistrationDTO> exams = new ArrayList<ExamRegistrationDTO>(available.size());
		if (available.size() > 0) {
			for (int i = 0; i < available.size(); i++) {
				exams.add(new ExamRegistrationDTO((Long) available.get(i)[0], (Long) available.get(i)[1],
						(String) available.get(i)[2], (Date) available.get(i)[3], (int) available.get(i)[4],
						(String) available.get(i)[5], (int) available.get(i)[6], (String) available.get(i)[7]));
			}
		}
		return exams;

	}

	@Transactional
	public boolean addGrades(Long courseId, String teacherUsername,
			ArrayList<StudentExamRegistrationDTO> studentGrades) {

		try {
			Exam test1 = exRep.getTest1ByCourse(courseId, teacherUsername);
			Exam test2 = exRep.getTest2ByCourse(courseId, teacherUsername);
			for (StudentExamRegistrationDTO studentReg : studentGrades) {

				ExamRealization er = new ExamRealization();
				er.setExam(test1);
				er.setPoints(studentReg.getTest1());
				er.setStudentOnYear(studentOnYearService.getOne(studentReg.getStudentOnYearId()).get());
				examRealizationService.add(er);

				// create results of test2
				ExamRealization er2 = new ExamRealization();
				er2.setExam(test2);
				er2.setPoints(studentReg.getTest2());
				er.setStudentOnYear(studentOnYearService.getOne(studentReg.getStudentOnYearId()).get());
				examRealizationService.add(er);

				// update exam registration by adding points to exam realization
				ExamRealization finalE = examRealizationService.findById(studentReg.getExamRealizationId()).get();
				finalE.setPoints(studentReg.getFinalExam());
				examRealizationService.updateById(studentReg.getExamRealizationId(), finalE);

				// update subject attendance by adding grade
				CourseAttending courseAttending = courseAttendingService.getCourseAttending(studentReg.getCourseAttendanceId())
						.get();
				courseAttending.setGrade(studentReg.getGrade());
				courseAttendingService.updateCourseAttending(studentReg.getCourseAttendanceId(), courseAttending);
			}
			return true;

		} catch (Exception e) {
			return false;
		}

	}


}
