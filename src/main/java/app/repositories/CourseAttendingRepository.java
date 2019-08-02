package app.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.Course;
import app.entities.CourseAttending;
import app.entities.Student;

@Repository
public interface CourseAttendingRepository extends JpaRepository<CourseAttending, Long> {
	
	@Query("SELECT AVG(ca.grade) FROM CourseAttending ca WHERE ca.student.id = ?1")
	Double findAverageMark(Long studentId);
	
	@Query("SELECT ca.student FROM CourseAttending ca WHERE ca.grade < 6 AND ca.courseRealization.course.id = ?1")
	Iterable<Student> findStudentsWhoDidntPassExam(Long courseId);
	
	@Query("SELECT DISTINCT ca.courseRealization.course FROM CourseAttending ca WHERE ca.student.registeredUser.username = ?1 AND ca.grade IS NULL")
	ArrayList<Course> findCurrentsCourse(String username);
	
//	@Query("SELECT ca.grade, ca.courseRealization.course.name, ca.courseRealization.studyYear.studyYear, "
//			+ "ca.courseRealization.studyYear.studyCourse.name, er.points, er.exam.startTime, sa.subjectRealization.subject.ects \n" + 
//			"FROM ExamRealization er, SubjectAttendance sa \n" + 
//			"WHERE sa.student.accountData.username = ?1 \n" + 
//			"AND sa.subjectRealization.id = er.exam.subjectRealization.id "
//			+ "AND sa.finalGrade IS NOT NULL")
//	ArrayList<Object> findPastCourses(String username);
//	
//	@Query("SELECT sa.student FROM SubjectAttendance sa, TeacherRealization tr "
//			+ "WHERE sa.subjectRealization.subject.id = ?1 "
//			+ "AND sa.subjectRealization.yearOfStudy.startDate <= ?2 "
//			+ "AND sa.subjectRealization.yearOfStudy.endDate >= ?2 "
//			+ "AND sa.subjectRealization.subject = tr.subjectRealization.subject "
//			+ "AND tr.teacher.accountData.username = ?3")
//	ArrayList<Student> findStudentsBySubject(Long subjectId, Date today, String teacherUsername);
//	
	
	@Query("SELECT ca FROM CourseAttending ca WHERE ca.student.id=?1")
	List<CourseAttending> getExamsForStudent(Long studentId);
	
}