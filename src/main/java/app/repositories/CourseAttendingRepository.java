
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.CourseAttending;

@Repository
public interface CourseAttendingRepository extends CrudRepository<CourseAttending, Long> {
}