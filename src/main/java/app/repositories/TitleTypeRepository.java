
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.TitleType;

@Repository
public interface TitleTypeRepository extends CrudRepository<TitleType, Long> {
}