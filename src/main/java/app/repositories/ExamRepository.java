package app.repositories;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.Exam;


@Repository
public interface ExamRepository extends JpaRepository<Exam, Long>{
	
	@Query("SELECT ca.grade, ca.courseRealization.course.name, ca.courseRealization.studyYear.studyYear, ca.courseRealization.studyYear.studyCourse.name, er.points, er.exam.startTime, ca.courseRealization.course.espb "
			+ "FROM ExamRealization er, CourseAttending ca "
			+ "WHERE ca.student.id = ?1 AND ca.grade IS NOT NULL AND er.points IS NOT NULL AND er.exam.examType.name = 'FINAL' "
			+ "AND ca.courseRealization.id = er.exam.courseRealization.id")
	ArrayList<Object[]> getExamsByStudent(Long studentId);
	
	@Query("SELECT e.id, e.courseRealization.id, e.courseRealization.course.name, e.startTime, e.durationInMinutes, e.examType.name, "
			+ "e.courseRealization.studyYear.studyYear, e.courseRealization.studyYear.studyCourse.name "
			+ "FROM Exam e, CourseAttending ca "
			+ "WHERE e.courseRealization = ca.courseRealization "
			+ "AND ca.grade IS NULL "
			+ "AND ca.student.registeredUser.username = ?1 "
			+ "AND e.startTime BETWEEN ?2 AND ?3 \n"
			+ "AND e.examType.name = 'FINAL' "
			+ "AND e NOT IN (SELECT er.exam FROM ExamRealization er WHERE er.studentOnYear.student.registeredUser.username = ?1)")
	ArrayList<Object[]> getAvailableExamsForRegistration(String studentUsername, Date plusThree, Date plusFourteen);
	
	@Query("SELECT e FROM Exam e, TeacherOnRealization tr WHERE e.courseRealization.course.id = ?1 "
			+ "AND e.examType.name = 'TEST2'"
			+ "AND tr.teacher.registeredUser.username = ?2 "
			+ "AND e.courseRealization = tr.courseRealization")
	Exam getTest2ByCourse(Long courseId, String teacherUsername);
	
	@Query("SELECT e FROM Exam e, TeacherOnRealization tr WHERE e.courseRealization.course.id = ?1 "
			+ "AND e.examType.name = 'TEST1'"
			+ "AND tr.teacher.registeredUser.username = ?2 "
			+ "AND e.courseRealization = tr.courseRealization")
	Exam getTest1ByCourse(Long courseId, String teacherUsername);
	
	@Query("SELECT e FROM Exam e, TeacherOnRealization tr WHERE e.courseRealization.course.id = ?1 "
			+ "AND e.examType.name = 'FINAL'"
			+ "AND tr.teacher.registeredUser.username = ?2 "
			+ "AND e.courseRealization = tr.courseRealization")
	Exam getFinalExamBySubject(Long courseId, String teacherUsername);

}
