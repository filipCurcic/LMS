
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}