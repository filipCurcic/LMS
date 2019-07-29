package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
