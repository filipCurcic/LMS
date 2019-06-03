
package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.StudyCourse;

@Repository
public interface StudyCourseRepository extends JpaRepository<StudyCourse, Long> {
	@Query("SELECT s FROM StudyCourse s WHERE s.faculty.id=?1")
	List<StudyCourse> getCourseOnFaculty(Long id);
}