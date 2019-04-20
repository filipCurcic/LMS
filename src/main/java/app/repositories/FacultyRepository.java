
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.Faculty;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Long> {
}