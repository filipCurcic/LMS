
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}