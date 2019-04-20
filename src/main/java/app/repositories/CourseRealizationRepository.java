
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.CourseRealization;

@Repository
public interface CourseRealizationRepository extends CrudRepository<CourseRealization, Long> {
}