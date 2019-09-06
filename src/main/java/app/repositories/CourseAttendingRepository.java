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
	
	@Query("SELECT AVG(ca.grade) FROM CourseAttending ca WHERE ca.student.registeredUser.username = ?1")
	Double findAverageMark(String studentUsername);
	
	@Query("SELECT ca.student FROM CourseAttending ca WHERE ca.grade < 6 AND ca.courseRealization.course.id = ?1")
	Iterable<Student> findStudentsWhoDidntPassExam(Long courseId);
	
	@Query("SELECT DISTINCT ca.courseRealization.course FROM CourseAttending ca WHERE ca.student.registeredUser.username = ?1 AND ca.grade IS NULL")
	ArrayList<Course> findCurrentCourses(String username);
	
	@Query("SELECT ca.grade, ca.courseRealization.course.name, ca.courseRealization.studyYear.studyYear, "
			+ "ca.courseRealization.studyYear.studyCourse.name, er.points, er.exam.startTime, ca.courseRealization.course.espb \n" + 
			"FROM ExamRealization er, CourseAttending ca \n" + 
			"WHERE ca.student.registeredUser.username = ?1 \n" + 
			"AND ca.courseRealization.id = er.exam.courseRealization.id "
			+ "AND ca.grade IS NOT NULL")
	ArrayList<Object> findPastCourses(String username);
	
//	@Query("SELECT ca.student FROM CourseAttending ca, TeacherOnRealization tr "
//			+ "WHERE ca.courseRealization.course.id = ?1 "
//			+ "AND ca.courseRealization.studyYear.startDate <= ?2 "
//			+ "AND ca.courseRealization.studyYear.endDate >= ?2 "
//			+ "AND ca.courseRealization.course = tr.courseRealization.course"
//			+ "AND tr.teacher.registeredUser.username = ?3")
//	ArrayList<Student> findStudentsByCourse(Long courseId, Date today, String teacherUsername);
	
	
	@Query("SELECT ca FROM CourseAttending ca WHERE ca.student.id=?1")
	List<CourseAttending> getExamsForStudent(Long studentId);
	
}