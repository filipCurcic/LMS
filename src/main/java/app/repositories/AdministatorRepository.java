package app.repositories;

import org.springframework.data.repository.CrudRepository;

import app.entities.Administrator;

public interface AdministatorRepository extends CrudRepository<Administrator, Long> {

}
