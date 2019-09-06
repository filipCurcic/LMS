package app.repositories;

import java.util.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.ExamRealization;

@Repository
public interface ExamRealizationRepository extends JpaRepository<ExamRealization, Long> {

	@Query("SELECT er.id, er.exam.examType.name, er.exam.startTime, er.exam.endTime, er.exam.courseRealization.course.name "
			+ "FROM ExamRealization er " 
			+ "WHERE er.points IS NULL AND er.studentOnYear.student.id = ?1 AND er.exam.examType.name = 'FINAL' ")
	ArrayList<ExamRealization> findRegisteredExamsByStudentId(Long studentId);

	@Query("SELECT er.studentOnYear.student.name, er.studentOnYear.student.lastName, "
			+ "er.studentOnYear.indeks, er.studentOnYear.student.id,  cr.id, er.id, ca.id, er.studentOnYear.id "
			+ "FROM ExamRealization er, CourseRealization cr, TeacherOnRealization tr, CourseAttending ca "
			+ "WHERE er.points = NULL AND er.exam.examType.name = 'FINAL' AND (er.exam.endTime BETWEEN ?3 AND ?4) "
			+ "AND er.exam MEMBER OF cr.exams AND cr.course.id = ?1 "
			+ "AND tr.teacher.registeredUser.username = ?2 "
			+ "AND tr.courseRealization = cr AND ca.courseRealization = cr "
			+ "AND ca.student = er.studentOnYear.student")
	ArrayList<Object[]> findRegisteredExamsByCourse(Long courseId, String teacherUsername, Date beforeFifteen,
			Date today);
}
