
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.TeacherOnRealization;

@Repository
public interface TeacherOnRealizationRepository extends CrudRepository<TeacherOnRealization, Long> {
}