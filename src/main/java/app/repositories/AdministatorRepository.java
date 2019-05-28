package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Administrator;

public interface AdministatorRepository extends JpaRepository<Administrator, Long> {

}
