
package app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.StudyYear;

@Repository
public interface StudyYearRepository extends JpaRepository<StudyYear, Long> {
	
	StudyYear findFirstByStudyYear(Integer studyYear);
	
	//ArrayList<StudyYear> findByStudyCourseIdEquals(Long studyCourseId);
	
	@Query("SELECT s from StudyYear s WHERE s.studyYear=?1 and s.studyCourse.id=?2")
	Optional<StudyYear> getNextYear(int studyYear, Long id);
	
}