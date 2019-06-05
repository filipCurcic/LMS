package app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entities.AdministratorStaff;
import app.entities.Student;

public interface AdministratorStaffRepository extends JpaRepository<AdministratorStaff, Long> {
	
	@Query("SELECT a FROM AdministratorStaff a WHERE a.registeredUser.username = ?1")
	Optional<AdministratorStaff> getByUsername(String username);
	
	@Query("SELECT DISTINCT s FROM Student s JOIN s.studentOnYear soy JOIN s.courseAttending ca JOIN ca.courseRealization cr WHERE s.studyYear=?2 AND soy.studyYear.studyCourse.name=?1 AND ca.grade IS NOT NULL GROUP BY s.id HAVING (SUM(cr.course.espb))>=(48*(s.studyYear))")
	Iterable<Student> findStudentsForEnrollmentToTheNextYear(String studyCourse, int studyYear);
	
}
