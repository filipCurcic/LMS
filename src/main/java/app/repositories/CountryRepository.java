
package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
}