
package app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	
	@Query("SELECT ci.name FROM City ci WHERE ci.country.id = ?1")
	Iterable<Optional<City>> getAllByCountry (Long countryId);
}