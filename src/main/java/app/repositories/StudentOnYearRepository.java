
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.StudentOnYear;

@Repository
public interface StudentOnYearRepository extends CrudRepository<StudentOnYear, Long> {
}