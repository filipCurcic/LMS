
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.CourseRealization;

@Repository
public interface CourseRealizationRepository extends JpaRepository<CourseRealization, Long> {
	
	Iterable<CourseRealization> findByStudyYearId(Long id);
}