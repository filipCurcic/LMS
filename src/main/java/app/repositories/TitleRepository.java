
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.Title;

@Repository
public interface TitleRepository extends CrudRepository<Title, Long> {
}