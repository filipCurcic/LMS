
package app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.StudentOnYear;

@Repository
public interface StudentOnYearRepository extends JpaRepository<StudentOnYear, Long> {
	
	Optional<StudentOnYear> findByStudyYearIdAndStudentId(Long studyYearId, Long studentId);
	
	@Query("SELECT soy.id FROM StudentOnYear soy JOIN soy.studyYear.courseRealizations cr "
			+ "WHERE  cr.id = ?1 "
			+ "AND soy.student.registeredUser.username = ?2")
	Long getStudentOnYearByCourseRealizationAndStudent(Long courseRealId, String studentUsername);
}