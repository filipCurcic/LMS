
package app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.StudyYear;

@Repository
public interface StudyYearRepository extends JpaRepository<StudyYear, Long> {
	
	@Query("SELECT s from StudyYear s WHERE s.studyYear=?1 and s.studyCoures.id=?2")
	Optional<StudyYear> getNextYear(int studyYear, Long id);
	
}