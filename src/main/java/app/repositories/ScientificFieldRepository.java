
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.ScientificField;

@Repository
public interface ScientificFieldRepository extends CrudRepository<ScientificField, Long> {
}