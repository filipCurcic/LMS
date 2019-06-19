package app.repositories;

import org.springframework.data.repository.CrudRepository;

import app.entities.ForumUser;

public interface ForumUserRepository extends CrudRepository<ForumUser, Long>{

}
