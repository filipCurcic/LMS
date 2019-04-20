
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.StudyCourse;

@Repository
public interface StudyCourseRepository extends CrudRepository<StudyCourse, Long> {
}