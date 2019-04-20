
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.University;

@Repository
public interface UniversityRepository extends CrudRepository<University, Long> {
}
