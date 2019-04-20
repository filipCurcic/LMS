
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.CourseOutcome;

@Repository
public interface CourseOutcomeRepository extends CrudRepository<CourseOutcome, Long> {
}