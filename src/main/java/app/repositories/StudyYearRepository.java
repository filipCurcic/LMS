
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.StudyYear;

@Repository
public interface StudyYearRepository extends JpaRepository<StudyYear, Long> {
}