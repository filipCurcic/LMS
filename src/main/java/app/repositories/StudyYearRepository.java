
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.StudyYear;

@Repository
public interface StudyYearRepository extends CrudRepository<StudyYear, Long> {
}