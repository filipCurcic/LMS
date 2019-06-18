package app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entities.Administrator;

public interface AdministatorRepository extends JpaRepository<Administrator, Long> {

	@Query("SELECT a FROM Administrator a WHERE a.registeredUser.username = ?1")
	Optional<Administrator> getByUsername(String username);
	
}
