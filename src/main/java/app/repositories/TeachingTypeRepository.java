
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.TeachingType;

@Repository
public interface TeachingTypeRepository extends CrudRepository<TeachingType, Long> {
}