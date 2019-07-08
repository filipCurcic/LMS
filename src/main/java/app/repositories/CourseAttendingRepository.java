
package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.dto.CourseAttendingDto;
import app.entities.CourseAttending;

@Repository
public interface CourseAttendingRepository extends JpaRepository<CourseAttending, Long> {
	
	@Query("SELECT ca FROM CourseAttending ca WHERE ca.student.id=?1")
	List<CourseAttending> getExamsForStudent(Long studentId);
	
}