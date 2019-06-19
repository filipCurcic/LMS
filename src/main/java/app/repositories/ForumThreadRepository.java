package app.repositories;

import org.springframework.data.repository.CrudRepository;

import app.entities.ForumThread;

public interface ForumThreadRepository extends CrudRepository<ForumThread, Long>{

}
